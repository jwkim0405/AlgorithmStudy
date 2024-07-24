package boj;

import java.util.Scanner;

public class boj_3052_jeongwoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] remainder = new int[43];
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt() % 42;
            if (remainder[num] == 0) {
                cnt++;
                remainder[num] = 1;
            }
        }
        System.out.print(cnt);
    }
}
