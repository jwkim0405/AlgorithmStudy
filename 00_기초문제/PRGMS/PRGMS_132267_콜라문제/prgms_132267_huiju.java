
public class prgms_132267_콜라 {

}
class Solution {
    public int solution(int a, int b, int n) {
        //기저조건 : 바꿀 수 있는 콜라의 수가 0일 때
        if(n < a)
            return 0;
        
        //새로 받을 수 있는 콜라의 수
        int newBottle = n / a * b;  
        //남은 빈 병의 수
        int remain = n % a;
        return newBottle + solution(a, b, newBottle + remain);
    }
}