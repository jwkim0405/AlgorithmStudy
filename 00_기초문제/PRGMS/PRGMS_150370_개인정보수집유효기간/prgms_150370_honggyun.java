import java.util.*;

class Solution {
    static Map<String, String> map; // term을 저장할 맵
    // today: 오늘 날짜("yyyy.mm.dd")
    // terms: 약관 종류("종류 기간")
    // privacies: [i] => "수집된날짜 약관종류"
    public int[] solution(String today, String[] terms, String[] privacies) {
        map = new HashMap<>();

        for(String term : terms) {
            String type = term.split(" ")[0]; // 약관 종류
            String validTime = term.split(" ")[1]; // 종류에 따른 유효 기간(month)
            map.put(type, validTime); // key: type, value: validTime
        } // term 저장 끝

        List<Integer> list = new ArrayList<>(); // 정답 i+1번째를 저장할 리스트
        int cnt = 1; // idx+1번째를 저장할 변수
        // privacies를 하나씩 꺼내서 파기 여부 확인
        for(String privacy : privacies) {
            int nth = checkValidation(privacy, today);
            if(nth == 1) {
                list.add(cnt);
            } // 아직 유효하면 -1을 반환하므로 그 이외 파기할 것만 리스트에 넣기

            cnt++; // to the next
        }



        int[] answer = list.stream().mapToInt(Integer::intValue).toArray(); // ArrayList to int Array
        return answer;
    } // solution()

    // 파기 여부 확인
    public int checkValidation(String privacy, String today) {
        String time = privacy.split(" ")[0];
        String type = privacy.split(" ")[1];

        int privacyValidDate = stringToInt(time, type);
        int todayDate = stringToInt(today, "today");

        // 날짜가 지났다면
        if(privacyValidDate < todayDate) {
            return 1;
        } else {
            return 0;
        }
    }

    // parse String to Int, 총 일수 반환
    public int stringToInt(String time, String type) {
        // split 한 후 String을 int로 변환
        // 정규식에서 .은 모든 문자를 나타내므로, 역슬래시를 활용해 진짜 "."을 가리키도록
        int year = Integer.parseInt(time.split("\\.")[0]);
        int month = Integer.parseInt(time.split("\\.")[1]);
        int day = Integer.parseInt(time.split("\\.")[2]);

        int sum = 0;
        // today면
        if(type.equals("today")) {
            sum += (year - 2000) * 12 * 28; // 일 수로 변환, 2000년을 기준으로 0으로 설정
            sum += (month - 1) * 28; // 일 수로 변환, 1월을 기준으로 0으로 설정
            sum += day - 1; // 1일을 기준으로 0으로 설정
            return sum; // 즉, 최소 날짜인 2000.01.01을 0일로 설정하고 계산 시작
        }

        // privacy면
        month = month + Integer.parseInt(map.get(type));
        sum += (year - 2000) * 12 * 28; // 일 수로 변환, 2000년을 기준으로 0으로 설정
        sum += (month - 1) * 28; // 일 수로 변환, 1월을 기준으로 0으로 설정
        sum += day - 2; // 1일을 기준으로 0으로 설정, 1달 이상이 지나면 day 하루 전날까지 가능

        return sum;
    }

}