
public class prgrms_340199_huiju {

	public static void main(String[] args) {
		
		int[] wallet = {30, 15};
		int[] bill = {26, 17};
		
		System.out.println(Solution_340199.solution(wallet, bill));
		
	}
}

class Solution_340199 {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1])
             || Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1])){
            
            answer++ ;
            
            if(bill[0] > bill[1])
                bill[0] /= 2;
            else
                bill[1] /=2;
        }
        
        return answer;
    }
}
