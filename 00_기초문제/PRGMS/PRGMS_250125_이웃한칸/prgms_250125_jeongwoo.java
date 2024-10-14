class Solution {
    public int solution(String[][] board, int h, int w) {
        int width = board[0].length; // 가로 너비
        int height = board.length; // 세로 높이
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int count = 0;
        
        for (int i = 0; i < 4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            if (nr>=0 && nr<height && nc >=0 && nc<width && board[h][w].equals(board[nr][nc])) {
                count++;      
            } 
        }
        return count;
    }
}
