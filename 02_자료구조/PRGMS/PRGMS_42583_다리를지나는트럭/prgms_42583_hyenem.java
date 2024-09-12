class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int[] time = new int[(bridge_length*truck_weights.length)+1];
        int idx = 0;
        for(int i = 0; i<truck_weights.length; i++){
            while(time[idx]+truck_weights[i]>weight){
                idx++;
            }
            for(int j = 0; j<bridge_length; j++){
                time[idx+j]+=truck_weights[i];
            }
            idx++;
        }
        
        while(time[idx]>0) idx++;
        
        answer = idx+1;
        
        return answer;
    }
}
