import java.util.Scanner;

public class Main {
    static int R, C, T; // 방의 크기 R(행), C(열), 시뮬레이션 시간 T
    static int[][] map; // 방의 상태를 나타내는 2차원 배열
    static int cleanerTop, cleanerBottom; // 공기청정기의 위쪽과 아래쪽 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt(); // 행의 수
        C = sc.nextInt(); // 열의 수
        T = sc.nextInt(); // 시뮬레이션 시간

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                // 공기청정기의 위치 저장
                if (map[i][j] == -1) {
                    if (cleanerTop == 0) cleanerTop = i; // 위쪽 공기청정기 위치
                    cleanerBottom = i; // 아래쪽 공기청정기 위치
                }
            }
        }

        // T초 동안 시뮬레이션 반복
        for (int t = 0; t < T; t++) {
            spread(); // 미세먼지 확산
            runCleaner(); // 공기청정기 작동
        }

        // 남아있는 미세먼지의 양 계산
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) result += map[i][j]; // 미세먼지의 양이 양수인 경우만 합산
            }
        }

        // 결과 출력
        System.out.println(result);
    }

    // 미세먼지 확산을 처리하는 메소드
    static void spread() {
        int[][] tempMap = new int[R][C]; // 확산된 결과를 임시로 저장할 배열
        int[] dx = { -1, 1, 0, 0 }; // 이동할 방향 (상, 하, 좌, 우)
        int[] dy = { 0, 0, -1, 1 };

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) { // 미세먼지가 있는 경우
                    int spreadAmount = map[i][j] / 5; // 확산될 미세먼지의 양 (소수점 버림)
                    int spreadCount = 0; // 실제로 확산된 방향의 수

                    // 4방향으로 확산 시도
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        // 맵을 벗어나지 않고 공기청정기가 아닌 경우에만 확산
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1) {
                            tempMap[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }

                    // 확산된 후 남은 미세먼지를 현재 위치에 더함
                    tempMap[i][j] += map[i][j] - spreadAmount * spreadCount;
                }
            }
        }

        // 원래 맵을 임시 맵으로 갱신
        for (int i = 0; i < R; i++) {
            System.arraycopy(tempMap[i], 0, map[i], 0, C);
        }
    }

    // 공기청정기를 작동시키는 메소드
    static void runCleaner() {
        // 위쪽 공기청정기 작동 (반시계 방향)
        for (int i = cleanerTop - 1; i > 0; i--) map[i][0] = map[i - 1][0]; // 왼쪽 세로줄 위로 이동
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1]; // 위쪽 가로줄 왼쪽으로 이동
        for (int i = 0; i < cleanerTop; i++) map[i][C - 1] = map[i + 1][C - 1]; // 오른쪽 세로줄 아래로 이동
        for (int i = C - 1; i > 1; i--) map[cleanerTop][i] = map[cleanerTop][i - 1]; // 아래쪽 가로줄 오른쪽으로 이동
        map[cleanerTop][1] = 0; // 공기청정기에서 나오는 공기

        // 아래쪽 공기청정기 작동 (시계 방향)
        for (int i = cleanerBottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0]; // 왼쪽 세로줄 아래로 이동
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1]; // 아래쪽 가로줄 왼쪽으로 이동
        for (int i = R - 1; i > cleanerBottom; i--) map[i][C - 1] = map[i - 1][C - 1]; // 오른쪽 세로줄 위로 이동
        for (int i = C - 1; i > 1; i--) map[cleanerBottom][i] = map[cleanerBottom][i - 1]; // 위쪽 가로줄 오른쪽으로 이동
        map[cleanerBottom][1] = 0; // 공기청정기에서 나오는 공기
    }
}
