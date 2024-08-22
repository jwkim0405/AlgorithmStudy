import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_24444_yuyoung_fail {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt(); // 노드의 개수
        int m = sc.nextInt(); // 간선의 개수
        int r = sc.nextInt(); // 시작할 노드 번호

        check = new int[n + 1]; // 노드 방문 여부를 체크하기 위한 배열

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // 양쪽으로 연결
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 노드에 연결된 노드들을 오름차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        bfs(r);

        // 결과 출력
        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        check[node] = cnt;
        queue.offer(node); // 시작 노드를 큐에 추가

        // 큐가 빌 때까지 BFS 탐색 진행
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 큐에서 노드를 하나 꺼냄

            for (int next : graph.get(current)) { // 해당 노드와 연결된 노드들을 탐색
                if (check[next] == 0) { // 아직 방문하지 않은 노드인 경우
                    cnt++;
                    check[next] = cnt; // 방문 순서를 기록
                    queue.offer(next); // 큐에 추가하여 다음 탐색 대상으로 설정
                }
            }
        }
    }
}
