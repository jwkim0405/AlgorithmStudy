import java.util.Scanner;

public class boj_2527_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 4; tc++) { // 4개의 테스트 케이스
            // 첫 번째 직사각형
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();

            // 두 번째 직사각형
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();

            // 겹치는 부분 확인
            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                // 겹치는 부분이 없다면
                System.out.println("d");
            } else if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) ||
                       (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2)) {
                // 겹치는 부분이 점이라면
                System.out.println("c");
            } else if (p1 == x2 || p2 == x1 || q1 == y2 || q2 == y1) {
                // 겹치는 부분이 선분이라면
                System.out.println("b");
            } else {
                // 겹치는 부분이 직사각형이라면
                System.out.println("a");
            }
        }

    }
}
