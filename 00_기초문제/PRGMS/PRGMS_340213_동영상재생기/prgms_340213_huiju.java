class prgms_340213_동영상재생기 {
	
	
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //1. pos가 오프닝 구간 사이에 있는지 확인 - 사이면 건너뜀 아니면 그대로
        //2. next와 prev대로 이동 - next와 prev의 개수 세기, 더 많은 쪽에서 적은 걸 빼서 (2-1.)그만큼만 움직이도록 하기
        //3. 다시 문자열로 만들기,,,
        
        Time lenT = new Time(Integer.parseInt(video_len.substring(0, 2)), 
                             Integer.parseInt(video_len.substring(3, 5)));
        Time posT = new Time(Integer.parseInt(pos.substring(0, 2)), 
                             Integer.parseInt(pos.substring(3, 5)));
        Time startT = new Time(Integer.parseInt(op_start.substring(0, 2)), 
                               Integer.parseInt(op_start.substring(3, 5)));
        Time endT = new Time(Integer.parseInt(op_end.substring(0, 2)), 
                             Integer.parseInt(op_end.substring(3, 5)));
        
        //pos가 오프닝 사이에 있으면 업데이트
        posT = escapeOp(posT, startT, endT);
         
        for(int i=0; i<commands.length; i++){
            
            move(posT, commands[i]);
            
        //주어진 동영상 길이에서 벗어날 경우
        if(posT.min > lenT.min || (posT.min == lenT.min && posT.sec > lenT.sec)){
                //동영상이 끝나는 시간을 대입한다
                posT.min = lenT.min;
                posT.sec = lenT.sec;
            }
        //(posT.sec는 음수일 때 무조건 60을 더해 양수로 만들기 때문에 posT.min만 비교한다)
        else if(posT.min < 0){
                //동영상이 시작하는 시간을 대입한다
                posT.min = 0;
                posT.sec = 0;
            }
        
        //이동 후의 위치가 오프닝 사이일 경우를 고려한다.
        posT = escapeOp(posT, startT, endT);
            
        }
        
        //문자열로 합쳐 반환한다.
        return toString(posT);
        
    }//solution
    
    
    
    //오프닝 건너뛰기
    static Time escapeOp(Time posT, Time startT, Time endT){
        int posS = posT.min * 60 + posT.sec;
        int startS = startT.min * 60 + startT.sec;
        int endS = endT.min * 60 + endT.sec;
        
        if(posS >= startS && posS < endS){
            
            posT.min = endT.min;
            posT.sec = endT.sec;
            
        }
        return posT;
    }//escapeOp
    
    //명령어에 따라 pos를 이동시킴
    static Time move(Time posT, String comm){
        
        if(comm.equals("next")){
            posT.sec += 10;
            
            if(posT.sec >= 60){
                posT.min += 1;
                posT.sec -= 60;
            }
        }
        
        else{
            posT.sec -= 10;
            
            if(posT.sec < 0){
                posT.min -= 1;
                posT.sec += 60;
            }
        }
        return new Time(posT.min, posT.sec);
    }
    
    //문자열로 변환
    static String toString(Time posT){
        String tmpMin = posT.min/10 != 0 ? "" + posT.min : "0" + posT.min;
        String tmpSec = posT.sec/10 != 0 ? "" + posT.sec : "0" + posT.sec;
        return tmpMin + ":" + tmpSec ;
    }//toString
    
}//Solution

class Time{
    
    int min;
    int sec;
    
    Time(int min, int sec){
        this.min = min;
        this.sec = sec;
    }
    
}
