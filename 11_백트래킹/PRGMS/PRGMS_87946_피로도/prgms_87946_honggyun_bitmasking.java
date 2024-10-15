class Solution {
    static int cnt;
    static int[][] targets;
    static int n;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        targets = dungeons;
        n = dungeons.length;

        adventure(k, 0 , 0);

        answer = cnt;
        return answer;
    }

    // recursive
    public void adventure(int currGage, int tmpCnt, int bitmask) {
//        cnt = tmpCnt > cnt ? tmpCnt : cnt;
        cnt = Math.max(tmpCnt, cnt);

        // // finish when all visited
        // if(bitmask == ((1 << dungeons.length) - 1)) {           
        //     cnt = tmpCnt > cnt ? tmpCnt : cnt;
        //     return;
        // }       

        // backtracking
        // currGage <= 0 (used all gage for adventure)
        if(currGage <= 0) {
            return;
        }

        // permutation for perfect conquer
        for(int i = 0; i < n; i++) {
            int essenGage = targets[i][0];
            int actualGage = targets[i][1];
            if((bitmask & (1 << i)) != 0 || essenGage > currGage) {
                continue; // already visited
            }
            // Go            
            adventure(currGage - actualGage, tmpCnt+1, bitmask | (1 << i)); // check next
        }

    }
}