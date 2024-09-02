// 한 달 전의 코드와의 차이: 기저 부분과 재귀 부분을 잘 나누었음! 코드 비교가 되네~
// 시간 되면 dp로 한 번 풀어보기!

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int N; // 치즈 한 변의 길이
    static int[][] cheese; // 치즈 위치별 맛 저장 배열
    static boolean[][] visited; // 덩어리 파악용 방문 배열
    static int max; // 가장 높은 맛 점수
    static int result; // 덩어리 최대 개수
    static int cnt; // 덩어리 개수

    // 델타탐색(상 하 좌 우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            cheese = new int[N][N];
            visited = new boolean[N][N];
            max = 0;

            // 배열에 위치별 맛 점수 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int yummy = sc.nextInt(); // 각 위치별 맛 점수
                    cheese[i][j] = yummy;
                    max = Math.max(max, yummy); // 가장 높은 맛 점수 갱신
                }
            }

            result = 1;
            // N일 == 맛 점수 N => 0으로 처리
            for (int i = 1; i <= max; i++) {
                for (int p = 0; p < N; p++) {
                    for (int q = 0; q < N; q++) {
                        if (cheese[p][q] == i) cheese[p][q] = 0;
                    }
                }

                // 덩어리 개수 파악 -> dfs
                cnt = 0;
                for (int p = 0; p < N; p++) {
                    for (int q = 0; q < N; q++) {
//                        System.out.println(p + " " + q + " " + visited[p][q] + " " + cheese[p][q]);
                        // 방문 안 했고, cheese값이 0이 아닌 경우 탐색!
                        if(!visited[p][q] && cheese[p][q] > 0) {
//                            System.out.println("** " + p + " " + q);
                            dfs(p, q);
                            cnt++;
                        }
                    }
                }

                // 덩어리 개수 최대 비교
                result = Math.max(result, cnt);

                // 방문 배열 초기화
                for (int j = 0; j < N; j++) {
                    Arrays.fill(visited[j], false);
                }
            } // for i

            System.out.println("#" + t + " " + result);
        } // tc
    } // main

    static void dfs(int r, int c) {
        visited[r][c] = true;
        // 상하좌우 델타탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 인덱스 범위 내에 속함 + 방문 안 함! + 갈 수 있음!
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheese[nr][nc] > 0) {
                dfs(nr, nc);
            }
        }

    }
}
