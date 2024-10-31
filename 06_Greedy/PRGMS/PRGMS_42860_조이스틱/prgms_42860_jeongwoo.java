// ** 순방향으로 가다가 되돌아서 역방향 가는 케이스 추가하기

import java.util.*;

class Solution {
    public int solution(String name) {
        int len = name.length();
        // #1. 이동 순서 결정
        // 오른쪽으로 이동할지, 왼쪽으로 이동할지 결정
        int normalFlow = 0; // 순방향으로 마지막에 연속으로 나오는 A 개수(마지막 문자부터 역순으로 보기)
        int reverseFlow = 0; // 역방향으로 마지막에 나오는 A개수(2번째 문자부터 순서대로 보기)
        // #1-1. 순방향
        for (int i = len-1; i >= 0; i--) {
            if (name.charAt(i) == 'A') normalFlow++;
            else break;
        }
        
        // #1-2. 역방향
        for (int i = 1; i < len; i++) {
            if (name.charAt(i) == 'A') reverseFlow++;
            else break;
        }
        int max = Math.max(normalFlow, reverseFlow);
        int answer = 0;
        if (max == len) answer = 0;
        else answer = len - 1 - max;
        

        // #1-3. 순방향 + 역방향
        // A가 아닌 인덱스 모두 담아
        // ++
        // if A가 아닌 값이 나오면! 
        // 그 다음 A가 나올 때까지 역방향 이동
        
        List<Integer> notA = new ArrayList<>();
        int cnt = 0;
        // A가 아닌 인덱스들을 모두 저장
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) != 'A') {
                notA.add(i);
                cnt++;
            }
        }
        // i번째까지 notA까지 순방향, 그리고 역방향
        for (int i = 0; i < cnt - 1; i++) {
            // i = 0부터 마지막 notA까지
            int tmp = notA.get(i) * 2 + (len - notA.get(i+1));
            answer = Math.min(tmp, answer);
        }
        
        // #1-4. 역방향 + 순방향
        for (int i = cnt-1; i >= 1; i--) {
            int tmp = (len-notA.get(i))*2 + notA.get(i-1);
            answer = Math.min(tmp, answer);
        }
        
        
        // #2. 각각을 A에서 해당 문자로 바꾸는 경우
        for (int i = 0; i < len; i++) {
            answer += minDistance(name.charAt(i));
        }
        
        // #3. 결과 반환
        return answer;
    }
    
    static int minDistance(char c) {
        return Math.min(c - 'A', 'Z' + 1 - c);
    }
}
