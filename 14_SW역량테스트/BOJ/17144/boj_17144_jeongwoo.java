import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int cnt; // 미세먼지 퍼지는 4개 방향 중에서 실제로 퍼지는 곳 개수
    static int dust; // 퍼지는 미세먼지 양
    // 상하좌우 델타 탐색
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] new_map;
    static int[] cleaner;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기 설정(초기값 입력)
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();
        int[][] map = new int[R][C]; // 미세먼지 출력

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (j == 0 && map[i][j] == -1)
                    cleaner = new int[]{i, j}; // 결과적으로 cleaner의 아랫 부분 r, c 좌표 값이 나옴
            }
        }

//        System.out.println(Arrays.toString(cleaner) + "\n");

        // t초 후 미세먼지 양 계산
        for (int t = 0; t < T; t++){
            new_map = new int[R][C]; // new_map에 담겠습니다.

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    // (r, c) 칸에 미세먼지가 있다!
                    if (map[r][c] > 0) {
                        cnt = 0;
                        // 사방으로 퍼뜨리고 남은 먼지 양을 보관하자!
                        dust = map[r][c] / 5; // 퍼지는 미세먼지 양
//                        System.out.print(r + ", " + c + ": "); // ** 디버깅코드
                        for (int i = 0; i < 4; i++) {

                            int nr = r + dr[i]; // 미세먼지 퍼지는 행
                            int nc = c + dc[i]; // 미세먼지 퍼지는 열
                            // 공기청정기와 붙어있지 않아야 함 + 인덱스에서 벗어난 값이 아니어야 함
                            if (nr >= 0 && nr < R && nc >= 0 && nc < C && noCleaner(nr, nc)) {
                                new_map[nr][nc] += dust;
                                cnt++;
//                                System.out.printf("(%d, %d, cnt: %d)", nr, nc, cnt);
                            }
                        }
                        new_map[r][c] += (map[r][c] - cnt * dust);
//                        System.out.printf("new_map: %d", new_map[r][c]);
                    }
//                    System.out.println();
                } // for c
            } // for r

            // 원본 배열에 복사
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = new_map[i][j];
                }
            }

            // i초 후 공기청정기 turn on
            // 위쪽 공기 청정기: 시계반대방향 (cleaner[0]-1, 1)부터 시작
            // 하지만, 거꾸로! 청정기에 들어가는 것부터 시작
            // 1. 위쪽 -> 아래쪽 방향 (공기청정기에 들어가는 순간부터 위로 탐색)
            for (int i = cleaner[0]-3; i >= 0; i--)
                map[i+1][0] = map[i][0];

            // 2. 오른쪽 -> 왼쪽 방향(가장 왼쪽부터 오른쪽 탐색)
            for(int i = 1; i < C; i++)
                map[0][i-1] = map[0][i];

            // 3. 아래쪽 -> 위쪽 방향(가장 위쪽부터 아래쪽 탐색)
            for (int i = 1; i <= cleaner[0]-1; i++)
                map[i-1][C-1] = map[i][C-1];

            // 4. 왼쪽 -> 오른쪾 방향(가장 오른쪽부터 왼쪽 탐색)
            for (int i = C-2; i >= 1; i--)
                map[cleaner[0]-1][i+1] = map[cleaner[0]-1][i];
            map[cleaner[0]-1][1] = 0;

            // 아래쪽 공기 청정기: 시계방향 (cleaner[0], 1)부터 시작
            // 1. 아래쪽 -> 위쪽 : 공기 청정기 들어가는 것부터(가장 위에서 아래로 넣기)
            for (int i = cleaner[0]+2; i < R; i++)
                map[i-1][0] = map[i][0];

            // 2. 오른쪽 -> 왼쪽 방향 (왼쪽부터 채우기)
            for (int i = 1; i < C; i++)
                map[R-1][i-1] = map[R-1][i];

            // 3. 위쪽 -> 아래쪽 (아래쪽부터 채우기)
            for (int i = R-2; i >= cleaner[0]; i--)
                map[i+1][C-1] = map[i][C-1];

            // 4. 왼쪽 -> 오른쪽 (오른쪽부터 채우기)
            for (int i = C-2; i >= 1; i--)
                map[cleaner[0]][i+1] = map[cleaner[0]][i];
            map[cleaner[0]][1] = 0;
        } // for t

//        // 중간점검: 미세먼지 잘 확산되나?
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(map[i][j] + " ");
//            } System.out.println();
//        }
    int sum = 0; // 공기청정기 -2 포함시켜 계산 예정
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            sum += map[i][j];
        }
    }
    System.out.println(sum);
    } // main


    static boolean noCleaner(int nr, int nc) {
        // 청정기 칸!
        if ((nr == cleaner[0] || nr == cleaner[0]-1) && nc == cleaner[1])
            return false;
        // 아니라면
        return true;
    }
} // class

