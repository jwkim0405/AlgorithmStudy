// 1부터 max(diffs)에서 이분탐색 진행해보자

class Solution {
    static int left = 1;
    static int mid;
    static int right;
    public int solution(int[] diffs, int[] times, long limit) {
        // 이분탐색을 위한 diffs 최대값 찾기
        int max = 1;
        for (int i = 1; i < diffs.length; i++)
            max = Math.max(max, diffs[i]);
        
        // level을 이분탐색
        int left = 1;
        right = max;
        mid = (left+right) / 2;
        
        binarySearch(diffs, times, limit, left, mid, right);
        return mid;
    }
    
    // 메서드1: 특정 level에서 limit 내에 가능한지 검사
    static boolean isLevelAvailable(int[] diffs, int[] times, long limit, int level) {
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
    
    // 메서드2: 이분탐색
    // 만약 left==right까지 갔을 때 mid값이 false => return mid+1
    //                                  true => return mid
    void binarySearch(int[] diffs, int[] times, long limit, int left, int mid, int right) {
        if (left >= right) {
            if (!isLevelAvailable(diffs, times, limit, mid)) {
                mid += 1;
            }
            return;
        } 
        
        if (isLevelAvailable(diffs, times, limit, mid)) // true
            right = mid-1;
        else // false
            left = mid+1;
        
        mid = (left+right) / 2;
        binarySearch(diffs, times, limit, left, mid, right);
    }
    
    
}
