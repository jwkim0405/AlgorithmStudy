import java.util.Scanner;

public class boj_2292_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력받은 숫자

        if (N == 1) {
            System.out.println(1); // N이 1인 경우 시작점이므로 1 출력
            return;
        }

        int sum = 1; // 처음에 있었던 방
        int cnt = 1; // 중앙 방을 둘러싼 첫 번째 층
        while (sum < N) {
            sum += 6 * cnt; // 다음 층의 방 갯수 더하기
            cnt++; // 다음 층으로 이동
        }

        System.out.println(cnt); // N에 도달하기까지 최소로 몇 개의 층을 지나야 하는지 출력
    }
}
