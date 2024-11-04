import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();       
        
        for(int i =0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                // j행, 크레인위치 열에 인형이 존재한다면
                if(board[j][moves[i]-1] != 0 ) {                   
                    // 바구니가 비어있지 않고, 최상단에 있는 인형과 뽑은 인형이 같다면
                    if(!basket.empty() && basket.peek() == board[j][moves[i]-1]){
                        answer++; // 인형이 터지는 횟수 증가
                        basket.pop(); // 바구니에 있는 인형 제거
                        // 뽑은 인형을 0으로 초기화
                        board[j][moves[i]-1] = 0;
                        break;
                    // 인형이 다르면 뽑은 인형을 바구니에 담은 후 0으로 초기화   
                    }else{
                        basket.push(board[j][moves[i]-1]);                      
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }                        
            }
        }
        
        return answer*2;
    }
}