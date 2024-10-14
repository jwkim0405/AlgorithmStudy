
class Solution {
    public int solution(String[][] board, int h, int w) {
    	
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        // 찾아야할 색깔
        String color = board[h][w];
        
        int n = board.length;
        
        int answer = 0;
        // 인접한 상하좌우 탐색
        for(int i = 0; i < 4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            if(nr >= 0 && nr < n && nc >=0 && nc < n && color.equals(board[nr][nc])) {
                answer++;
            }
        }
        return answer;
    }
}
