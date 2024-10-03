class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int ans = 100000;
        while(left<=right){
            long time = times[0];
            int mid = (left+right)/2;
            for(int i = 1; i<diffs.length; i++){
                time += times[i];
                if(diffs[i]>mid){
                    time+=(diffs[i]-mid)*(times[i-1]+times[i]);
                }
            }
            if (time>limit){
                left=mid+1;
            } else {
                right=mid-1;
                ans = mid;
            }
        }
       return ans;
    }
}
