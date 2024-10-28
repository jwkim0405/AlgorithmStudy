import java.util.*;

public class prgms_개인정보수집유효기간 {

}

class Solution4 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> map = new HashMap<>();
        
        //약관, 유효기간을 분리해서 맵에 저장
        for(String i : terms){
            String[] term = i.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        //파기할 개인정보의 인덱스를 저장할 리스트
        List<Integer> list = new ArrayList<>();
        
        //수집된 개인정보를 분리
        for(int i = 0; i < privacies.length; i++){
            //1. 날짜와 약관종류 분리
            String[] privacy = privacies[i].split(" ");
            //2. 약관 유효기간을 일수로 치환하여 가입일에 더했을 때 
            //   오늘 날짜보다 이전일 경우 리스트에 인덱스+1을 저장
            if(getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= getDate(today)){
                list.add(i + 1);
            }
        }
        
        //출력,,
        int[] arr = new int[list.size()];
        int idx = 0;
        for(int i : list){
            arr[idx++] = i;
        }
        return arr;
    }

    //날짜를 일수로 치환
    private int getDate(String day){
        String[] date = day.split("\\.");
        
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int dayOfMonth = Integer.parseInt(date[2]);
        
        return (year * 12 * 28) + month * 28 + dayOfMonth;
    }
}