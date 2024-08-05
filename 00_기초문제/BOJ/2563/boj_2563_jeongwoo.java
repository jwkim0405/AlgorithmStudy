import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] coloredPaper = new int[1001][1001];
        int max_width = 0, max_height = 0;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x + 10 > max_width)
                max_width = x + 10;
            if (y + 10 > max_height)
                max_height = y + 10;


            for (int p = 0; p < 10; p++) {
                for (int q = 0; q < 10; q++) {

                    if (coloredPaper[x + p][y + q] == 0) {
                        coloredPaper[x + p][y + q]++;
                        sum += 1;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

