import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int maxSize = 0;
        // 공원의 가로, 세로 길이
        int r = park.length; // 가로
        int c = park[0].length; // 세로
        
        int[][] dp = new int[r][c]; // 나 기준 왼쪽 위로 최대 size x size의 'size'를 저장
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 첫 행, 첫 열
                if (i == 0 || j == 0) {
                    if (park[i][j].equals("-1")) dp[i][j] = 1; // 첫 행, 첫 열 빈 자리
                    else dp[i][j] = 0;
                } 
                else { // (i-1, j), (i,j-1), (i-1, j-1)의 min값 + 1
                    if (park[i][j].equals("-1"))
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    else
                        dp[i][j] = 0;
                } 
                if (maxSize < dp[i][j]) maxSize = dp[i][j]; 
            } // for j
        } // for i
        
        Arrays.sort(mats);
        
        // 큰 매트 순서, 매트보다 maxSize가 크면 매트의 크기 반환
        for (int i = mats.length - 1; i >= 0; i--) {
            if (maxSize >= mats[i]) return mats[i];
        }       
        return -1;
    } // solution method

} // class
