class Solution_first {
    static int cnt;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];

        adventure(k, dungeons, 0, 0);

        answer = cnt;
        return answer;
    }

    // recursive
    public void adventure(int currGage, int[][] dungeons, int tmpCnt, int idx) {
        // finish when
        if(idx >= dungeons.length) {
            cnt = tmpCnt > cnt ? tmpCnt : cnt;
            return;
        }

        // backtracking     
        // currGage <= 0 (used all gage for adventure)
        if(currGage <= 0) {
            return;
        }

        // permutation for perfect conquer
        for(int i = 0; i < dungeons.length; i++) {
            int essenGage = dungeons[i][0];
            int actualGage = dungeons[i][1];
            if(visited[i] || essenGage > currGage) continue; // already visited
            // Go
            visited[i] = true;
            adventure(currGage - actualGage, dungeons, tmpCnt+1, idx+1); // check next   

            // No
            visited[i] = false;
            adventure(currGage, dungeons, tmpCnt, idx+1);
        }

    }
}