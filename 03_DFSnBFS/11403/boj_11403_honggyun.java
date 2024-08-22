import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] relatedArr; // input 받을 배열
    static int[][] outputArr; // output 저장할 배열

    static void bfs(int i) {
        // 1. 번호 관리할 queue 생성
        Queue<Integer> queue = new LinkedList<>();
        // 2. queue에 i <- offer
        queue.offer(i);
        // 3. 반복문으로 queue가 빌 때까지 i의 인접 노드 순환
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            // 4. visited == false면 queue에 삽입
            for(int j = 0; j < relatedArr[cur-1].length; j++) {
                if(visited[j] == false && relatedArr[cur-1][j] == 1) {
                    queue.offer(j+1);
                    visited[j] = true;
                }
            }
        }
        // bfs가 완전히 돌고 나면, true인 visited의 (i를 제외하고)idx(j)를 outputArr[j-1] = 1로
        for(int n = 0; n < visited.length; n++) {
            if(visited[n] == true) {
                outputArr[i-1][n] = 1;
            }
        }

        // visited 초기화
        Arrays.fill(visited, false);
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        /*
        BFS로 탐색
        인접행렬 i번째 줄 -> i와 관계가 있는 인접 노드들
        1. int[][]
        2. visited[]
        3. queue
         */

        // index는 번호-1 잊지 말기!

        // 1. relatedArr 초기화
        relatedArr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                relatedArr[i][j] = sc.nextInt();
            }
        }

        // 2. visited 초기화
        visited = new boolean[N];
        // 3. outputArr 초기화
        outputArr = new int[N][N];
        // 4. bfs
        for(int m = 1; m <= N; m++) bfs(m);

        for(int l = 0; l < N; l++) {
            for(int m = 0; m < N; m++) {
                if(m == N-1) {
                    sb.append(outputArr[l][m]+"\n");
                } else {
                    sb.append(outputArr[l][m]+" ");
                }
            }
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
