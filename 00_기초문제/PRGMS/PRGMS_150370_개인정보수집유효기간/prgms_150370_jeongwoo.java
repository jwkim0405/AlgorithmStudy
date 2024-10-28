import java.util.*;


// split에서 .split(".")이라고 하면 모든 문자를 뜻한다는 것, 알고 계셨나요?
// //.을 적어줘야 한다고 합니다 !!

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] stringToday = today.split("\\."); // YYYY, MM, DD String 배열로 받기
        int[] intToday = new int[3];
        // 연/월/일을 int 배열로 저장
        for (int i = 0; i < 3; i++) {
            intToday[i] = Integer.parseInt(stringToday[i]);
            // System.out.println(Arrays.toString(intToday));
        }
        
        // terms를 Map에 저장
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            map.put(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
        }
        
        // 파기해야 하는 값들 - 결과를 ArrayList에 저장
        List<Integer> list = new ArrayList<>(); // 파기해야 할 정보들 담은 배열
        
        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            // 개인정보 시작일
            String[] stringPrivacy = tmp[0].split("\\.");
            int[] intPrivacy = new int[3];
            // 개인정보 시작일 int배열로 저장
            for (int j = 0; j < 3; j++) {
                intPrivacy[j] = Integer.parseInt(stringPrivacy[j]);
            }
            // 약관 종류 - 맵의 약관 종류와 비교
            // Year 업데이트
            intPrivacy[0] += (map.get(tmp[1].charAt(0)) + intPrivacy[1]-1) / 12;
            // month 업데이트
            intPrivacy[1] = (map.get(tmp[1].charAt(0)) + intPrivacy[1]-1) % 12 + 1;
            
            // today와 파기 시작일 대소비교
            // 1. today가 더 연도가 높을 때
            if (intToday[0] > intPrivacy[0]) 
                list.add(i+1);
            // 2. today가 더 월이 높을 때
            else if (intToday[0] == intPrivacy[0] && intToday[1] > intPrivacy[1]) 
                list.add(i+1);
            // 3. today가 더 일이 높을 때
            else if (intToday[0] == intPrivacy[0] && intToday[1] == intPrivacy[1] && intToday[2] >= intPrivacy[2])
                list.add(i+1);
        }
        Collections.sort(list);
        int[] result= new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
