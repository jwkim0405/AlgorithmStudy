import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt(); // 너비
        int h = sc.nextInt(); // 높이

        int x = sc.nextInt(); // 초기 x 좌표
        int y= sc.nextInt();  // 초기 y 좌표

        int t = sc.nextInt(); // 움직일 시간

        int dx = 1, dy = 1; // 처음에는 무조건 (+1, +1) 방향으로 이동
        int nx, ny; // 다음 x, y 좌표를 임시 저장

        // t 횟수만큼 이동
        for (int i = 0; i < t; i++) {
            nx = x + dx;
            ny = y + dy;
            if (nx == -1 || nx == w+1)
                dx *= -1;
            if (ny == -1 || ny == h+1)
                dy *= -1;

            x += dx;
            y += dy;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        System.out.print(sb);
    }
}

