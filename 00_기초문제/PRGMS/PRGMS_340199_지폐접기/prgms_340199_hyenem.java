class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int answer = 0;
        
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);
        while(billMax>walletMax || billMin>walletMin){
            billMax = billMax>>1;
            answer++;
            if(billMax<billMin){
                int tmp = billMax;
                billMax = billMin;
                billMin = tmp;
            }
        }
        
        return answer;
    }
}
