
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        // 타겟 start좌표 기준 오름차순 정렬 (정렬에 대해 공부하자!)
        Arrays.sort(targets, (int[] t1, int[] t2) -> t1[0] - t2[0]);
        
        int[] nowInterval = new int[]{targets[0][0], targets[0][1]}; // 시작과 끝
        int N = targets.length; // 타겟의 개수
        int targetSum = 1;
        
        
        // 타겟 하나하나 확인
        for (int i = 1; i < N; i++) {
            int start = nowInterval[0];
            int end = nowInterval[1];
            
            int nextStart = targets[i][0];
            int nextEnd = targets[i][1];
            
            // 만약 교집합이 있다면, 개수는 그대로! 현재 구간을 교집합으로
            if (end > nextStart) {
                nowInterval[0] = Math.max(start, nextStart);
                nowInterval[1] = Math.min(end, nextEnd);
            } 
            // 교집합이 없다면
            else {
                targetSum++; //
                nowInterval[0] = nextStart;
                nowInterval[1] = nextEnd;
            }
        }
        return targetSum;
    }
}
