import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {
    static List<Integer>[] stack;
    static boolean[] visited;
    static int[] order;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 수
        int M = sc.nextInt(); // 간선 수
        int R = sc.nextInt(); // 시작 정점

//        stack = new Stack; // 1 ~ N의 값을 인덱스값과 동일하게 사용
        stack = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            stack[i] = new ArrayList<>();

        visited = new boolean[N+1];
        order = new int[N+1];

        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            stack[n1].add(n2); // n1에서 n2를 가면 n2라는 숫자가 있다.
            stack[n2].add(n1); // n2에서 n1을 가면 n1이라는 숫자가 있다.
        }
        for (int i = 1; i <= N; i++)
            stack[i].sort(null);
        dfs(R);

        for (int i = 1; i <= N; i++)
            System.out.println(order[i]);
    }

    static void dfs(int root) {
        visited[root] = true; // 해당 노드를 방문했다고 표시!
        order[root] = ++cnt;
        for(int num : stack[root]) {
            if (!visited[num]) { // 방문하지 않은 노드인 경우
                dfs(num);
            }
        }

    }
}

