class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int[] currWeightAt = new int[(bridge_length*truck_weights.length)+1];
        int time = 0;

        for(int i = 0; i<truck_weights.length; i++){
            while(currWeightAt[time]+truck_weights[i]>weight){
                time++;
            }
            for(int j = 0; j<bridge_length; j++){
                currWeightAt[time+j]+=truck_weights[i];
            }
            time++;
        }
        
        while(currWeightAt[time]>0) time++;
        
        answer = time+1;
        
        return answer;
    }
}
