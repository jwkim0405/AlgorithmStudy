// memory exceeded
// 1행 1열부터 V-1행 V-1행까지 한 번만 돌려도 되는 이유

package BOJ;

import java.util.Scanner;

public class boj_1753_최단경로 {

    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 수
        int E = sc.nextInt(); // 간선 수

        int startNode = sc.nextInt(); // 시작 노드

        graph = new int[V+1][V+1]; // 1 ~ V까지 번호 매겨져있음.

        // E개 간선 graph 배열에 입력(u->v 연결, 가중치 w)
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // 출발
            int v = sc.nextInt(); // 도착
            int w = sc.nextInt(); // 가중치

            graph[u][v] = w;
        }


        // i행 i열에 대해 탐색
        for (int i = 1; i <= V; i++) {
            for (int p = 1; p <= V; p++) {
                OUT:
                for (int q = 1; q <= V; q++) {
                    // 해당하는 i행, i열은 넘어가기!
                    if (p == i)
                        break OUT;
                    if (q == i)
                        continue;

                    // (p, i) -> (i, q) => (p, q)가 가능한 곳 찾기!

                    if (graph[p][i] > 0 && graph[i][q] > 0) {
                        if (graph[p][q] == 0)
                            graph[p][q] = graph[i][q] + graph[p][i];
                        else
                            graph[p][q] = Math.min(graph[p][q], graph[i][q] + graph[p][i]);
                    }
                }
            }
        }

            for (int i = 1; i <= V; i++) {
                if (i == startNode)
                    System.out.println(0);
                else {
                    int result = graph[startNode][i];
                    if (result == 0)
                        System.out.println("INF");
                    else
                        System.out.println(result);
                }
            }
        }
}

