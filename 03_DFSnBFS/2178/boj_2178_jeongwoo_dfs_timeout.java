package BOJ_2178_미로탐색_DFS;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static boolean[][] visited; // 방문 여부
    static String[] strMaze; // 미로 길
    static int[][] maze; // int형 값 변환
    static int min = Integer.MAX_VALUE;

    // 델타 탐색
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        // 각 배열 생성
        visited = new boolean[N][M];
        strMaze = new String[N];
        maze = new int[N][M];

        for (int i = 0; i < N; i++)
            strMaze[i] = sc.next();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 숫자로 변환하여 저장
                maze[i][j] = Character.getNumericValue(strMaze[i].charAt(j));
            }
        }
        dfs(0, 0, 1);
        System.out.println(min);
    }
    static void dfs(int r, int c, int sum) {
        visited[r][c] = true;
        if (r == N-1 && c == M-1) { // 마지막 지점에 도착하면 sum값이 최소값인지 확인!
            min = Math.min(min, sum);
            return;
        }

        int nr;
        int nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            // maze 배열 인덱스 내의 값 + 아직 방문 안 했다면!
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc, sum + 1);
                visited[nr][nc] = false;
            }
        }

    }
}

