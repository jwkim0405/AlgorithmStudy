import java.util.Scanner;

public class Main {
    static int[][] item;
    static int[] w; // 가중치
    static int[] v; // 가치
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // 각 배열 크기 선언
        item = new int[N+1][K+1];
        w = new int[N+1];
        v = new int[N+1];

        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();

        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 버틸 수 있는 무게가 아니다!
                if (w[i] > j)
                    item[i][j] = item[i-1][j];
                else {
                    item[i][j] = Math.max(item[i-1][j], v[i] + item[i-1][j-w[i]]);
                }
            }
        }
        System.out.println(item[N][K]);
    }
}

