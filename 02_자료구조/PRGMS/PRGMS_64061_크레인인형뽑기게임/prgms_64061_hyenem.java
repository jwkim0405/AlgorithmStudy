import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        Stack[] arr = new Stack[N];
        for(int i = 0; i<N ;i++){
            arr[i]= new Stack<Integer>();
        }
        for(int i = N-1; i>=0; i--){
            for(int j = 0; j<N; j++){
                if(board[i][j]!=0){
                    arr[j].push(board[i][j]);
                }
            }
        }
        
        int ans = 0;
        Stack stack = new Stack();
        for(int i = 0; i<moves.length; i++){
            if(arr[moves[i]-1].isEmpty()) continue;
            
            int next = (int)arr[moves[i]-1].pop();
            
            if(!stack.isEmpty() && next==(int)stack.peek()){
                stack.pop();
                ans+=2;
            } else {
                stack.push(next);
            }
        }
        return ans;
    }
}
