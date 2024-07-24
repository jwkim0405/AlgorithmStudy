package boj;

import java.util.Scanner;
import java.lang.Math;

// 자리수가 커서 문제 발생

public class boj_2225_jeongwoo {
//    public static long factorial(int n) {
//        long res = 1L;
//        if (n >= 2)
//            for (int i = 2; i <= n; i++)
//                res *= i;
//        return res;
//    }
    public static long comb_rep(int N, int K) {
        long res = 1;
        long max_divisor = Math.max(N, K-1);
        long min_divisor = Math.min(N, K-1);

        for (int i = K+N-1; i > max_divisor; i--)
            res *= i;


        for (int i = 2; i <= min_divisor; i++)
            res /= i;

        return res % 1000000000;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

//        long res = factorial(K+N-1);

        System.out.print(comb_rep(N, K));
    }
}
