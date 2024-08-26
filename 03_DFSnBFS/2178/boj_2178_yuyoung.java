import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2178_yuyoung {
    static int N; // 행
    static int M; // 열
    static int[][] maze;
    static boolean[][] visited; // 방문 여부

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                // 각 문자를 숫자로 변환
                maze[i][j] = line.charAt(j) - '0'; 
            }
        }

        // 미로의 최단 경로 계산
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        // 시작점의 좌표와 경로 길이 저장
        Queue<int[]> queue = new LinkedList<>();
        // 시작점(0,0)과 경로 길이 1을 큐에 삽입
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true; // 시작점 방문 표시

        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int r = item[0]; // 현재 행
            int c = item[1]; // 현재 열
            int sum = item[2]; // 시작점부터 현재 위치까지의 경로 길이

            // 현재 위치가 도착점인 경우, 경로 길이 반환
            if (r == N - 1 && c == M - 1)
                return sum;

            // 상하좌우로 위치 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 다음 위치가 미로 범위 내에 있고, 아직 방문하지 않은 경우
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문 표시
                    // 현재 경로 길이 + 1
                    queue.offer(new int[]{nr, nc, sum + 1});
                }
            }
        }
        // 도착점에 도달하지 못한 경우 0을 반환
        return 0;
    }
}
