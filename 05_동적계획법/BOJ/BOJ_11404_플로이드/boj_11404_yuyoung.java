import java.util.Scanner;

public class boj_11404_yuyoung {
    // 경로가 없을 때 사용할 값
    static final int INF = 987654321;
    static int[][] cost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 버스 개수

        cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    cost[i][j] = 0; // 자기 자신으로 가는 경로는 비용이 0
                } else {
                    cost[i][j] = INF; // 그 외의 경우는 무한대
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 출발 도시
            int b = sc.nextInt(); // 도착 도시
            int c = sc.nextInt(); // 비용

            // 동일한 출발지와 도착지에 대한 최소 비용
            cost[a][b] = Math.min(cost[a][b], c);
        }

        // 중간에 경유하는 도시를 기준으로 경로를 갱신
        for (int mid = 1; mid <= n; mid++) { // 중간에 경유하는 도시
            for (int start = 1; start <= n; start++) { // 출발 도시
                for (int end = 1; end <= n; end++) { // 도착 도시
                    // 현재의 경로 비용과 경유지를 거친 경로 비용을 비교하여 더 작은 값으로 갱신
                    cost[start][end] = Math.min(cost[start][end], cost[start][mid] + cost[mid][end]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 만약 경로가 없다면 (무한대 값이라면) 0
                if (cost[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    // 경로가 있으면 그 경로의 최소 비용
                    System.out.print(cost[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
