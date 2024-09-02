import java.util.Scanner;
import java.util.ArrayDeque;

class Solution {
    // 치즈 한 변의 길이 N
    static int N;
    // 치즈의 맛있는 정도를 저장하는 2D 배열
    static int[][] cheese;
    // BFS 탐색에서 방문 여부를 추적하는 2D 배열
    static boolean[][] visited;
    // BFS에서 상하좌우 네 방향으로의 이동을 나타내는 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt(); // 테스트 케이스 수 입력

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // 치즈 한 변의 길이 입력
            cheese = new int[N][N]; // 치즈 상태를 저장할 배열 초기화

            // 치즈 상태 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }

            int maxChunks = 1; // 초기 최대 덩어리 개수는 1로 설정

            // 1일부터 100일까지 요정이 치즈를 갉아먹는 날을 시뮬레이션
            for (int day = 1; day <= 100; day++) {
                visited = new boolean[N][N]; // 방문 배열 초기화
                int chunkCount = 0; // 현재 날짜에서의 덩어리 개수 초기화

                // 요정이 갉아먹은 치즈 상태로 갱신
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheese[i][j] <= day) {
                            cheese[i][j] = 0; // 맛있는 정도가 현재 날짜 이하인 칸은 갉아먹힘
                        }
                    }
                }

                // 남아있는 덩어리 수 세기
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        // 아직 방문하지 않았고 치즈가 남아있는 칸을 발견하면 BFS 수행
                        if (cheese[i][j] > 0 && !visited[i][j]) {
                            bfs(i, j);
                            chunkCount++; // 새로운 덩어리 발견 시 덩어리 개수 증가
                        }
                    }
                }

                // 덩어리 수의 최대값 갱신
                maxChunks = Math.max(maxChunks, chunkCount);
            }

            // 결과 출력 (테스트 케이스 번호와 함께 최대 덩어리 수 출력)
            System.out.println("#" + test_case + " " + maxChunks);
        }
        
        sc.close(); // 스캐너 닫기
    }
    
    // BFS를 사용하여 치즈 덩어리를 탐색
    static void bfs(int x, int y) {
        // 큐를 생성하여 시작 위치를 추가
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true; // 시작 위치를 방문했다고 표시

        // 큐가 빌 때까지 BFS 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치를 꺼냄
            int cx = current[0];
            int cy = current[1];

            // 상하좌우 네 방향으로 인접한 칸을 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 유효한 범위 내에서, 아직 방문하지 않았고 치즈가 남아있다면 큐에 추가
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && cheese[nx][ny] > 0) {
                    visited[nx][ny] = true; // 방문 표시
                    queue.add(new int[]{nx, ny}); // 다음 탐색을 위해 큐에 추가
                }
            }
        }
    }
}
