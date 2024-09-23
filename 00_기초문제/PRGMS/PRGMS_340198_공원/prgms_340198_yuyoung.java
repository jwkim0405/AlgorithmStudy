import java.util.*;

class Solution {
    // 주어진 위치에서 크기 matSize의 매트를 놓을 수 있는지 확인
    private boolean canPlaceMat(String[][] park, int matSize, int startX, int startY) {
        for (int x = startX; x < startX + matSize; x++) {
            for (int y = startY; y < startY + matSize; y++) {
                if (!park[x][y].equals("-1")) {
                    return false;  // 한 곳이라도 -1이 아니면 매트를 놓을 수 없음
                }
            }
        }
        return true;  // 모든 위치가 -1이면 매트를 놓을 수 있음
    }

    // 주어진 크기의 매트를 놓을 수 있는지 확인
    private boolean placeMat(String[][] park, int matSize) {
        int r = park.length;
        int c = park[0].length;

        for (int i = 0; i <= r - matSize; i++) {
            for (int j = 0; j <= c - matSize; j++) {
                if (canPlaceMat(park, matSize, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int solution(int[] mats, String[][] park) {
        // 매트 크기 내림차순 정렬
        Arrays.sort(mats);

        int maxSize = -1;  // 놓을 수 있는 최대 매트 크기

        // 가장 큰 매트부터 놓을 수 있는지 확인
        for (int m = mats.length - 1; m >= 0; m--) {
            if (placeMat(park, mats[m])) {
                maxSize = mats[m];  // 놓을 수 있으면 해당 크기를 maxSize로 업데이트
                break;  // 첫 번째로 큰 매트를 찾으면 종료
            }
        }

        return maxSize;
    }
}
