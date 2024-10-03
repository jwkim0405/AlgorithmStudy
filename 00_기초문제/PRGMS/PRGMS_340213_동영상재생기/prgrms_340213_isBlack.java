class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = timeToSeconds(video_len);
        int currentPosition = timeToSeconds(pos);
        int openingStart = timeToSeconds(op_start);
        int openingEnd = timeToSeconds(op_end);

        // 시작 위치에서 오프닝 건너뛰기 처리
        currentPosition = skipOpening(currentPosition, openingStart, openingEnd);

        for (String command : commands) {
            if (command.equals("prev")) {
                currentPosition = Math.max(0, currentPosition - 10);
            } else if (command.equals("next")) {
                currentPosition = Math.min(videoLength, currentPosition + 10);
            }

            // 이동 후 오프닝 건너뛰기 처리
            currentPosition = skipOpening(currentPosition, openingStart, openingEnd);
        }

        return secondsToTime(currentPosition);
    }

    // "mm:ss" 형식의 시간을 초 단위로 변환하는 메서드
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    // 초 단위를 "mm:ss" 형식의 문자열로 변환하는 메서드
    private String secondsToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    // 현재 위치가 오프닝 구간에 있으면 오프닝 끝 위치로 이동하는 메서드
    private int skipOpening(int currentPosition, int openingStart, int openingEnd) {
        if (currentPosition >= openingStart && currentPosition <= openingEnd) {
            return openingEnd;
        }
        return currentPosition;
    }
}