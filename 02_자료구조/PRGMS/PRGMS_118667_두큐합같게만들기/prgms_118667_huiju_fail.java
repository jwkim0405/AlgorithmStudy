import java.util.*;

public class 두큐합같게만들기 {

}

class Solution {

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int cnt1 = 0;
        int cnt2 = 0;
        int result = 0;
        int len = queue1.length;

        for(int i=0; i<len; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            cnt1+=queue1[i];
            cnt2+=queue2[i];
            }

        for(int i=0; i<len*len; i++){
            if(cnt1 == cnt2) break;
            
            else if(cnt1 > cnt2){
                int tmp = q1.poll();
                cnt2 += tmp;
                cnt1 -= tmp;
                q2.offer(tmp);
            } else{
                int tmp = q2.poll();
                cnt1 += tmp;
                cnt2 -= tmp;
                q1.offer(tmp);
            }
            result++;
        }

        if(result < len*len) return result;
        return -1;

        

    }

}