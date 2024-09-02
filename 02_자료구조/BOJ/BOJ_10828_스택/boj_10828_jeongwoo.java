import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 명령의 수
        int n = sc.nextInt();

        // 스택 쌓을 배열 생성
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            // 명령어 입력
            String command = sc.next();

            // push
            if (command.equals("push"))
                list.add(sc.nextInt());

                // pop
            else if (command.equals("pop")) {
                // 비어있다면 -1 출력
                if (list.isEmpty()) {
                    sb.append(-1);
                    sb.append('\n');
                }
                    // Last in -> pop
                else {
                    sb.append(list.get(list.size()-1));
                    list.remove(list.size()-1);
                    sb.append('\n');
                }
            }

            // size
            else if (command.equals("size")) {
                sb.append(list.size());
                sb.append('\n');
            }

            // top
            else if (command.equals("top")) {
                if (list.isEmpty())
                    sb.append(-1);
                else
                    sb.append(list.get(list.size()-1));
                sb.append('\n');
            }

            // empty
            else if (command.equals("empty")) {
                if (list.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append('\n');
            }
        } // for문

        // 출력
        System.out.print(sb);
    } // main
} // done
