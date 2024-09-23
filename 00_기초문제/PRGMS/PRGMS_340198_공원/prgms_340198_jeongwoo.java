import java.util.*;

class Solution {
    
    // 기본 함수
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        // 큰 돗자리부터 판별
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            if(isEmpty(park, size))
                return size;
        }
        // 깔 수 있는 돗자리가 없는 경우
        return -1;
    }
    public boolean isEmpty(String[][] park, int size) {
        int r = park.length;
        int c = park[0].length;
        
        // (i,j)에서 시작하여 size x size 크기 탐색
        for (int i = 0; i < r - size + 1; i++) {
            NEXT: for (int j = 0; j < c -size + 1; j++) {
                
                // -1이 아닌 값이 나오면 false
                for (int p = 0; p < size; p++) {
                    for (int q = 0; q < size; q++) {
                        int dr = i + p;
                        int dc = j + q;
                        if (!park[dr][dc].equals("-1"))
                            continue NEXT;
                    }
                }
                return true; // size x size 돌았을 때 다 -1이었다!
            }
        }
        return false; // i, j문 다 돌았는데도 불가능
    }
}
