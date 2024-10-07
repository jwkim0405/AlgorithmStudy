class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 초기 체력을 최대 체력으로 설정
      
        for (int i = 0; i < attacks.length; i++) {
            health -= attacks[i][1];    // 공격으로 체력 감소
            if (health <= 0) return -1; // 체력이 0 이하가 되면 종료

            // 회복: 마지막 공격이 아닌 경우에만 
            if (i < attacks.length - 1) {
                int healingPeriod = (attacks[i + 1][0] - attacks[i][0] - 1);
                int BonusHealCondition = bandage[0];
                // 공격 사이의 시간 동안 회복 계산
                health += healingPeriod * bandage[1] // 소량 회복: 매초마다 소량 회복
                       + (healingPeriod / BonusHealCondition) * bandage[2]; // 추가 회복량: 일정 시간마다 회복
                // 체력이 최대 체력을 넘지 않도록 제한
                health = Math.min(health, maxHealth);
            }
        }

        return health; // 마지막까지 남은 체력 반환
    }
}
