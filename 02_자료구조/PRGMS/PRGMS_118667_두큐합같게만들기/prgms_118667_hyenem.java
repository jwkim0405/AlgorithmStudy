import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        long sum = 0;
        long sum1 = 0;
        int[] queue = new int[2*N];
        for(int i = 0; i<N; i++){
            queue[i]=queue1[i];
            queue[N+i]=queue2[i];
            sum+=queue1[i]+queue2[i];
            sum1+=queue1[i];
        }
        if(sum%2==1) return -1;

        long avg = sum/2;
        int left = 0;
        int right = N;
        long acc = sum1;
        while(left<=right&& right<2*N){
            if(acc==avg){
                return left+right-N;
            } else if(acc<avg){
                acc+=queue[right++];
            } else {
                acc-=queue[left++];
            }
        }
        return -1;
    }
}