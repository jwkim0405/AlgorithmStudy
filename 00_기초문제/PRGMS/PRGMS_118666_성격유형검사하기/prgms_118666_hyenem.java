import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] arr = new int[4];
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',1);
        map.put('F',2);
        map.put('C',3);
        map.put('M',4);
        map.put('J',5);
        map.put('A',6);
        map.put('N',7);
        
        for(int i = 0; i<survey.length; i++){
            int idx = map.get(survey[i].charAt(0));
            arr[idx/2]+=(choices[i]-4)*Math.pow(-1, idx);
        }
        
        String ans = "";
        if(arr[0]>0) ans+="T";
        else ans+="R";
        if(arr[1]>=0) ans+="C";
        else ans+="F";
        if(arr[2]>=0) ans+="J";
        else ans+="M";
        if(arr[3]>0) ans+="N";
        else ans+="A";
        
        return ans;
    }
}
