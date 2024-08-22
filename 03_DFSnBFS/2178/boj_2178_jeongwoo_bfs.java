import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N; // 행 길이
    static int M; // 열 길이
    static String[] strMaze;
    static int[][] maze;
    static Queue<int[]> queue;
    //    static int result; // 최종 경로 거리(min)
    static boolean visited[][];


    // 델타 탐색(상하좌우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        // 각각의 배열 크기 선언
        strMaze = new String[N];
        maze = new int[N][M];
        queue = new LinkedList<>();
        visited = new boolean[N][M];

        // maze 배열에 0, 1 숫자 입력
        for (int i = 0; i < N; i++) {
            strMaze[i] = sc.next();
            for (int j = 0; j < M;j++) {
                maze[i][j] = Character.getNumericValue(strMaze[i].charAt(j));
            }
        }

        int result = bfs();

        System.out.println(result);

    }

    static int bfs() {
        int r, c, sum, nr, nc;

        queue.offer(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] item = queue.poll(); // 처음에 {0,0, 0} poll

            r = item[0];
            c = item[1];
            sum = item[2];
            if (r == N-1 && c == M-1)
                return sum; // 만약 마지막값에 도달했다면 거리 출력

            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];     // 다음 r
                nc = c + dc[i];     // 다음 c
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, sum + 1});
                }
            }
        }
        return 0;
    }
}

