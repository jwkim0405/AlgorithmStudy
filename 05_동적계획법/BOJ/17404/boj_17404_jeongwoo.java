package boj;

import java.util.Scanner;
import java.lang.Math;

public class boj_17404_jeongwoo {

    // 최소값을 찾는 메서드
    public static int find_min(int[][] rgb, int n) {

        int[][] DP = new int[n+1][3];        // 위치별 최소값을 저장할 DP 배열 생성
        int[][] first_line = new int[n+1][3]; // 첫 번째 줄과 마지막 줄의 색을 비교하기 위해 first_line 배열 생성

        // 첫 번째 줄의 res값은 저장된 rgb배열의 크기와 같음
        for (int i = 0; i < 3; i++) {
            DP[1][i] = rgb[1][i];
            first_line[1][i] = i;
        }

        // DP 배열 => N번재 줄의 r로 끝나는 최소값, g로 끝나는 최소값, b로 끝나는 최소값 중의 최소를 구하기
        // N번째 줄의 r로 끝나는 최소값 == min(N-1번째 줄에서 g로 끝나는 최소값, N-1번째 줄에서 b로 끝나는 최소값) + rgb[n][0];
        for (int i = 2; i <= n-1; i++) {
            for (int j = 0; j < 3; j++) {
                int min_idx;    // r, g, b 중에서 작은 값의 idx

                if (j == 0)
                    min_idx = (DP[i - 1][1] < DP[i-1][2]) ? 1 : 2;
                else if (j == 1)
                    min_idx = (DP[i - 1][0] < DP[i - 1][2]) ? 0 : 2;
                else
                    min_idx = (DP[i - 1][0] < DP[i-1][1]) ? 0 : 1;

                DP[i][j] = DP[i-1][min_idx] + rgb[i][j];
                first_line[i][j] = first_line[i-1][min_idx];
            }
        }

        int min = 1000000;

        for (int i = 0; i < 3; i++)                         // i는 n-1번째 줄의 r, g, b의 idx
            for (int j = 0; j < 3; j++)                     // j는 마지막 줄의 r,g,b의 인덱스
                if (j != i && j != first_line[n-1][i])   // 마지막 줄 idx != n-1번째의 idx && 마지막 줄 idx != n-1번째까지 왔을 때의 1번째 줄 idx
                    min = Math.min(min, DP[n-1][i] + rgb[n][j]);       // 해당 값이 최소값인지 비교해서 업데이트

        return min;
    } // find_min 함수

    // main 함수
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

        // 역순 탐색을 위한 배열 선언 및 초기화
        int[][] reversed_rgb = new int[n+1][3];

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 3; j++)
                reversed_rgb[i][j] = rgb[n+1-i][j];

        int min = Math.min(find_min(rgb, n), find_min(reversed_rgb, n));
        System.out.print(min);
    }
}