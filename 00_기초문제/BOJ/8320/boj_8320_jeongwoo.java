package boj;

import java.util.Scanner;
import java.lang.Math;

public class boj_8320_jeongwoo {
    public static int rectangle_num(int n) {
        int cnt = 1;
        if (n <= 3)
            return cnt;

        for (int i = 2; i <= (int)Math.sqrt(n); i++)
            if (n % i == 0)
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += rectangle_num(i);

        System.out.print(sum);
    }
}
