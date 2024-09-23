import java.util.Arrays;

public class Solution {
    public int solution(int[] mats, String[][] park) {
        int rowLen = park.length;      // 공원의 행 길이
        int colLen = park[0].length;   // 공원의 열 길이
        int maxSize = -1;              // 지민이가 깔 수 있는 가장 큰 돗자리의 크기 (초기값은 -1)

        // 큰 크기의 돗자리부터 확인하기 위해 내림차순으로 정렬
        Arrays.sort(mats); // 작은 값에서 큰 값으로 정렬되므로, 나중에 큰 값부터 확인하려면 뒤에서부터 처리
        for (int i = mats.length - 1; i >= 0; i--) { // 가장 큰 돗자리부터 시도
            int size = mats[i]; // 현재 확인하고 있는 돗자리의 크기

            // park 배열에서 size 크기의 돗자리를 깔 수 있는지 확인
            for (int row = 0; row <= rowLen - size; row++) {
                for (int col = 0; col <= colLen - size; col++) {
                    // 현재 위치 (row, col)에서 size 크기의 돗자리를 깔 수 있는지 확인
                    if (canPlaceMat(size, row, col, park)) {
                        // 돗자리를 깔 수 있다면 maxSize를 현재 크기로 설정하고 바로 반환
                        maxSize = size;
                        return maxSize; // 가장 큰 돗자리를 찾았으므로 더 이상 탐색하지 않고 반환
                    }
                }
            }
        }
        return maxSize; // 모든 돗자리를 확인했으나 깔 수 없다면 -1 반환
    }

    // 주어진 위치에서 size 크기의 돗자리를 깔 수 있는지 확인하는 메서드
    public boolean canPlaceMat(int size, int startRow, int startCol, String[][] park) {
        // size x size 크기의 영역을 확인하기 위해 이중 반복문 사용
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                // 만약 해당 위치에 사람이 있거나 빈 공간이 아니면 돗자리를 깔 수 없으므로 false 반환
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        // 모든 위치가 빈 공간이면 돗자리를 깔 수 있으므로 true 반환
        return true;
    }
}
