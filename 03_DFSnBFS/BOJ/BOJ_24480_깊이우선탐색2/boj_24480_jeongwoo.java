import java.util.*;

class Main {

    static List<Integer> arr[];
    static boolean[] visited;
    static int[] order; // 방문 순서
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        int R = sc.nextInt(); // 시작 정점

        arr = new ArrayList[N+1]; // *** (1)
        visited = new boolean[N+1];
        order = new int[N+1];

        for (int i = 1; i <= N; i++) // *** (2) 이해하고 넘어가기
            arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
           int n1 = sc.nextInt();
           int n2 = sc.nextInt();

           arr[n1].add(n2); // n1 정점에는 n2가 연결되어있다.
           arr[n2].add(n1); // n2 정점에는 n1이 연결되어있다.
        }

        // 정렬
        for (int i = 1; i <= N; i++) {
            arr[i].sort(null);
        }

        dfs(R);


        // 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }


    }

    static void dfs(int root) {
        visited[root] = true;
        order[root] = ++cnt; // 방문 순서 저장(인덱스: 해당 숫자 & 값: 방문 순서)
        for (int i = arr[root].size() - 1; i >= 0; i--) {
            int num = arr[root].get(i); // 내림차순으로 확인할 숫자
            if (!visited[num]) { // 방문 아직 안 했다면!
                dfs(num);
            }
        }
    }
}

