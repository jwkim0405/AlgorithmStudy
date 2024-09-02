import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 인접 칸 정보 저장할 배열
    static ArrayList<Integer>[] neighbors;
    // visited 배열
    static boolean[] visited;

    // dfs()
    static void dfs() {
        // 1, 1에서 출발함
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);
        /*
        DFS로 완전 탐색
        미로의 i, j와 인접해 있는 칸의 정보를 델타 탐색으로 저장(상, 우, 하만 보면 됨)
        -> 이 때 배열 범위 벗어나지 않도록 주의

        지나야하는 최소 칸 수 구하기 <- how?
         */
        int N = sc.nextInt(); // N <= 100
        int M = sc.nextInt(); // M <= 100

        // 각 칸 마다 숫자 부여
        visited = new boolean[(N*M)+1];
        neighbors = new ArrayList[(N*M)+1];

        // 미로 받기, 각 줄은 붙어서 입력으로 주어짐
        int[][] maze = new int[N][M];
        for(int i = 0; i < N; i++) { // N -> row
            String line = sc.next();
            for(int j = 0; j < M; j++) { // M -> column
                char c = line.charAt(j);
                maze[i][j] = c - '0'; // char to int
            }
        }

        // 델타 탐색 (상, 우, 하)
        int[] dr = { 1, 0, -1 };
        int[] dc = { 0, 1, 0 };

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                for(int d = 0; d < 3; d++) { // 델타 배열 index d
                    if (r + dr[d] < N || r + dr[d] >= 0 || c + dc[d] < M || c + dc[d] >= 0) { // 델타 적용이 배열 범위 안이면
                        int mr = r + dr[d];
                        int mc = c + dc[d];
                        int moved = maze[mr][mc];

                        // 인접한 칸이면 (r * M) + c 번째 칸이므로 그 값을 저장
                        // -> 그 값을 M으로 나눈 몫이 r, 나머지가 c
                        if(moved == 1) neighbors[(r*M) + c].add((r*M) + c);
                    }
                }
            }
        }

    }
}
