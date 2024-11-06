// test-case: 28/30
// 남은 2개 어디서 문제일까
// 아...도난당한 사람인데 여벌 옷이 있는 것 먼저 확인!
// + 앗...정렬....

import java.util.*;

class Solution {
    boolean[] hasCloth;
    boolean[] selfcheck;
    public int solution(int n, int[] lost, int[] reserve) {
        hasCloth = new boolean[n+1]; // visited 배열(true이면 여벌 옷 있음, false면 옷 X)
        selfcheck = new boolean[n+1]; // 자기 자신 여벌 있는지 확인 -> 자기 자신에게 줬으면 true
        int lostCnt = 0; // 최종적으로 옷이 없는 학생의 수
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 옷 있는지 visited로 저장
        for (int r: reserve) {
            hasCloth[r] = true;
        }
        
        // 1. 자기 자신 먼저 확인
        // 자기 자신 도난당하고, 여벌이 있다면 본인 것을 가짐
        for (int l: lost) {
            if (hasCloth[l]) {
                hasCloth[l] = false;
                selfcheck[l] = true;
            }
        }
                
        NEXT: 
        for (int num: lost) {
            // 자기 자신 확인 안 한 것들
            if (!selfcheck[num]) {
                // 왼쪽 확인
                if (num -1 >= 1 && hasCloth[num-1]) {
                    hasCloth[num-1] = false;
                    continue NEXT;
                }
                // 오른쪽 확인
                if (num + 1 <= n && hasCloth[num+1]) {
                    hasCloth[num+1] = false;
                    continue NEXT;
                }
            }
            // 자기 자신 확인했는데, true(자기가 자신한테 줌)
            else if (selfcheck[num]) continue NEXT;
            
            // * 자기 자신, 왼쪽, 오른쪽 학생한테도 없다. => 체육복 입기 불가능
            lostCnt++;
        } // for num
        
        return n-lostCnt;
    }
}
