class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        for(int i = 0; i<attacks.length-1; i++){
            health-=attacks[i][1];
            if(health<=0) return -1;
            
            health += ((attacks[i+1][0]-attacks[i][0]-1)/bandage[0])*bandage[2]
                        +(attacks[i+1][0]-attacks[i][0]-1)*bandage[1];
            health = Math.min(health, maxHealth);
        }
        
        health = health-attacks[attacks.length-1][1];
        if (health <= 0) return -1;
        return health;
    }
}
