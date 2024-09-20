// Queue를 만들어서 bridge_length만큼 0을 채워넣기
// for문 반복
    // sum = 0, sum -= deQueue
    // 만약, sum + enQueue <= weight 
        // enQueue and sum += euQueue
    
    // weight를 초과하면,
        // 0을 enQueue
    // time++

import java.util.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>(); // 다리를 건너는 트럭 queue
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 걸리는 시간
        // 먼저, 0으로 채워넣기
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        int sum = 0; // 다리에 있는 트럭 weight의 총합
        int idx = 0; // queue에 넣을 idx
        int len = truck_weights.length; // 트럭의 개수
       
        
        // 마지막 트럭이 queue에 들어갈 때까지 반복
        while(idx < len) {
            sum -= queue.poll(); // 빼기
            // 더하기
            int item = truck_weights[idx]; // queue에 넣을 트럭의 무게
            if (sum + item <= weight) {
                sum += item;
                queue.offer(item);
                idx++; 
             }
            else queue.offer(0);
            answer++;
        }
        // 마지막 트럭이 다리 건너기 완료한 시간
        answer += bridge_length;
        
        return answer;  
    }
}
