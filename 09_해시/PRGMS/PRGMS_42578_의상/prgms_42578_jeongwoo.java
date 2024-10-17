import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            // 만약 Map 함수에 옷 종류가 존재한다면, +1
            String key = clothes[i][1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } 
            // Map 함수에 옷 종류가 없다면
            else {
                map.put(key, 1);
            }
        }
        int cnt = 1;
        for (int value: map.values()) {
            cnt *= (value+1);
        }
        // 아무것도 뽑히지 않는 경우 제외(-1)
        return cnt-1;
    }
}
