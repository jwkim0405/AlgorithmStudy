class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int ans = 0;
        for(int i = 0; i<4; i++){
            int nh = h+dx[i];
            int nw = w+dy[i];
            if(nh<0 || nw<0 || nh>=board.length || nw >=board[0].length) continue;
            if(board[nh][nw].equals(board[h][w])) ans++;
        }
        return ans;
    }
}
