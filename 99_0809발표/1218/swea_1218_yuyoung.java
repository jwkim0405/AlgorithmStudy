import java.util.Scanner;
import java.util.Stack;

public class swea_1218_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc < 11; tc++) {
            int length = sc.nextInt(); // 괄호 길이
            String expression = sc.next();  // 괄호
            int result = checkValid(expression);
            System.out.println("#" + tc + " " + result);    // 유효하면 1, 유효하지 않으면 0 출력
        }
    }

    static int checkValid(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 만약에 c가 여는 괄호라면
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c); // 스택에 집어넣는다.

            // 닫는 괄호라면
            } else if (c == ')' || c == '}' || c == ']' || c == '>') {
                // 닫는 괄호인데 스택이 비어있으면 유효하지 않음
                if (stack.isEmpty()) {
                    return 0;
                }

                char top = stack.pop(); // 스택의 맨 위에 있던 값

                // 짝이 안 맞으면 유효하지 않음
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[') ||
                    (c == '>' && top != '<')) {
                    return 0;
                }
            }
        }

        // 반복문 다 돌렸는데 스택이 비어있지 않다면
        if (!stack.isEmpty()) {
            return 0; // 유효하지 않음
        }

        return 1; // 모든 조건을 만족하면 유효함
    }
}
