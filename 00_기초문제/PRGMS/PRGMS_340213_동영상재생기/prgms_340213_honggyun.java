import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 자동으로 오프닝 건너뛰기가 적용됨
        pos = jumpOp(pos, op_start, op_end);

        // "ab:cd"의 형태의 String을 가공해서 대소비교 하는 법
        // 60초가 최대이므로 그것도 감안해야 됨
        for(int i = 0; i < commands.length; i++) {
            String command = commands[i];
            // if문으로 명령 처리
            if(command.equals("prev")) {
                pos = prevTen(pos);
            } else {
                pos = nextTen(pos, video_len);
            }

            // 돌아간 곳이 오프닝 구간이라면 오프닝 건너뛰기            
            pos = jumpOp(pos, op_start, op_end);
        }

        String answer = pos;
        return answer;
    } // solution


    // String to Int
    int parseStrToInt(String timeStr) {
        StringTokenizer st = new StringTokenizer(timeStr, ":");
        String mm = st.nextToken();
        String ss = st.nextToken();

        int minute = Integer.parseInt(mm) * 60;
        int second = Integer.parseInt(ss);
        int time = minute + second;

        return time;
    } // String to Int


    // Int to String
    String parseIntToStr(int time) {
        StringBuilder sb = new StringBuilder();
        int minute = time / 60;
        int second = time % 60;

        // minute이 한 자리 수라면
        if(0 <= minute && minute < 10) {
            sb.append("0");
            sb.append(minute);
        } else {
            sb.append(minute);
        } // mm

        sb.append(":");

        // second가 한 자리 수라면
        if(0 <= second && second < 10) {
            sb.append("0");
            sb.append(second);
        } else {
            sb.append(second);
        }

        String timeStr = sb.toString();
        return timeStr;
    } // Int to String


    // 10초 전 이동
    String prevTen(String pos) {
        int prevTime;
        int posInt = parseStrToInt(pos);

        // 10초 이하면 0으로
        if(posInt <= 10) prevTime = 0;
        else prevTime = posInt - 10;

        String prevTimeStr = parseIntToStr(prevTime);
        return prevTimeStr;
    }


    // 10초 후 이동
    String nextTen(String pos, String video_len) {
        int nextTime;
        int videoLength = parseStrToInt(video_len);
        int posInt = parseStrToInt(pos);

        // 비디오 길이를 넘으면 비디오 길이로
        if(posInt + 10 >= videoLength) {
            nextTime = videoLength;
        } else {
            nextTime = posInt + 10;
        }

        String nextTimeStr = parseIntToStr(nextTime);

        return nextTimeStr;
    }


    // 오프닝 건너뛰기
    String jumpOp(String pos, String op_start, String op_end) {
        int posInt = parseStrToInt(pos);
        int opStart = parseStrToInt(op_start);
        int opEnd = parseStrToInt(op_end);

        int jumpTime = posInt;
        if(opStart <= posInt && posInt <= opEnd) {
            jumpTime = opEnd;
        }

        String jumpOpTime = parseIntToStr(jumpTime);

        return jumpOpTime;
    }

}