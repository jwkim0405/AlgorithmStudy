class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // video_len, pos, op_start, op_end => 초 단위 int형으로 변환
        int videoLen = convertToSec(video_len);
        int position = convertToSec(pos);
        int openingStart = convertToSec(op_start);
        int openingEnd = convertToSec(op_end);


        for(String command : commands) {
            // 오프닝 스킵 체크
            position = skipOpening(position, openingStart, openingEnd);

            // 명령 수행
            switch(command) {
                case "next":
                    position = Math.min(videoLen, position + 10);
                    break;
                case "prev":
                    position = Math.max(0, position - 10);
                    break;
            }
        }

        // 마지막 명령이 끝난 후 skip opening check
        position = skipOpening(position, openingStart, openingEnd);

        int mm = position / 60;
        int ss = position % 60;

        StringBuilder sb = new StringBuilder();
        if (mm < 10)
            sb.append("0");
        sb.append(mm).append(":");
        if(ss < 10)
            sb.append("0");
        sb.append(ss);

        return sb.toString();
    }

    // 메서드1: 오프닝 구간에 있는지 조사
    static int skipOpening(int position, int openingStart, int openingEnd) {
        // 오프닝 구간에 있는 경우 openingEnd로 이동함
        if (position >= openingStart && position <= openingEnd)
            return openingEnd;
        // 아닐 경우
        return position;
    }

    // 메서드2: 모두 초 단위 int형으로 변환
    static int convertToSec(String time) {
        int sec = 0;
        // 초 단위
        sec += Integer.parseInt(time.substring(3));
        // 분 단위
        sec += Integer.parseInt(time.substring(0, 2)) * 60;
        return sec;
    }
}