import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health; // 최대 체력
        int t = 0; // 붕대 감기 기술의 시전 시간
        int attackIndex = 0; // 현재 처리 중인 공격 인덱스
        
        for(int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            // 만약 현재 시간이 공격 시간과 같다면
            if (attackIndex < attacks.length && attacks[attackIndex][0] == i) {
                health -= attacks[attackIndex][1]; // 공격 피해량만큼 체력 감소
                t = 0; // 시전 시간 초기화
                attackIndex++;
                
                // 체력이 0 이하
                if (health <= 0) {
                    answer = -1;
                    break;
                }
            } else {
                // 공격을 받지 않은 경우 붕대 감기 기술 사용
                t++; // 시전 시간 증가
                health += bandage[1]; // 체력 회복
                
                // 붕대 감기 최대 시전 시간이 도달하면 추가 회복
                if (t == bandage[0]) {
                    health += bandage[2]; // 추가 회복량만큼 체력 회복
                    t = 0; // 시전 시간 초기화
                }
                
                // 체력이 최대 체력을 초과할 경우 최대 체력
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        
        // 캐릭터가 죽지 않았으면 현재 남은 체력을 반환
        if(answer != -1) {
            answer = health;
        }
        
        return answer;
    }
}
