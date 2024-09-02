package boj;

import java.util.Scanner;

public class boj_2798_jeongwoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // n개의 카드의 숫자 담을 배열 생성
        int[] card = new int[n];

        int sum; // 3개의 숫자의 합
        int min_diff = m;   // 블랙잭 숫자 - 3개의 합의 차(최소가 되는 순간이 3개 합의 최대)

        for (int i = 0; i < n; i++)
            card[i] = sc.nextInt();

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k =j+1; k < n; k++) {
                    sum = card[i] + card[j] + card[k];
                    if (m - sum < min_diff && m - sum >= 0)
                        min_diff = m - sum;
                }
            }
        }
        System.out.print(m-min_diff);
    }
}
