import java.util.Scanner;

public class boj_10158_yuyoung_fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int w = sc.nextInt(); // 2차원 격자의 가로 길이
        int h = sc.nextInt(); // 2차원 격자의 세로 길이
        int p = sc.nextInt(); // 개미의 처음 위치 x좌표
        int q = sc.nextInt(); // 개미의 처음 위치 y좌표
        int t = sc.nextInt(); // 개미가 움직이는 시간

        // x, y 좌표의 최종 위치를 계산
        // x좌표는 2 * w를 주기로 반복
        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        // 좌표가 경계를 넘어가면 반사된 위치로 변경
        if (x > w) {
            x = 2 * w - x;
        }
        if (y > h) {
            y = 2 * h - y;
        }

        // 최종 개미 위치의 x, y좌표 출력
        System.out.println(x + " " + y);

    }
}
