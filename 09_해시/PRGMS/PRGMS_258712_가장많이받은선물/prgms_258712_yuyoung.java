import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        
        // 친구 이름을 인덱스로 저장
        for (int i = 0; i < n; i++) {
            idx.put(friends[i], i); 
        }

        int[][] giftLog = new int[n][n]; // 친구들 간의 선물 기록을 저장
        int[] giftPoint = new int[n]; // 각 친구의 선물 지수를 저장
        
        for (String gift : gifts) {
            String[] g = gift.split(" ");
            int giver = idx.get(g[0]); // 선물을 준 사람의 인덱스
            int taker = idx.get(g[1]); // 선물을 받은 사람의 인덱스

            giftLog[giver][taker]++; // 선물을 준 기록을 증가
            giftPoint[giver]++; // 선물 준 사람의 선물 지수 증가
            giftPoint[taker]--; // 선물 받은 사람의 선물 지수 감소
        }

        int[] nextMonth = new int[n]; // 다음 달 선물 지수 비교 결과 저장
        
        // 각 친구 비교
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (giftLog[i][j] > giftLog[j][i]) { // i가 j보다 더 많이 선물한 경우
                    nextMonth[i]++;
                } else if (giftLog[i][j] < giftLog[j][i]) { // j가 i보다 더 많이 선물한 경우
                    nextMonth[j]++;
                } else { // 선물 횟수가 같은 경우 선물 지수로 비교
                    if (giftPoint[i] > giftPoint[j]) { // i의 선물 지수가 더 높으면
                        nextMonth[i]++;
                    } else if (giftPoint[i] < giftPoint[j]) { // j의 선물 지수가 더 높으면
                        nextMonth[j]++;
                    }
                }
            }
        }

        Arrays.sort(nextMonth);
        return nextMonth[n - 1]; // 정렬된 배열의 마지막 요소(최대값) 반환
    }
}
