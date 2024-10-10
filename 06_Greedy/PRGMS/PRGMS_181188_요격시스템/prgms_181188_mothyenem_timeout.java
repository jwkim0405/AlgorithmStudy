import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int ans;
    
    public int solution(int[][] targets) {
        ans = Integer.MAX_VALUE;
        visited = new boolean[targets.length];
        visited[0] = true;
        dfs(0, 1, targets);
        
        return ans;
    }
    
    static void dfs(int index, int count, int[][] targets){
        boolean check=false;
        for(int i = 0; i<targets.length; i++){
            if(!visited[i]) {
                check = true;
                break;
            }
        }
        if(!check) {
            ans = Math.min(ans, count);
            return;
        }
        
        int start = targets[index][0];
        int end = targets[index][1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = start; i<end; i++){
            for(int j = 0; j<targets.length; j++){
                if(visited[j]) continue;
                int nextStart = targets[j][0];
                int nextEnd = targets[j][1];
                if(i>=nextStart && i<nextEnd){
                    visited[j]=true;
                    queue.offer(j);
                }
            }
            for(int j = index+1; j<targets.length; j++){
                if(visited[j]) continue;
                visited[j]=true;
                dfs(j, count+1, targets);
                visited[j]=false;
                break;
            }
            while(!queue.isEmpty()){
                visited[queue.poll()]=false;
            }
        }
    }
}
