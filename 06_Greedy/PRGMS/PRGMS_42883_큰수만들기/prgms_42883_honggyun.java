import java.util.*;

class Solution {
    static Map<Character, Integer> map;
    static Queue<Integer> queue;

    public String solution(String number, int k) {
        map = new HashMap<>(); // binding할 map
        Stack<Integer> stack = new Stack<>();

        // 각 '0'~'9'까지 숫자로 매핑
        for(int i = 0; i < 10; i++) {
            int num = '0' + i;
            char c = (char) num;
            map.put(c, i);
        }

        StringBuilder sb = new StringBuilder();

        // stack에 넣으면서 들어오는 수가 top보다 더 크면 같거나 작아질 때까지(k가 허용하는 횟수 내에서) top을 빼고 들어오는 수 push
        // 이미 있는 수가 더 크면 그냥 push

        for(int i = 0; i < number.length(); i++) {
            char numChar = number.charAt(i);
            int num = map.get(numChar); // char에서 number로 변환

            // 처음 넣을 때
            if(stack.isEmpty()) {
                stack.push(num);

            } else {
                // 들어오는 게 더 큼
                if(stack.peek() < num && k > 0) {
                    // 스택이 비지 않고, 들어오는 게 더 큰 동안 반복
                    while(!stack.isEmpty() && stack.peek() < num && k > 0) {
                        int tmp = stack.pop(); // 원래 있던 거 버림
                        k--; // 하나 버렸음                        
                    } // 반복 끝나면 들어오는 수 보다 크거나 같은 수가 peek()에 있음(혹은 스택이 비거나)

                    stack.push(num);
                } else { // 들어오는 게 더 작거나 같음
                    stack.push(num);
                }

            }
        }

        // 333222111 처럼 같은 숫자만 등장하거나 점점 작아지는 때에는 k만큼 제거할 수가 없음
        // 그럴 때에는 뒤에서부터 제거하면 큰 수 생성 가능
        while(k > 0) {
            stack.pop();
            k--;
        }

        // stack에 있는 걸 sb에 다 넣기
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 스택은 선입후출이므로 반대로 뒤집고 String으로 변환
        String answer = sb.reverse().toString();
        return answer;
    }
}