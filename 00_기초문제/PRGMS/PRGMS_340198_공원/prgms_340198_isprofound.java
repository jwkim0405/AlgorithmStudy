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

---

import java.util.Arrays;

public class Solution {
    public int solution(int[] mats, String[][] park) {
        int rowLen = park.length;
        int colLen = park[0].length;
        int[][] grid = new int[rowLen][colLen];  // 공원의 상태를 숫자로 변환 (빈 공간: 1, 사람 있는 곳: 0)
        
        // 공원 배열을 숫자로 변환
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                grid[i][j] = park[i][j].equals("-1") ? 1 : 0;
            }
        }

        int maxSquare = 0;  // 가능한 최대 정사각형 크기
        
        // 각 위치에서 가능한 최대 정사각형 크기를 저장할 DP 테이블
        int[][] dp = new int[rowLen][colLen];

        // 첫 행과 첫 열은 그 자체로만 정사각형을 만들 수 있음
        for (int i = 0; i < rowLen; i++) dp[i][0] = grid[i][0];  // 첫 열 초기화
        for (int j = 0; j < colLen; j++) dp[0][j] = grid[0][j];  // 첫 행 초기화

        // DP를 이용하여 각 점에서 만들 수 있는 정사각형 크기를 계산
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (grid[i][j] == 1) {  // 빈 공간일 때만 계산
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;  // 정사각형 확장
                    maxSquare = Math.max(maxSquare, dp[i][j]);  // 최대 크기 업데이트
                }
            }
        }

        // 돗자리 배열에서 가능한 최대 크기를 찾음
        Arrays.sort(mats);  // 돗자리를 오름차순으로 정렬
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= maxSquare) return mats[i];  // 가능한 최대 크기의 돗자리 반환
        }

        return -1;  // 아무 돗자리도 깔 수 없으면 -1 반환
    }
}








