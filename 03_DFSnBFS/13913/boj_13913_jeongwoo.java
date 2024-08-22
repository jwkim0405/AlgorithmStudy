import java.util.*;

public class Main {
    static Queue<Object[]> queue;
    static boolean[] visited = new boolean[100001];
    static int result = 0;
    static String route = "";
    static String final_route;
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        queue = new LinkedList<>();
        if (N <= K) {
            bfs(N, result);
            System.out.println(result);
            System.out.println(final_route);
        }
        else {
            System.out.println(N-K);
            for (int i = N; i >= K; i--)
                System.out.print(i + " ");
        }
    }

    static void bfs(int node, int cnt) {
        visited[node] = true;
        queue.offer(new Object[] {node, cnt, route+node});

        while(!queue.isEmpty()) {
            Object[] item = queue.poll();
            if ((int)item[0] == K) {
                result = (int)item[1];
                final_route = (String)item[2];
                return;
            }
            // node-1에 대해 검사
            int next_node = (int)item[0] -1;
            if (next_node >= 0 && next_node <= 100000 && !visited[next_node]) {
                queue.offer(new Object[]{next_node, (int)item[1]+1, item[2] + " "+next_node});
                visited[next_node] = true;
            }
            // (int)item[0]+1에 대해 검사
            next_node = (int)item[0]+1;
            if (next_node <= 100000 && !visited[next_node]) {
                queue.offer(new Object[] {next_node, (int)item[1]+1, item[2] + " " + next_node});
                visited[next_node] = true;
            }
            next_node = (int)item[0]*2;
            if (next_node <= 100000 && !visited[next_node]) {
                queue.offer(new Object[] {next_node, (int)item[1]+1, item[2] + " " + next_node});
                visited[next_node] = true;
            }
        }

    }

}

