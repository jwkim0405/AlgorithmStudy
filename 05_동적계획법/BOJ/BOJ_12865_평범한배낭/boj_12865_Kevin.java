import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int[] dp = new int[K + 1];

        // 물품들에 대해 처리
        for (int i = 0; i < N; i++) {
            int W = scanner.nextInt();  // 물건의 무게
            int V = scanner.nextInt();  // 물건의 가치

            // 역순으로 dp 배열 업데이트
            for (int weight = K; weight >= W; weight--) {
                dp[weight] = Math.max(dp[weight], dp[weight - W] + V);
            }
        }

        // 결과 출력
        System.out.println(dp[K]);

        scanner.close();
    }
}
