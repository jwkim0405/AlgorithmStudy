class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(k, 0, dungeons, 0);
        return answer;
    }
    
    public void dfs(int health, int count, int[][] dungeons, int visited){
        answer = Math.max(answer, count);
        for(int i = 0; i<dungeons.length; i++){
            //가서 깎이는 피가 지금 남은 피보다 크면 안감
            if(health<dungeons[i][0]) continue;
            //이미 방문한 곳이면 안감
            if((visited&(1<<i))!=0) continue;
            //다음 던전에서 피 깍인 것, 들른 던전수, 방문표시 해서 재귀돌림
            dfs(health-dungeons[i][1], count+1, dungeons, visited|(1<<i));
        }
    }
}
