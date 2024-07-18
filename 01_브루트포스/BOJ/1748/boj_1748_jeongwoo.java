package BOJ;
// 알고리즘 분류: 수학

import java.util.Scanner;
import java.lang.Math;

public class _boj_1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = 1; i <= 8; i++) {
            // N이 i자리 수일 경우
            // ex. 8일 경우, 1~8의 자리 수를 모두 더해야 함. (8 - 10^0 + 1) * 1
            // ex2. 16일 경우, 1~10은 else를 통해 더하고, 10~16은 (16-10^1 + 1) * 2
            if (N < (int)Math.pow(10, i)) {
                result += (N - (int)Math.pow(10, i-1) + 1)* i;
                break;
            }
            // i자리 수보다 큰 경우 (i자리는 모두 더하기!)
            // ex. 123을 구하려면, 1~9(총 1*9), 10~99(총 2 * 90)을 다 더해야 함.
            else {
                result += i * ((int)Math.pow(10, i) - (int)Math.pow(10, i-1));
            }
        }

        // 만약, 가장 큰 경우인 10^8이라면 9 더해주기
        if (N == (int)Math.pow(10, 8))
            result += 9;
        System.out.println(result);
    }
}
