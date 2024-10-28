import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        // 성격 유형
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        // 성격 유형과 해당 유형의 점수
        Map<Character, Integer> map = new HashMap<>(); 

        // 0으로 초기화
        for (int i = 0; i < type.length; i++) {
            map.put(type[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            // survey 왼쪽 선택지
            char left = survey[i].charAt(0);
            // survey 오른쪽 선택지
            char right = survey[i].charAt(1);

            // 선택지가 4인 경우는 패스
            if (choices[i] == 4) {
                continue;
            } 
            // 왼쪽 더 선호되는 경우
            else if (choices[i] < 4) {
                // 해당 성격 유형의 점수를 증가
                map.put(left, map.get(left) + (4 - choices[i]));
            } 
            // 오른쪽 더 선호되는 경우
            else {
                // 해당 성격 유형의 점수를 증가
                map.put(right, map.get(right) + (choices[i] - 4));
            }
        }

        // 각 성격 유형별 점수를 비교하여 최종 결과 문자열에 추가
        for (int i = 0; i < type.length; i += 2) {
            char left = type[i]; // 현재 성격 유형의 왼쪽 선택지
            char right = type[i + 1]; // 현재 성격 유형의 오른쪽 선택지

            // 왼쪽 선택지의 점수가 더 크거나 같으면 왼쪽 성격 유형 추가
            if (map.get(left) >= map.get(right)) {
                answer.append(left);
            } 
            // 오른쪽 선택지의 점수가 더 크면 오른쪽 성격 유형 추가
            else {
                answer.append(right);
            }
        }

        return answer.toString();
    }
}