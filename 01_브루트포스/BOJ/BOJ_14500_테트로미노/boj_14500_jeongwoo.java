package BOJ;

import java.util.Scanner;
import java.lang.Math;

public class boj_14500_jeongwoo {
    // 2 x 2 사각형 찾기
    public static int square(int[][] tetromino, int n, int m) {
        int sum;
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                sum = tetromino[i][j] + tetromino[i+1][j] + tetromino[i][j+1] + tetromino[i+1][j+1];
                if (max < sum)
                    max = sum;
            }
        }
        return max;
    }
    // 가로 트리플 찾기 (3 * 1 + 1)
    public static int h_triple(int[][] tetromino, int n, int m) {
        int sum;
        int max = 0;
        // 왼쪽, 위0, 위1, 위2, 오른쪽, 아래3, 아래2, 아래1
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, 2, 3, 2, 1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-2; j++) {
                for (int k = 0; k < 8; k++) {
                    // 먼저 연속된 3칸 더해주기
                    sum = tetromino[i][j] + tetromino[i][j+1] + tetromino[i][j+2];
                    int row = i + dr[k];
                    int col = j + dc[k];

                    // index를 벗어나지 않는 다른 한 칸 더해주기
                    if (row >= 0 && row < n && col >= 0 && col < m) {
                        sum += tetromino[row][col];
                        if (max < sum)
                            max = sum;
                    }
                }
            }
        }
        return max;
    }

    // 세로 트리플 찾기(1 * 3 + 1) 찾기
    public static int v_triple(int[][] tetromino, int n, int m) {
        int sum ;
        int max = 0;
        // 위, 왼0, 왼1, 왼2, 아래, 오른3, 오른2, 오른1
        int[] dr = {-1, 0, 1, 2, 3, 2, 1, 0};
        int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n-2; j++) {
                for (int k = 0; k < 8; k++) {
                    // 먼저 연속된 3칸 더해주기
                    sum = tetromino[j][i] + tetromino[j+1][i] + tetromino[j+2][i];
                    int row = j + dr[k];
                    int col = i + dc[k];

                    // index를 벗어나지 않는 다른 한 칸 더해주기
                    if (row >= 0 && row < n && col >= 0 && col < m) {
                        sum += tetromino[row][col];
                        if (max < sum)
                            max = sum;
                    }
                }
            }
        }
        return max;
    }
    // ㄱㄴ뱀모양 찾기(가로로 긴 뱀모양)
    public static int h_snake(int[][] tetromino, int n, int m) {
        int sum1;
        int sum2;
        int sum;
        int max = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-2; j++) {
                sum1 = tetromino[i][j] + tetromino[i][j+1] + tetromino[i+1][j+1] + tetromino[i+1][j+2];
                sum2 = tetromino[i+1][j] + tetromino[i][j+1] + tetromino[i+1][j+1] + tetromino[i][j+2];
                sum = Math.max(sum1, sum2);
                if (max < sum)
                    max = sum;
                }
            }
        return max;
    }

    // ㄴㄱ뱀모양 찾기(세로로 긴 뱀모양)
    public static int v_snake(int[][] tetromino, int n, int m) {
        int sum1;
        int sum2;
        int sum;
        int max = 0;

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-1; j++) {
                sum1 = tetromino[i][j] + tetromino[i+1][j] + tetromino[i+1][j+1] + tetromino[i+2][j+1];
                sum2 = tetromino[i][j+1] + tetromino[i+1][j+1] + tetromino[i+1][j] + tetromino[i+2][j];
                sum = Math.max(sum1, sum2);
                if (max < sum)
                    max = sum;
            }
        }

        return max;
    }
    // 3개 중에서 최댓값 반환
    public static int find_max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] tetromino = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tetromino[i][j] = sc.nextInt();
            }
        }

        int triple = Math.max(h_triple(tetromino, n, m), v_triple(tetromino, n, m));
        int snake = Math.max(h_snake(tetromino, n, m), v_snake(tetromino, n, m));

        // 최종값
        int result = find_max(square(tetromino, n, m), triple, snake);
        System.out.print(result);
    }

}
