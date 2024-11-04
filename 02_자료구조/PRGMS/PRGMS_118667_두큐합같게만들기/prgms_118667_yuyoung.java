import java.util.*;

class Solution {
    // 각 큐의 총합
    public long calSum(int[] q) {
        long sum = 0;
        for(int num : q)
        	sum += num;
        return sum;
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0; // 이동 횟수
        // 각 큐의 합을 저장
        long sum1 = calSum(queue1);
        long sum2 = calSum(queue2);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        // 두 큐의 합이 같아질 때까지 반복
        while(sum1 != sum2) {
        	// 최대 이동 횟수 초과
            if(answer > (queue1.length + queue2.length) * 2) 
            	return -1; 
            // sum1이 더 작을 때 q2에서 q1로 이동
            if(sum1 < sum2) {
                int val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            // sum1이 더 클 때 q1에서 q2로 이동
            } else { 
                int val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            }
            answer++;
        }
        return answer;
    }
}
