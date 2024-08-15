import java.sql.Array;
import java.util.*;

class Main {
    static boolean[] visited; // 방문 여부
    static int[] order; // 방문 순서
    static ArrayList<Integer>[] arr; // ArrayList 2차원 배열 만들기!
    static Queue<Integer> queue;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 수
        int M = sc.nextInt(); // 간선 수
        int R = sc.nextInt(); // 시작 정점

        visited = new boolean[N+1];
        order = new int[N+1];
        arr = new ArrayList[N+1]; // ArrayList 배열 객체 생성
        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>(); // 배열 안에 각각의 ArrayList 만들어주기
        }

        // 간선 연결
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++)
            arr[i].sort(null);

        bfs(R);

        for (int i = 1; i <= N; i++)
            System.out.println(order[i]);
    }

    static void bfs(int root) {
        visited[root] = true;
        order[root] = ++cnt;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int item = queue.poll();
            for (int num: arr[item]) {
                if (!visited[num]) {
                    visited[num] = true;
                    order[num] = ++cnt;
                    queue.offer(num);
                }
            }
        }
    }

}

