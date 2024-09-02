import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj_24479_yuyoung {
    static int cnt; // 노드 방문 순서
    static int[] checked; // 각 노드의 방문 순서를 저장할 배열
    // 그래프를 인접 리스트 형태로 표현하기 위한 ArrayList
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt(); // 노드(정점)의 개수
        int m = sc.nextInt(); // 간선의 개수
        int r = sc.nextInt(); // 시작할 노드 번호

        checked = new int[n + 1]; // 노드 번호가 1부터 시작하므로 크기를 n+1로 설정

        for (int i = 0; i <= n; i++) {
		        // 각 노드에 연결된 노드들을 저장할 리스트를 생성하여 그래프에 추가
            graph.add(new ArrayList<Integer>()); 
        }
				
        // 서로 연결된 노드 입력
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); // 첫 번째 노드
            int v = sc.nextInt(); // 두 번째 노드
            // 양쪽으로 연결
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 노드에 연결된 노드들을 오름차순으로 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i)); // 인접리스트 방문순서 오름차순으로 정렬
        }

        cnt = 1; // 방문 순서의 시작
        dfs(r); // 시작 노드부터 DFS

        // 결과 출력
        for (int i = 1; i < checked.length; i++) {
            sb.append(checked[i]).append("\n"); // 방문 순서
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        checked[node] = cnt; // 현재 노드의 방문 순서

        // 현재 노드와 연결된 노드들을 탐색
        for (int i = 0; i < graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i); // 연결된 새로운 노드
            if (checked[newNode] == 0) { // 아직 방문하지 않은 노드인 경우
                cnt++; // 방문 순서 증가
                dfs(newNode);
            }
        }
    }
}