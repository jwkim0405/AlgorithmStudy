import java.sql.Array;
import java.util.*;

class Main {

    static boolean[] visited; // 방문 여부
    static int[] order; // 방문 횟수
    static ArrayList<Integer>[] arr; // 정점과 간선 연결 정보 저장
    static Queue<Integer> queue; // bfs 탐색용 큐
    static int cnt = 0; // 각 노드가 방문하는 순서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 수
        int M = sc.nextInt(); // 간선 수
        int R = sc.nextInt(); // 시작 정점

        // 모든 static에 크기 할당
        visited = new boolean[N+1];
        order = new int[N+1];
        arr = new ArrayList[N+1];
        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>(); // 각각의 배열에 Arraylist 객체 생성

        // 간선 연결 정보 저장
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        for (int i = 1; i <= N; i++)
            arr[i].sort(null);

        bfs(R);
        for (int i = 1; i <= N; i++)
            System.out.println(order[i]);
    }


    static void bfs(int root) {
        visited[root] = true;
        queue.offer(root);

        // queue가 빌 때까지 queue에서 offer와 poll 반복
        while(!queue.isEmpty()) {
            int item = queue.poll();
            order[item] = ++cnt;
            for (int i = arr[item].size() - 1; i >= 0; i--) {
                int temp = arr[item].get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
    }
}
