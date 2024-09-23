class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int width = park[0].length;
        int height = park.length;
        
        int[][] dp = new int[height][width];
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                if(park[i][j].equals("-1")){
                    if(i!=0 && j!=0) {
                        dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    } else {
                        dp[i][j]=1;
                    }
                    for(int mat : mats){
                        if(dp[i][j]==mat) {
                            answer = Math.max(answer, mat);
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
