import java.util.Scanner;

public class Main {
    static int[][] city;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도시 수
        int M = sc.nextInt(); // 버스 개수

        city = new int[N+1][N+1]; // 1~N도시 행렬

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 시작 도시
            int b = sc.nextInt(); // 도착 도시
            int w = sc.nextInt();
            if (city[a][b] == 0)
                city[a][b] = w; // 비용
            else
                city[a][b] = Math.min(city[a][b], w);

        }


        for (int i = 1; i <= N; i++) {
            for (int p = 1; p <= N; p++) {
                for (int q = 1; q <= N; q++) {
                    if (p == i || q == i)
                        continue;
                    if (city[p][i] > 0 && city[i][q] > 0 && (p != q)) {
                        if (city[p][q] == 0)
                            city[p][q] = city[p][i] + city[i][q];
                        else {
                            int result = city[p][i] + city[i][q];
                            city[p][q] = Math.min(city[p][q], result);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
               System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }
    }
}

