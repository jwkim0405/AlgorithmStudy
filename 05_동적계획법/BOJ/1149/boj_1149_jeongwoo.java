package boj;

import java.util.Scanner;
import java.lang.Math;

public class boj_1149_jeongwoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 총 몇 줄 입력할지 (n줄)
        int n = sc.nextInt();

        // rgb 배열 생성(각 줄에서 색상별 크기 저장)
        int[][] rgb = new int[n+1][3];

        // rgb 배열에 값 입력
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 3; j++)
                rgb[i][j] = sc.nextInt();

        // 위치별 최소값을 저장할 res배열 생성
        int[][] res = new int[n+1][3];

        // 첫 번째 줄의 res값은 저장된 rgb배열의 크기와 같음
        for (int i = 0; i < 3; i++)
            res[1][i] = rgb[1][i];

        // dp
        // res 배열 => N번재 줄의 r로 끝나는 최소값, g로 끝나는 최소값, b로 끝나는 최소값 중의 최소를 구하기
        // N번째 줄의 r로 끝나는 최소값 == min(N-1번째 줄에서 g로 끝나는 최소값, N-1번째 줄에서 b로 끝나는 최소값) + rgb[n][0];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    res[i][j] = Math.min(res[i - 1][1], res[i-1][2]);
                else if (j == 1)
                    res[i][j] = Math.min(res[i - 1][0], res[i-1][2]);
                else
                    res[i][j] = Math.min(res[i - 1][0], res[i-1][1]);
                res[i][j] += rgb[i][j];
            }
        }

        int min = Math.min(Math.min(res[n][0], res[n][1]), res[n][2]);

        System.out.print(min);
    }
}
