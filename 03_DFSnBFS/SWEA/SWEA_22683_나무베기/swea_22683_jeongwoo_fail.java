package SWEA;

import java.util.Scanner;

public class swea_22683_나무베기_dfs {
    static int N; // 필드 크기
    static int K; // 나무 벨 수 있는 횟수
    static String[] field; // 필드
    static int start_x, start_y, end_x, end_y;
    static int minDistance;
    static boolean[][] visited; // 방문 처리 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            field = new String[N];
            visited = new boolean[N][N];

            // 필드 정보 입력
            for (int i = 0; i < N; i++) {
                field[i] = sc.next();
                for (int j = 0; j < N; j++) {
                    if (field[i].charAt(j) == 'X') {
                        start_x = i;
                        start_y = j;
                    } else if (field[i].charAt(j) == 'Y') {
                        end_x = i;
                        end_y = j;
                    }
                }
            }
            minDistance = Integer.MAX_VALUE;
            dfs(start_x, start_y, 0, 0, K);

            // 결과 출력
            System.out.println("#" + t + " " + minDistance);
        }
    }

    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // dfs 탐색(현재 좌표 x y, 현재 이동거리 cnt, 현재 남은 공격권)
    static void dfs(int r, int c, int cnt, int direction, int leftAttack) {
        visited[r][c] = true;
        // 기저 조건 1
        // 공격권이 마이너스가 되면 그냥 반환
        if (leftAttack < 0) {
            return;
        }

        // 기저 조건 2
        // 좌표 == 도착 지점
        if (r == end_x && c == end_y) {
            minDistance = Math.min(minDistance, cnt);
            return;
        }

        // 재귀 부분
        // 상 우 하 좌 보겠다!
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];


            // 같은 방향

            if (indexIn(nr, nc) && direction == i && !visited[nr][nc]) {
                dfs(nr, nc, cnt+1, direction, leftAttack);
            }
            // 서로 반대 방향인 경우
            else if (indexIn(nr, nc) && Math.abs(direction-i) == 2  && !visited[nr][nc]) {
                if (field[nr].charAt(nc) == 'T') {
                    dfs(nr, nc, cnt+3, i, leftAttack-1);
                }
                dfs(nr, nc, cnt+3, i, leftAttack);
            }
            // R 90도, L 90도
            else if (indexIn(nr, nc) && !visited[nr][nc]){
                if (field[nr].charAt(nc) == 'T'  && !visited[nr][nc]) {
                    dfs(nr, nc, cnt+2, i, leftAttack-1);
                }
                dfs(nr, nc, cnt+2, i, leftAttack);
            }
        } // for i

    }

    static boolean indexIn(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < N)
            return true;
        return false;
    }
}

