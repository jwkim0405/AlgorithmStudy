import java.util.Scanner;

public class boj_12865_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물품의 수
        int K = sc.nextInt(); // 준서가 버틸 수 있는 무게

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1];  // 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 현재 물건을 배낭에 넣을 수 있는 경우
                if (j >= W[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j-W[i]]);
                } else { // 현재 물건을 배낭에 넣을 수 없는 경우
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
