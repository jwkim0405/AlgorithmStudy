import java.util.Scanner;

public class Main {
    // 방의 크기 R(행)과 C(열), 그리고 진행 시간 T
    static int R, C, T;
    
    // 방의 상태를 저장하는 2차원 배열
    // room[i][j]는 i행 j열의 미세먼지 양을 의미함
    static int[][] room;
    
    // 공기청정기의 위치를 저장하는 배열 (두 행의 위치)
    static int[] purifier = new int[2];

    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 방의 크기 R (행)과 C (열), 그리고 T (초) 입력 받기
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        // 방의 상태를 저장할 room 배열 초기화
        room = new int[R][C];
        
        // 공기청정기의 위치를 저장하기 위한 인덱스 (공기청정기는 항상 두 줄에 걸쳐있음)
        int purifierIdx = 0;

        // 방의 상태를 입력받음
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] = sc.nextInt();
                
                // 공기청정기가 있는 위치는 -1로 표시됨
                if (room[i][j] == -1) {
                    purifier[purifierIdx++] = i;  // 공기청정기 위치 저장
                }
            }
        }

        // T초 동안 확산과 공기청정기 작동 반복
        for (int t = 0; t < T; t++) {
            spread();  // 미세먼지 확산
            purify();  // 공기청정기 작동
        }

        // 남아있는 미세먼지의 총량 계산
        int totalDust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 공기청정기(-1) 칸은 제외하고 미세먼지 양을 더함
                if (room[i][j] > 0) {
                    totalDust += room[i][j];
                }
            }
        }

        // 최종 미세먼지 양 출력
        System.out.println(totalDust);
        sc.close();
    }

    // 미세먼지 확산 함수
    static void spread() {
        // 확산 후의 상태를 저장할 새로운 방 상태 배열
        int[][] newRoom = new int[R][C];

        // 공기청정기 위치는 확산 후에도 그대로 유지되므로 복사
        newRoom[purifier[0]][0] = -1;
        newRoom[purifier[1]][0] = -1;

        // 네 방향(상, 하, 좌, 우)으로의 이동을 나타내는 배열
        int[] dx = { -1, 1, 0, 0 };  // 상, 하
        int[] dy = { 0, 0, -1, 1 };  // 좌, 우

        // 방의 모든 칸을 순회하며 미세먼지 확산 처리
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 미세먼지가 있는 칸만 처리
                if (room[i][j] > 0) {
                    // 확산될 미세먼지 양 (5로 나눈 값, 소수점 이하 버림)
                    int dust = room[i][j] / 5;
                    int spreadCount = 0;  // 확산된 방향의 개수를 셈

                    // 네 방향으로 확산 시도
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];  // 새로운 행 좌표
                        int ny = j + dy[d];  // 새로운 열 좌표

                        // 확산할 수 있는 경우 (범위를 벗어나지 않고 공기청정기가 없는 경우)
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && room[nx][ny] != -1) {
                            newRoom[nx][ny] += dust;  // 확산된 미세먼지를 더해줌
                            spreadCount++;  // 확산된 방향 수 증가
                        }
                    }
                    // 현재 칸에 남아있는 미세먼지 양 갱신 (확산된 만큼 뺌)
                    newRoom[i][j] += room[i][j] - dust * spreadCount;
                }
            }
        }

        // 확산 후의 방 상태로 기존 방 상태를 갱신
        room = newRoom;
    }

    // 공기청정기 작동 함수
    static void purify() {
        // 공기청정기 위쪽 부분 작동 (반시계방향 순환)
        int top = purifier[0];

        // 1. 첫 번째 열에서 위쪽으로 이동
        for (int i = top - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }

        // 2. 맨 윗 행에서 왼쪽에서 오른쪽으로 이동
        for (int i = 0; i < C - 1; i++) {
            room[0][i] = room[0][i + 1];
        }

        // 3. 마지막 열에서 아래쪽으로 이동
        for (int i = 0; i < top; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }

        // 4. 공기청정기 바로 위쪽 행에서 오른쪽에서 왼쪽으로 이동
        for (int i = C - 1; i > 1; i--) {
            room[top][i] = room[top][i - 1];
        }

        // 공기청정기에서 나오는 바람은 미세먼지를 제거하므로 공기청정기 바로 옆 칸은 0
        room[top][1] = 0;

        // 공기청정기 아래쪽 부분 작동 (시계방향 순환)
        int bottom = purifier[1];

        // 1. 첫 번째 열에서 아래쪽으로 이동
        for (int i = bottom + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }

        // 2. 맨 아래 행에서 왼쪽에서 오른쪽으로 이동
        for (int i = 0; i < C - 1; i++) {
            room[R - 1][i] = room[R - 1][i + 1];
        }

        // 3. 마지막 열에서 위쪽으로 이동
        for (int i = R - 1; i > bottom; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }

        // 4. 공기청정기 바로 아래쪽 행에서 오른쪽에서 왼쪽으로 이동
        for (int i = C - 1; i > 1; i--) {
            room[bottom][i] = room[bottom][i - 1];
        }

        // 공기청정기에서 나오는 바람은 미세먼지를 제거하므로 공기청정기 바로 옆 칸은 0
        room[bottom][1] = 0;
    }
}
