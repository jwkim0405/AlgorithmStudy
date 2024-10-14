class Solution {
    // 3. delta R U D L
    static int[] dh = {0, 1, -1, 0}; // row
    static int[] dw = {1, 0, 0, -1}; // column
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length; // 1. width == height of square
        int count = 0; // 2. counting blocks of the same color
                
        // 4. delta search
        for(int d = 0; d < 4; d++) {
            // 4-1.
            int h_check = h + dh[d];
            int w_check = w + dw[d];
            
            // 4-2. if delta block is in the array range
            if(0 <= h_check && h_check < n && 0 <= w_check && w_check < n) {
                // 4-2-a. if delta block is the same color with original block
                if(board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        } // end of search
        
        answer = count;       
        return answer;
    }
}