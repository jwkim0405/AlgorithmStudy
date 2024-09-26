import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] count = new int[N+1];
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<M; i++){
            int before = sc.nextInt();
            int next = sc.nextInt();
            adj[before].add(next);
            count[next]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<N+1; i++){
            if(count[i]==0) queue.offer(i);
        }
        boolean[] visited = new boolean[N+1];
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+" ");
            
            for(int i = adj[node].size()-1; i>=0; i--){
                int nextnode = adj[node].get(i);
                count[nextnode]--;
                if(count[nextnode]==0) queue.offer(nextnode);
                adj[node].remove(i);
            }
        }
    }
}
