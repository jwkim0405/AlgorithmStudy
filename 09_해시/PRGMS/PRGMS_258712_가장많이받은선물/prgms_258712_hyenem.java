import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int N = friends.length;
        for(int i = 0; i<N; i++){
            map.put(friends[i], map.size());
        }
        
        int[][] give_take = new int[N][N];
        int[] idx = new int[N];
        for(int i = 0; i<gifts.length; i++){
            String[] pair = new String[]{"", ""};
            int pointer = 0;
            for(int j = 0; j<gifts[i].length(); j++){
                if(gifts[i].charAt(j)!=' '){
                    pair[pointer]+=gifts[i].charAt(j);
                } else {
                    pointer++;
                }
            }
            int giveMember = map.get(pair[0]);
            int takeMember = map.get(pair[1]);
            idx[giveMember]++;
            idx[takeMember]--;
            give_take[giveMember][takeMember]++;
        }
        
        int[] nextTake = new int[N];
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                if(give_take[i][j]<give_take[j][i]) nextTake[j]++;
                else if(give_take[i][j]>give_take[j][i]) nextTake[i]++;
                else {
                    if(idx[i]<idx[j]) nextTake[j]++;
                    else if(idx[i]>idx[j]) nextTake[i]++;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i<N; i++){
            answer = Math.max(answer, nextTake[i]);
        }
        return answer;
    }
}
