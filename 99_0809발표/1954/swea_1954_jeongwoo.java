import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase  = sc.nextInt();

        for (int i = 1; i <= testCase; i++) {
            int num = sc.nextInt();
            System.out.println("#" + i);
            snailNumber(num);
        }
    }

    static void snailNumber(int n) {
        int direction = 0; // 우 하 좌 상 (방향)
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int[][] snail = new int[n][n];
        int row = 0, col = 0;
        for (int i = 1; i <= n * n; i++) {
            snail[row][col] = i;
            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && snail[nr][nc] == 0) {
                row = nr;
                col = nc;
            } else {
                direction = (direction+1) % 4;
                row += dr[direction];
                col += dc[direction];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }
    }
}

