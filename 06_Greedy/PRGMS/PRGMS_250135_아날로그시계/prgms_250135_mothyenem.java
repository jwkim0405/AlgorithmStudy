class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startSec = h1*3600+m1*60+s1;
        int endSec = h2*3600+m2*60+s2;
        
        int cycle = (endSec-startSec)/60;
        int ans = cycle*2;
        
        double hourStartAngle = ((double)startSec/120)%360;
        double hourEndAngle = ((double)endSec/120)%360;
        if(hourEndAngle==0) hourEndAngle=360;
//        System.out.println(hourStartAngle);
//        System.out.println(hourEndAngle);
        
        double minuteStartAngle = ((double)startSec/10)%360;
        double minuteEndAngle = ((double)endSec/10)%360;
        if(minuteEndAngle==0) minuteEndAngle=360;
//        System.out.println(minuteStartAngle);
//        System.out.println(minuteEndAngle);
        
        double secondStartAngle = (startSec*6)%360;
        double secondEndAngle = (endSec*6)%360;
        if(secondEndAngle==0) secondEndAngle=360;
//        System.out.println(secondStartAngle);
//        System.out.println(secondEndAngle);
        
        if(secondStartAngle<=hourStartAngle && secondEndAngle >= hourEndAngle) ans++;
        if(secondStartAngle<=minuteStartAngle && secondEndAngle >= minuteEndAngle) ans++;
//        System.out.println(ans);
        ans-=(endSec*11)/(3600*12)-(startSec*11-1)/(3600*12);
//        System.out.println(endSec);
//        System.out.println((endSec*11)/(3600*12));
//        System.out.println(startSec+1);
//        System.out.println((startSec*11-1)/(3600*12));
        
        return ans;
    }
}
