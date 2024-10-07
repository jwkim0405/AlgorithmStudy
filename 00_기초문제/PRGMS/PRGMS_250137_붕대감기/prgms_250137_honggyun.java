class Solution {
    // bandage: [시전 시간, 초당 회복량, 추가 회복량] 
    // health: 최대체력
    // attacks: [공격 시간, 피해량] 
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int hp = health;

        // 공격 횟수만큼 반복
        for(int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];


            // 데미지를 받으면 그만큼 데미지를 받음
            hp -= damage;
            if(hp <= 0) return -1;


            // 첫 공격 이후 다음 공격시간 까지의 차가 attackInterval일 때,
            int attackInterval = 0;
            if(i < attacks.length - 1) {
                attackInterval = attacks[i+1][0] - attacks[i][0] - 1;
                // health += (attackInterval * x) + ((attackInterval / t) * y) - 1
                int heal = (attackInterval * bandage[1]) + (attackInterval / (bandage[0]) * bandage[2]);
                hp += heal;
                if(hp > health) hp = health;
            }

        }

        answer = hp;
        return answer;
    }
}