package boj;

import java.util.Scanner;

public class boj_2225_jeongwoo_dp {
    public static int comb_with_rep(int[][] sum, int n, int k) {
        if (n==0)
            return 1;
        else if (n == 1)
            return k;
        else {
            for (int i = 1; i <= n; i++)
                sum[i][1] = 1;   // 1개의 카드로 숫자 i를 만드는 경우는 1가지!

            for (int i = 1; i <= k; i++) {
                sum[0][i] = 1;  // i개의 카드로 0 만들기
                sum[1][i] = i;  // i개의 카드로 1 만들기
            }

            // k먼저 고정
            for (int i = 2; i <= k; i++)
                for (int j = 2; j <= n; j++)
                    for (int l = 0; l <= j; l++)
                        sum[j][i] = (sum[j][i] + sum[l][i - 1]) % 1000000000;
            return sum[n][k];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] sum = new int[n+1][k+1];
        System.out.print(comb_with_rep(sum, n, k));

    }
}
