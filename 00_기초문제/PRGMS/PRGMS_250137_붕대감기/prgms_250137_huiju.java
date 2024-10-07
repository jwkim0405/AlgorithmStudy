
public class prgms_250137_붕대감기 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        
        //현재 체력
        int stamina = health;
        //연속 성공 횟수
        int success = attacks[0][0] - 1 ;
        
        //attacks 길이-1만큼 반복
        for(int i=0; i<attacks.length-1; i++){
            //공격을 받음
            stamina -= attacks[i][1];
            
            //체력이 음수일 경우 -1 반환    
            if(stamina <= 0)
            return -1;
            
            //붕대를 연속으로 감을 수 있는 시간을 구함
            success = attacks[i+1][0] - attacks[i][0] - 1 ;
            
            //정해진 시간 동안 연속으로 붕대를 감아서 추가회복이 가능할 경우
            //추가회복량을 더해줌
                stamina += bandage[2] * (success / bandage[0]);
            
            //최대체력을 고려하지 않은 현재까지의 체력
            int healed = stamina + success * bandage[1];
            
            //최대를 고려한 체력 구하기
            stamina = (healed > health) ? health : healed ;
        }//for
        
        stamina -= attacks[attacks.length-1][1] ;
        //마지막 공격 직후 체력이 음수일 경우 -1 반환
        if(stamina <= 0)
            return -1;
        return stamina;
    }

}