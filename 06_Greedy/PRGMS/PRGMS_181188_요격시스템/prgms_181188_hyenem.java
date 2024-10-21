import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Node node){
            return this.end-node.end;
        }
        
    }
    
    public int solution(int[][] targets) {
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i<targets.length; i++){
            list.add(new Node(targets[i][0], targets[i][1]));
        }
        list.sort(null);
        
        int ans = 1;
        int idx = 0;
        for(int i=1; i<targets.length; i++){
            if(list.get(i).start<list.get(idx).end) continue;
            idx = i;
            ans++;
        }
        
        return ans;
    }
}
