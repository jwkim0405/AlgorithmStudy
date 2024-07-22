import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n days
        int n = sc.nextInt();

        int[][] work = new int[n+1][2];
        
        // 소요기간, pay 입력
        for (int i = 1; i <= n; i++) {
        	work[i][0] = sc.nextInt() + i -1;	//i일차 일 끝나는 날
        	work[i][1] = sc.nextInt();	//i일차 일 pay
        }
        
        // dp 배열 생성
        int[] dp = new int[n+1];
        	
        for (int i = 1; i <= n; i++) {
        	dp[i] = dp[i-1];

            for (int j = 1; j <= i; j++) {
        		if (i == work[j][0]) {
        			// 만약, i=3일 때, (j=)1~3일차까지 탐색하는 for문에서
        			// 3 == work[j=1][0], 1일차의 일이 3일차에 끝나기 때문에
        			// dp[3] = max(dp[3], dp[j=1 - 1] + work[1][1])
        			// 3일차의 값은 (3일차의 원 dp값, 0일차의 dp값 + 1일차~3일차까지 일한값)의 최대값
        			dp[i] = Math.max(dp[i], dp[j-1] + work[j][1]);
        		}
        	}
        }
        System.out.println(dp[n]);
        sc.close();
    } // main
}

