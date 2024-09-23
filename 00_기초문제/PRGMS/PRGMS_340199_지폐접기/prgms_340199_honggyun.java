class Solution {
    public int solution(int[] wallet, int[] bill) {    
        // 1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
        int answer = 0;
        
        int walletSmall = wallet[0] < wallet[1] ? wallet[0] : wallet[1];
        int walletLarge = wallet[0] < wallet[1] ? wallet[1] : wallet[0];
        int billSmall = bill[0] < bill[1] ? bill[0] : bill[1];
        int billLarge = bill[0] < bill[1] ? bill[1] : bill[0];
        
        // 2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
        while(billSmall > walletSmall || billLarge > walletLarge) {
            // bill의 큰 값을 2로 나누고 나머지를 버립니다.
            billLarge /= 2;            
            // 크기가 바뀌었다면 반영합니다.
            if(billLarge <= billSmall) {
                int tmp = billLarge;
                billLarge = billSmall;
                billSmall = tmp;
            }
            
            // 2-3. answer을 1 증가시킵니다.
            answer++;
        }
        
        return answer;
    }
}