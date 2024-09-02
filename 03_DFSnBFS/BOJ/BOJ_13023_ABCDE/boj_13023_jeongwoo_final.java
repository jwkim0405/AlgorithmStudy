import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found;
    public static void main(String[] args) {

        // 문제: 한붓그리기로 총 4번의 이동을 할 수 있는지!(시작 노드 포함하여 5개의 노드 방문)

        // 1. 초기 작업(Scanner, 크기 할당, 값 입력)
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        for (int i = 0; i < K; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            // 간선 연결 정보 저장
            graph[num1].add(num2);
            graph[num2].add(num1);
        }
        // 초기 setting 끝

        // 2. DFS 탐색
        // 한붓그리기로 총 4칸 이동(5개의 노드를 갈 수 있는지)
        int result = 0;
        for (int i = 0; i < N && !found; i++) {
            dfs(i, 1);
            if (found) {
                result = 1;
                break;
            }
        }
        System.out.println(result); // 결과 출력
    }

    // DFS 탐색 메서드
    static void dfs(int node, int depth) {
        // 깊이가 5 이상이면 메서드 종료
        // (한붓그리기로 5개 노드 이동했음을 의미)
        if (depth == 5) {
            found = true;
            return;
        }
        visited[node] = true; // node를 방문했습니다.
        for(int neighbor: graph[node]) {
            if (!visited[neighbor]) { // 방문 안했다면 가서 탐색
                dfs(neighbor, depth+1); // 더 탐색해보자! 깊이 + 1
                if (found) return; // 재귀 돌아올 때 바로 멈추도록!
                visited[neighbor] = false; // backtracking
            }
        }
        visited[node] = false; // backtracking
    }
}


