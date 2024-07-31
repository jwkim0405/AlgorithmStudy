import java.util.Scanner;

<<<<<<< HEAD
public class boj_8958_yuyoung {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
=======
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
>>>>>>> da520b59af70706a6d5d4c11ef34bbe3b0816b0e

        int T = sc.nextInt(); // 테스트 케이스 갯수
        sc.nextLine(); // 개행 문자 소모

        for (int i = 0; i < T; i++) {
            String quiz = sc.nextLine(); // OX퀴즈 결과
            int sum = 0;
            int cnt = 0;

            for (int j = 0; j < quiz.length(); j++) {
                if (quiz.charAt(j) == 'O') {
                    cnt++;
                    sum += cnt;
                } else if (quiz.charAt(j) == 'X') {
                    cnt = 0;
                }
            }

            System.out.println(sum); // 최종 합 출력
        }

    }
}
<<<<<<< HEAD
=======

>>>>>>> da520b59af70706a6d5d4c11ef34bbe3b0816b0e
