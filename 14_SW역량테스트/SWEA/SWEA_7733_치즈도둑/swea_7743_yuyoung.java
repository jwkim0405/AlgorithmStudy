import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_7743_yuyoung {
    
    static int[][] cheese; // 치즈 배열
    static boolean[][] visited; // 방문 여부
    
    // 상, 하, 좌, 우
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 치즈의 한 변의 길이
            cheese = new int[N][N];
            
            // 치즈의 맛있는 정도 입력
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }
            
            int answer = 0; // 최대 치즈 덩어리 수
            
            // 0일부터 100일까지
            for(int i = 0; i <= 100; i++) {
                visited = new boolean[N][N];
                int nowCount = 0; // 현재 날에 존재하는 치즈 덩어리 수
                
                // 현재 날짜에 해당하는 맛있는 정도를 가진 치즈를 모두 먹음
                for(int j = 0; j < cheese.length; j++) {
                    for(int k = 0; k < cheese[j].length; k++) {
                        if(cheese[j][k] == i) {
                            cheese[j][k] = 0;
                        }
                    }
                }
                
                // 남아있는 치즈 덩어리 계산
                for(int j = 0; j < cheese.length; j++) {
                    for(int k = 0; k < cheese[j].length; k++) {
                        if(cheese[j][k] != 0 && !visited[j][k]) {
                            bfs(j, k); // BFS 탐색
                            nowCount++; // 덩어리 수 증가
                        }
                    }
                }
                
                // 최대 덩어리 수 갱신
                if(nowCount > answer) {
                    answer = nowCount;
                }
            }
            
            System.out.println("#" + tc + " " + answer);
        }
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y}); // 시작 좌표 큐에 추가
        visited[x][y] = true; // 시작 좌표 방문 처리
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 상하좌우 확인
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 다음 좌표가 유효한 범위 내에 있는지 확인
                if(nx >= 0 && ny >= 0 && nx < cheese.length && ny < cheese[0].length) {
                    // 치즈가 남아있고 방문하지 않은 경우
                    if(cheese[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true; // 방문 처리
                        q.offer(new int[] {nx, ny}); // 큐에 추가
                    }
                }
            }
        }
    }
}
