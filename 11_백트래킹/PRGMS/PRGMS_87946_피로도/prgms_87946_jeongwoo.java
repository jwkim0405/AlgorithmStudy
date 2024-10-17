class Solution {
    static int maxCnt;
    static boolean flag;
    public int solution(int k, int[][] dungeons) {
        // dungeons => 최소 필요 피로도, 소모 피로도
        boolean[] visited = new boolean[dungeons.length];
        
        // 0->1->2
        // 0->2->1
        // 1->0->2
        // 1->2->0
        // ... 위 방식으로 모든 경우 탐색
        for (int i = 0; i < dungeons.length; i++) {
            dfs(k, i, dungeons, visited, 0);
            // System.out.println();
        }
        return maxCnt;
    }
    
    static void dfs(int energy, int idx, int[][] dungeons, boolean[] visited, int cnt) {
        // System.out.println(idx);
        
        // 기저 부분 1
        // energy < 현재 최소 필요 피로도 =>  반환
        if (flag || energy-dungeons[idx][0] < 0) {
            maxCnt = Math.max(maxCnt, cnt);
            // System.out.println("cnt: " + cnt);
            return;
        }
        // 기저 부분 2
        // 개수가 모두 채워지면 반환
        if (cnt == dungeons.length-1) {
            maxCnt = cnt+1;
            flag = true;
            // System.out.println("cnt: " + cnt);
            return;
        }
        visited[idx] = true; // 방문 처리
        
        for (int i = 0; i < dungeons.length; i++) {
            // 방문 안했다면, dfs
            if (!visited[i]) {
                dfs(energy-dungeons[idx][1], i, dungeons, visited, cnt+1); // 남은 에너지, 다음 인덱스
                visited[i] = false;
            }
        }
        visited[idx] = false;
    }
}
