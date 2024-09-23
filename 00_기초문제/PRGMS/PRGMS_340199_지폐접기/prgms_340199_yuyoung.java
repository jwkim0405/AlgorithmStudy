import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        while(!checkSize(wallet, bill)){
        	// 지폐의 가로, 세로 중 더 큰 값을 절반으로 줄임
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer; // 절반으로 접은 횟수
    }
    
    // 지폐가 지갑에 들어갈 수 있는지 확인
    private static boolean checkSize(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Arrays.sort(bill);

        return bill[0] <= wallet[0] && bill[1] <= wallet[1];
    }
}