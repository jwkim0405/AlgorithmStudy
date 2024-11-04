import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1; // 최소 pop-insert 세트 횟수

        // queue의 전체 합 / 2 구하기 -> 만들어야 하는 합
        // long entireSum = Arrays.stream(queue1).sum() + Arrays.stream(queue2).sum(); // stream을 이용해 array 값들의 합 계산(근데 단순 합은 반복이 더 효율적이라 함)

        long sum = 0L; // 각 원소 최대 범위가 10^9
        long que1Sum = 0L;
        long que2Sum = 0L;

        // 처음엔 길이가 같게 주어지므로 하나의 길이로 지정해도 상관 없음
        for(int i = 0; i < queue1.length; i++) {
            sum += queue1[i] + queue2[i];
            que1Sum += queue1[i];
            que2Sum += queue2[i];
        }

        long targetSum = sum / 2; // 한 큐에서 달성해야 하는 목표 합

        // 최대 작업 횟수는 두 큐의 원소의 총 개수만큼
        int idx1 = 0; // 1번 큐 idx
        int idx2 = 0; // 2번 큐 idx

        while(idx1 + idx2 <= (queue1.length-1 + queue2.length-1)*2) {
            // 한 큐에서 추출된 원소를 무조건 [다른 큐]에만 넣을 수 있음
            // 즉, 한 쪽이 크면 거기서 빼서 적은 쪽에 넣어야만 정답이 아닌 작업을 걸러낼 수 있음

            // 1. 같아지는 순간 정답
            if(targetSum == que1Sum) {
                answer = idx1 + idx2;
                return answer;
            } else if(targetSum < que1Sum) { // 2. queue1이 더 클 경우
                int poll;
                if(idx1 >= queue1.length) poll = queue2[idx1++ - queue1.length];
                else poll = queue1[idx1++];

                que1Sum -= poll;
                que2Sum += poll;
            } else { // 3. queue2가 더 클 경우
                int poll;
                if(idx2 >= queue2.length) poll = queue1[idx2++ - queue2.length];
                else poll = queue2[idx2++];

                que2Sum -= poll;
                que1Sum += poll;
            }

        }

        if(targetSum == que1Sum) {
            answer = idx1 + idx2;
        }

        return answer;
    }
}