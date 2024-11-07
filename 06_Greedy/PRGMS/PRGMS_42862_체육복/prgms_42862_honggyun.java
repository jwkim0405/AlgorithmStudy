import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 학생이 가지고 있는 체육복 개수 배열
        int[] gymSuits = new int[n+1];
        Arrays.fill(gymSuits, 1); // 일단 1개씩 들고 있도록..
        gymSuits[0] = 0; // 0번은 존재하지 않는다.

        // 도난 체크
        for(int loss : lost) {
            gymSuits[loss] -= 1;
        }

        // 여분 체크
        for(int rest : reserve) {
            gymSuits[rest] += 1;
        }

        // 아몰랑 그냥 코딩 박치기 할랭
        // 0이면 자기 아래랑 위 보고 빌리기
        for(int i = 1; i <= n; i++) {
            // 없어? 도난 당했어?
            if(gymSuits[i] == 0) {
                if(gymSuits[i-1] == 2) { // 아래한테 빌려!
                    gymSuits[i-1]--;
                    gymSuits[i]++;
                    continue;
                }
                else if(i < n && gymSuits[i+1] == 2) { // 범위 안인 위한테 빌려!
                    gymSuits[i+1]--;
                    gymSuits[i]++;
                    continue;
                }
            }

        }

        // 자 다 빌렸지? 체육 수업 드가자~
        for(int i = 1; i <= n; i++) {
            if(gymSuits[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}