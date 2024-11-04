import java.util.*;

class Solution {
    class Truck {
        int weight;  // 트럭의 무게
        int move;    // 트럭이 다리 위에서 이동한 거리

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;        // 트럭이 다리에 올라오면 1칸 이동한 상태로 시작
        }

        public void moving() {
            move++;  // 1초마다 트럭이 1칸씩 이동
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        // 대기 중인 트럭
        Queue<Truck> waitQ = new LinkedList<>();
        // 다리 위에서 이동 중인 트럭
        Queue<Truck> moveQ = new LinkedList<>();

        // 트럭 무게 순서대로 대기 큐에 넣음
        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;     // 총 경과 시간
        int curWeight = 0;  // 현재 다리 위에 있는 트럭들의 총 무게

        // 대기 큐와 이동 큐가 모두 빌 때까지 반복
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;  // 1초 경과

            // 다리 위에 트럭이 없을 때
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();  // 대기 중인 트럭을 꺼냄
                curWeight += t.weight;   // 현재 다리 위 총 무게에 트럭 무게 추가
                moveQ.offer(t);          // 트럭을 다리 위로 올림
                continue;
            }

            // 다리 위에 있는 트럭들을 1칸씩 이동
            for (Truck t : moveQ) {
                t.moving();
            }

            // 가장 앞에 있는 트럭이 다리 길이를 초과했을 경우
            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();  // 다리를 다 건넌 트럭을 큐에서 제거
                curWeight -= t.weight;   // 다리 위 총 무게에서 트럭 무게를 뺌
            }

            // 대기 중인 트럭이 있고, 다리 무게 제한을 넘지 않는 경우
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();  // 대기 중인 트럭을 꺼냄
                curWeight += t.weight;   // 다리 위 총 무게에 트럭 무게 추가
                moveQ.offer(t);          // 트럭을 다리 위로 올림
            }
        }

        return answer;
    }
}