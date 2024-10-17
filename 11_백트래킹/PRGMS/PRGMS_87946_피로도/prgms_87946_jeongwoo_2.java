class Solution {
    static int len;
    static int maxCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        dfs(k, dungeons, 0);
        
        return maxCnt;
    }
    
    void dfs(int tired, int[][] dungeons, int cnt) {
        maxCnt = Math.max(cnt, maxCnt);
        for (int i = 0; i < len; i++) {
            int a = dungeons[i][0];
            int b = dungeons[i][1];
            
            if (tired-a >= 0 && a <= 10000) {
                dungeons[i][0] = 10001; // 방문 처리(dungeons의 최소 필요 피로도는 10000 이하)
                dfs(tired-b, dungeons, cnt+1);
                dungeons[i][0] = a; // 다시 방문 false 처리
            }
        }
    }
}
