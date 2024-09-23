class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true) {
            // 지갑 안에 들어가는 경우
            // 그대로 넣거나, 90도 돌려 넣는 경우
            if ((wallet[0] >= bill[0] && wallet[1] >= bill[1]) || (wallet[0] >= bill[1] && wallet[1] >= bill[0])) {
                 break;
            } else {
                if (bill[0] >= bill[1])
                    bill[0] /= 2;
                else 
                    bill[1] /= 2;
                answer++;
            }
        }
        return answer;
    }
}
