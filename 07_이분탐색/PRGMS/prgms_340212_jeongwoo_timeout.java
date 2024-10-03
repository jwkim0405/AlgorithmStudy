class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 1;
        while(true) {
            // 만약 제한 시간 내 퍼즐을 풀 수 있다!
            if (isLevelAvailable(diffs, times, limit, level)) 
                return level;
            level++;
        }
    }
    
    // 메서드1: 특정 level에서 limit 내에 가능한지 검사
    boolean isLevelAvailable(int[] diffs, int[] times, long limit, int level) {
        
        long sum = times[0]; // 0번째 인덱스는 항상 diffs[0]임. (diffs <= level)
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) // 만약 숙련도가 더 높다
                sum += times[i];
            else // 만약 숙련도가 더 낮다
                sum += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            
            if (sum > limit) return false;
        }
        
        // true false 결과 출력
        if (sum <= limit)
            return true;
        return false;
    }
}
