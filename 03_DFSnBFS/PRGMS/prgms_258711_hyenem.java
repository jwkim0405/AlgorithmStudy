import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int E = edges.length;
        ArrayList<Integer>[] adj = new ArrayList[1000001];
        int[] inout = new int[1000001];
        for(int i = 0; i<1000001; i++){
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0; i<E; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            inout[from]--;
            inout[to]++;
        }
        for(int i=1; i<1000001; i++){
            if(inout[i]<-1){
                answer[0]=i;
                break;
            }
        }
        boolean[] visited = new boolean[1000001];
        for(int i=0; i<adj[answer[0]].size(); i++){
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(adj[answer[0]].get(i));
            visited[adj[answer[0]].get(i)]=true;
            while (!queue.isEmpty()){
                int item = queue.poll();
                for(int j=0; j<adj[item].size(); j++){
                    int next = adj[item].get(j);
                    if(visited[next]) count++;
                    else {
                        queue.offer(next);
                        visited[next]=true;
                    }
                }
            }
            if(count==2) answer[3]++;
            else if(count==1) answer[1]++;
            else answer[2]++;
         }
        return answer;
    }
}

