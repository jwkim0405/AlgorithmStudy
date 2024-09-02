import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // 문자열 저장(공백 포함, 개행으로 구분)

        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        // 새로운 문자열
        int i = 0;
        while (i < str.length()) {
            // '<'를 만나면, '>'까지 계속 출력
            char c = str.charAt(i);
            if (c == '<') { // <가 나오면
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                } // 만약 이전에 스택에 쌓여있으면 빌 때까지 pop(거꾸로 나옴)
                sb.append(c);

                while (true) {  // '>'가 나올 떄까지 정순으로 넣기
                    c = str.charAt(++i);
                    sb.append(c);
                    if (c == '>') {
                        i++;
                        break;
                    }
                }
            } else if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                stack.push(c); // 숫자나 소문자가 나오면 stack에 푸쉬(거꾸로 꺼내기 위함)
                i++;
            } else if (c == ' ') {
                i++;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                } // 만약 이전에 스택에 쌓여있으면 빌 때까지 pop(거꾸로 나옴)
                sb.append(c);
            }
        }

        // 마지막에 놓친 코드
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        } // 만약 이전에 스택에 쌓여있으면 빌 때까지 pop(거꾸로 나옴)
        System.out.println(sb);
    }

    // Stack 구현 클래스
    public static class Stack {
        List<Character> stack = new ArrayList<>();
        int top = -1;

        public Stack() {}

        void push(char c) {
            top++;
            stack.add(c);
        }

        char pop() {
            char popItem = peek();
            stack.remove(top--);
            return popItem;
        }

        char peek() {
            return stack.get(top);
        }

        boolean isEmpty() {
            return top == -1;
        }
    }
}

