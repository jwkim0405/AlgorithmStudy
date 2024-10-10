import java.util.*;

public class swea_22683_yuyoung {
    
    // 방향: 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    // 상태를 저장하는 클래스
    static class State {
        int x, y, direction, cutCount, moveCount;
        
        public State(int x, int y, int direction, int cutCount, int moveCount) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cutCount = cutCount; // 나무를 벨 수 있는 횟수 (남은 횟수)
            this.moveCount = moveCount; // 이동한 횟수
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 필드 크기
            int K = sc.nextInt(); // 나무를 벨 수 있는 횟수
            char[][] field = new char[N][N];
            
            int startX = 0;
            int startY = 0;
            int endX = 0;
            int endY = 0;
            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < N; j++) {
                    field[i][j] = line.charAt(j);
                    if (field[i][j] == 'X') { // 출발지
                        startX = i;
                        startY = j;
                    } else if (field[i][j] == 'Y') { // 목적지
                        endX = i;
                        endY = j;
                    }
                }
            }
            
            // BFS 탐색 시작
            int result = bfs(N, K, field, startX, startY, endX, endY);
            System.out.println("#" + tc + " " + result);
        }
    }
    
    // BFS 탐색
    private static int bfs(int N, int K, char[][] field, int startX, int startY, int endX, int endY) {
        
        boolean[][][][] visited = new boolean[N][N][4][K + 1];
        Queue<State> q = new LinkedList<>();
        
        // 시작 위치는 0 방향에서 시작
        q.offer(new State(startX, startY, 0, K, 0));
        visited[startX][startY][0][K] = true;
        
        while (!q.isEmpty()) {
            State current = q.poll();
            
            // 목적지에 도착한 경우
            if (current.x == endX && current.y == endY) {
                return current.moveCount;
            }
            
            // 4 방향 탐색
            int nx = current.x + dx[current.direction];
            int ny = current.y + dy[current.direction];
            
            // 필드 경계 확인 및 나무 여부 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 나무가 있는 경우
                if (field[nx][ny] == 'T' && current.cutCount > 0 && !visited[nx][ny][current.direction][current.cutCount - 1]) {
                    q.offer(new State(nx, ny, current.direction, current.cutCount - 1, current.moveCount + 1));
                    visited[nx][ny][current.direction][current.cutCount - 1] = true;
                }
                // 나무가 없는 경우 이동
                else if (field[nx][ny] == 'G' || field[nx][ny] == 'Y') {
                    if (!visited[nx][ny][current.direction][current.cutCount]) {
                        q.offer(new State(nx, ny, current.direction, current.cutCount, current.moveCount + 1));
                        visited[nx][ny][current.direction][current.cutCount] = true;
                    }
                }
            }
            
            // 좌/우 회전
            int leftDir = (current.direction + 3) % 4;
            int rightDir = (current.direction + 1) % 4;
            
            if (!visited[current.x][current.y][leftDir][current.cutCount]) {
                q.offer(new State(current.x, current.y, leftDir, current.cutCount, current.moveCount + 1));
                visited[current.x][current.y][leftDir][current.cutCount] = true;
            }
            
            if (!visited[current.x][current.y][rightDir][current.cutCount]) {
                q.offer(new State(current.x, current.y, rightDir, current.cutCount, current.moveCount + 1));
                visited[current.x][current.y][rightDir][current.cutCount] = true;
            }
        }
        
        // 목적지에 도달할 수 없는 경우
        return -1;
    }
}