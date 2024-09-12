class Solution {
    static boolean[][] visited = new boolean[5][5];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] answer = new int[] {1, 1, 1, 1, 1};
    
    static void dfs(String[][] places, int room, int r, int c, int depth, boolean[][] visited) {
        visited[r][c] = true;
        if (depth == 2) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 범위 안에 있고, 방문 안 한 경우
            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {

                if (places[room][nr].charAt(nc) == 'X') {
                    visited[nr][nc] = true;
                    continue;
               }
                // 거리두기 안 된 경우!!
                else if (places[room][nr].charAt(nc) == 'P') {
                    answer[room] = 0;
                   return;
                } else if (places[room][nr].charAt(nc) == 'O') {
                    dfs(places, room, nr, nc, depth+1, visited);
                }
            } // for 범위
                
        } // for i
    } // dfs
    
    public int[] solution(String[][] places) {
 
        // 거리 1 확인
        for (int room = 0; room < 5; room++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[room][i].charAt(j) == 'P')
                        dfs(places, room, i, j, 0, visited); // 거리별 탐색
                }
            }
            System.out.println();
            
            // visited 배열 초기화
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    visited[i][j] = false;                    
                }
            }
        }
        return answer;
    } // method
} // class

