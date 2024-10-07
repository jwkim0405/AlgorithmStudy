class Solution {
    static int monsters;
    static int maxHealth;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 몬스터 공격 attacks: 시간 기준 오름차순
        monsters = attacks.length; // 몬스터 개수
        maxHealth = health; // 최대 체력
        int endTime = attacks[monsters-1][0];
        int monstersIdx = 0;
        int bandageCnt = 0;
        
        // 1초부터 마지막 공격이 끝날 떄까지
        for (int i = 1; i <= endTime; i++) {
            // 만약 공격이 시작되는 time!
            if (i == attacks[monstersIdx][0]) {
                health -= attacks[monstersIdx][1]; // 체력 깎고
                // 체력이 0 이하이면 -1 반환
                if (health <= 0) {
                    return -1;
                }
                monstersIdx++; // 다음 공격 인덱스
                bandageCnt = 0; // 회복 누적합
            } 
            // 공격이 없다(회복 시간)
            else {
                bandageCnt++; // 회복 시간 누적합
                // 추가 체력
                if (bandageCnt == bandage[0]) {
                    health += bandage[2];
                    bandageCnt = 0;
                }
                health += bandage[1];
                health = Math.min(maxHealth, health);
            } // else
        } // 마지막 공격 끝
        return health;
    } // main
} // class
