import java.util.*;
class Solution {
    public int solution(String name) {
        int N = name.length();
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int i = 0; i<N; i++){
            int diff = Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            ans+=diff;
            if(diff!=0) list.add(i);
        }
        if(list.size()==0) return 0;
        int move = Integer.MAX_VALUE;
        for(int i = 0; i<list.size()-1; i++){
            move = Math.min(move, 2*list.get(i)+(N-list.get(i+1)));
            move = Math.min(move, list.get(i)+2*(N-list.get(i+1)));
        }
        move = Math.min(move, list.get(list.size()-1));
        if(list.get(0)==0){
            move = Math.min(N-list.get(1), move);
        } else {
            move = Math.min(N-list.get(0), move);
        }
        ans+=move;
        return ans;
    }
}
