public class prgms_340213_yuyoung {

    static int videoTime;
    static int posTime;
    static int opStartTime;
    static int opEndTime;

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        videoTime = toSeconds(video_len); // 전체 동영상 시간 (초 단위)
        posTime = toSeconds(pos); // 현재 재생위치 (초 단위)
        opStartTime = toSeconds(op_start); // 오프닝 시작 위치 (초 단위)
        opEndTime = toSeconds(op_end); // 오프닝 끝 위치 (초 단위)

        skipOp(); // 오프닝 스킵

        for (String command : commands) {
            if (command.equals("prev")) {
                moveToPrev(); // 10초 전으로 이동
            } else {
                moveToNext(); // 10초 후로 이동
            }
            skipOp(); // 오프닝 스킵
        }

        return toTimeFormat(posTime); // 초를 "mm:ss" 형식으로 변환하여 반환
    }

    // 10초 후로 이동하는 메소드
    private static void moveToNext() {
        posTime += 10;
        if (posTime > videoTime) { // 전체 동영상 시간을 넘어가는 경우
            posTime = videoTime;
        }
    }

    // 10초 전으로 이동하는 메소드
    private static void moveToPrev() {
        posTime = Math.max(0, posTime - 10); // 0초보다 작아지면 0초로 설정
    }

    // 오프닝 스킵하는 메소드
    private static void skipOp() {
        if (posTime >= opStartTime && posTime <= opEndTime) {
            posTime = opEndTime; // 오프닝 구간을 벗어나도록 끝나는 시각으로 이동
        }
    }

    // "mm:ss" 형식을 초 단위로 변환
    private static int toSeconds(String time) {
        String[] split = time.split(":");
        int minutes = Integer.parseInt(split[0]);
        int seconds = Integer.parseInt(split[1]);
        return minutes * 60 + seconds;
    }

    // 초를 "mm:ss" 형식으로 변환
    private static String toTimeFormat(int timeInSeconds) {
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

}
