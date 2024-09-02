import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] coloredPaper = new int[1001][1001];
        int max_width = 0, max_height = 0;
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int width = sc.nextInt();
            int height = sc.nextInt();

            if (x + width > max_width)
                max_width = x + width;
            if (y + height> max_height)
                max_height = y + height;

            for (int p = 0; p < width; p++)
                for (int q = 0; q < height; q++)
                    coloredPaper[x + p][y + q] = i;
        }

        int[] cnt = new int[N+1];

        for (int i = 0; i < max_width; i++)
            for (int j = 0; j < max_height; j++)
                cnt[coloredPaper[i][j]]++;

        for (int i = 1; i <=N; i++)
            System.out.println(cnt[i]);
    }
}

