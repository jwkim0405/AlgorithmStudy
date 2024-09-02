import java.util.*;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] item = queue.poll();
            // 맞는 숫자가 있다면 끝내기!
            int temp = item[0]; // 만약, N=5 K=9라면 5*2=10까지는 방문해봄
            while(temp < K && temp*2 <= 100000 && !visited[temp*2]) {
                temp *= 2;
                if (temp <= 100000 && !visited[temp]) {
                    visited[temp] = true;
                    queue.offer(new int[]{temp, item[1]});
                }
            }
            if (item[0] == K) {
                System.out.println(item[1]);
                break;
            }
            // x -1 탐색
            if (item[0]-1 >= 0 && item[0] -1 <= 100000 && !visited[item[0]-1]) {
                visited[item[0]-1] = true;
                queue.offer(new int[]{item[0]-1, item[1]+1});
            }
            // x + 1 탐색
            if (item[0]+1 >= 0 && item[0]+1 <= 100000 && !visited[item[0]+1]) {
                visited[item[0]+1] = true;
                queue.offer(new int[]{item[0]+1, item[1]+1});
            }

        }

    }
}

