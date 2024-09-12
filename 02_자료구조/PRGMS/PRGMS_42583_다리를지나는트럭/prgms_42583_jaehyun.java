import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 경과 시간
        int currentWeight = 0; // 현재 다리 위의 트럭 무게 합
        
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위 트럭을 관리하는 큐
        
        // 처음엔 다리가 비어 있으므로 bridge_length만큼 0으로 채운다
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int index = 0; // 트럭 배열에서 처리할 트럭의 인덱스
        
        while (index < truck_weights.length) {
            // 한 칸씩 트럭 이동(가장 앞의 트럭이 다리에서 내려감)
            currentWeight -= bridge.poll();
            
            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (currentWeight + truck_weights[index] <= weight) {
                // 트럭이 다리 위에 올라감
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++; // 다음 트럭 준비
            } else {
                // 트럭이 올라갈 수 없으면 0을 추가(대기)
                bridge.add(0);
            }
            
            time++; // 시간 경과
        }
        
        // 마지막 트럭이 다리 끝까지 가는 시간을 추가
        time += bridge_length;
        
        return time;
    }
}
