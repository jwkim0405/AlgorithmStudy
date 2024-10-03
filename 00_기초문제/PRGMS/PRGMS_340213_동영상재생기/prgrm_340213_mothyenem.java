class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int dis ='0'*(671);
        int endSec = (video_len.charAt(0)*10+video_len.charAt(1))*60+(video_len.charAt(3)*10 + video_len.charAt(4))-dis;
        int posSec = (pos.charAt(0)*10+pos.charAt(1))*60+(pos.charAt(3)*10 + pos.charAt(4))-dis;
        int opStartSec = (op_start.charAt(0)*10+op_start.charAt(1))*60+(op_start.charAt(3)*10 + op_start.charAt(4))-dis;
        int opEndSec = (op_end.charAt(0)*10+op_end.charAt(1))*60+(op_end.charAt(3)*10 + op_end.charAt(4))-dis;
        
        for(int i = 0; i<commands.length; i++){
            if(commands[i].equals("next")) {
                posSec = Math.min(posSec+10, endSec);
            } else if (commands[i].equals("prev")){
                posSec = Math.max(0, posSec-10);
            } else {
                if(posSec>=opStartSec && posSec<=opEndSec){
                    posSec = opEndSec;
                }
            }
        }
        String ans = "";
        ans += posSec/600;
        posSec = posSec%600;
        
        ans += posSec/60;
        posSec = posSec%60;
        ans+=":";
        
        ans += posSec/10;
        ans += posSec%10;
        
        return ans;
    }
}
