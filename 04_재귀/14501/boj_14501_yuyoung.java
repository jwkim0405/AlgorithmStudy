import java.util.Scanner;

public class boj_14501_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 남은 일 수 입력
        int[] Tarr = new int[N + 1]; // 걸리는 시간
        int[] Parr = new int[N + 1]; // 수
        int[] dp = new int[N + 2]; // 최대 수익, dp[i + Tarr[i]] 경계조건 쉽게 처리하기 위해 N+2로

        // N일에 Ti, Pi 입력
        for (int i = 1; i <= N; i++) {
            Tarr[i] = sc.nextInt(); // Ti 입력
            Parr[i] = sc.nextInt(); // Pi 입력
        }

        for (int i = N; i >= 1; i--) { // 뒤에서부터 시작
            if (i + Tarr[i] - 1 <= N) { // 일이 남은 날 수 내에 끝날 수 있는 경우
                dp[i] = Math.max(Parr[i] + dp[i + Tarr[i]], dp[i + 1]); // 일을 했을 때와 하지 않았을 때 중 최대값 선택
            } else {
                dp[i] = dp[i + 1]; // 일이 남은 날 수 내에 끝날 수 없는 경우
            }
        }

        System.out.println(dp[1]); // 최대 수익 출력
    }
}
