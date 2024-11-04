import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 바구니 역할을 해줄 stack(가장 마지막에 넣은 인형만 중요하기 때문)
        Stack<Integer> stack = new Stack<>();

        // 한 변의 길이가 N인 정사각형이므로 열 우선 탐색으로 할 때도 N 미만으로
        for(int move : moves) { // 크레인이 집을 행 번호
            int moveIdx = move - 1;

            System.out.println(move + "<= move , idx => " + moveIdx);

            for(int i = 0; i < board.length; i++) {
                int dollOrBlank = board[i][moveIdx]; // 인형이거나 빈 공간이거나

                // 처음 인형 만나면 
                if(dollOrBlank != 0) {
                    // stack이 비어있지 않고, 가장 위의 인형과 같으면
                    if(!stack.isEmpty() && stack.peek() == dollOrBlank) {
                        answer += 2; // 터진 개수 증가
                        stack.pop(); // 가장 위 인형 터트리기
                        board[i][moveIdx] = 0; // 인형 제거
                        break; // 탐색 종료
                    }

                    // 비어있거나 다르면 stack에 넣고 탐색 종료
                    stack.push(dollOrBlank);
                    board[i][moveIdx] = 0; // 인형 제거
                    break;
                }
            }

        }

        return answer;
    }
}