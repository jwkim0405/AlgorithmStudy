import java.util.*;

public class prgms_성격유형검사하기 {
public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(21);
    for(int i : list) {
    	System.out.println(i);
    }
}
}
class Solution3 {
    static char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> map = new HashMap<>();
        for(char t : type){
        //각 타입을 키로 가지는 맵
            map.put(t, 0);
        }
        
        int idx = 0;
        for(int c : choices){
            //비동의 시 타입, 동의 시 타입
            char disagree = survey[idx].charAt(0);
            char agree = survey[idx].charAt(1);
            idx++;
            //비동의시
            if(c < 4)
                map.put(disagree, map.get(disagree) + (4-c));
            //동의시
            else
                map.put(agree, map.get(agree) + (c-4));
            
        }
        
        
        
        //결과 저장
         String result = "";
        result += map.get('R') >= map.get('T')? 'R' : 'T';
        result += map.get('C') >= map.get('F')? 'C' : 'F';
        result += map.get('J') >= map.get('M')? 'J' : 'M';
        result += map.get('A') >= map.get('N')? 'A' : 'N';
        
        return result;
       
        
    }
}