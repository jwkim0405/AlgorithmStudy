import java.util.Scanner;

public class Main {
    static int R, C, T;
    static int[][] room;
    static int[] purifier = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        room = new int[R][C];
        int purifierIdx = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] = sc.nextInt();
                if (room[i][j] == -1) {
                    purifier[purifierIdx++] = i;  // 공기청정기 위치 저장
                }
            }
        }

        // T초 동안 반복
        for (int t = 0; t < T; t++) {
            spread();
            purify();
        }

        // 남은 미세먼지의 양 계산
        int totalDust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    totalDust += room[i][j];
                }
            }
        }

        System.out.println(totalDust);
        sc.close();
    }

    // 미세먼지 확산
    static void spread() {
        int[][] newRoom = new int[R][C];

        // 공기청정기 위치 그대로 복사
        newRoom[purifier[0]][0] = -1;
        newRoom[purifier[1]][0] = -1;

        int[] dx = { -1, 1, 0, 0 }; // 상하좌우
        int[] dy = { 0, 0, -1, 1 };

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    int dust = room[i][j] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && room[nx][ny] != -1) {
                            newRoom[nx][ny] += dust;
                            spreadCount++;
                        }
                    }
                    newRoom[i][j] += room[i][j] - dust * spreadCount;
                }
            }
        }

        // 새로운 상태로 방 갱신
        room = newRoom;
    }

    // 공기청정기 작동
    static void purify() {
        // 위쪽 공기청정기 (반시계 방향)
        int top = purifier[0];

        // 위쪽 공기청정기의 바람 순환
        for (int i = top - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            room[0][i] = room[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            room[top][i] = room[top][i - 1];
        }
        room[top][1] = 0;  // 공기청정기 바람이 나오는 곳

        // 아래쪽 공기청정기 (시계 방향)
        int bottom = purifier[1];

        // 아래쪽 공기청정기의 바람 순환
        for (int i = bottom + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            room[R - 1][i] = room[R - 1][i + 1];
        }
        for (int i = R - 1; i > bottom; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            room[bottom][i] = room[bottom][i - 1];
        }
        room[bottom][1] = 0;  // 공기청정기 바람이 나오는 곳
    }
}
