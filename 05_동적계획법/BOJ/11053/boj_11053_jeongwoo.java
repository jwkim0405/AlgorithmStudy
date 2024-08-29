// 전략: DP
// dp[N} 배열 생성 후 각각 1로 값 초기화(Arrays.fill(dp, 1))
// seq[1]에 대해서 seq[0]과 비교 => seq[1]이 크다! => max(dp[0] + 1, dp[1])
// seq[2]에 대해서 seq[0]과 비교, seq[1]과 비교
// seq[0] < seq[2] => dp[2] = max(dp[0]+1, dp[2])
// seq[1] < seq[2] => dp[2] = max(dp[1]+1, dp[2])
// ...

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int max_value = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기 입력값 입력
        int N = sc.nextInt();
        int[] seq = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // dp배열의 값을 모두 1로 초기화

        for (int i = 0; i < N; i++)
            seq[i] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        for (int i = 1; i < N; i++) {
            max_value = Math.max(dp[i], max_value);
        }
        System.out.println(max_value);
    }
}

