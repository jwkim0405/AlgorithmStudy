import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> processList = new ArrayList<>();
        
        int col;
        if (ext.equals("code")) {
            col = 0; // 코드 번호
        } else if (ext.equals("date")) {
            col = 1; // 제조일
        } else if (ext.equals("max")) {
            col = 2; // 최대 수량
        } else { // remain
            col = 3; // 현재 수량
        }
        
        // val_ext보다 작은 데이터만
        for (int[] item : data) {
            if (item[col] < val_ext) {
                processList.add(item);
            }
        }
        
        // 정렬 기준 결정
        int columnSort;
        if (sort_by.equals("code")) {
            columnSort = 0;
        } else if (sort_by.equals("date")) {
            columnSort = 1;
        } else if (sort_by.equals("max")) {
            columnSort = 2;
        } else { // remain
            columnSort = 3;
        }

        // 데이터를 배열로 변환
        int[][] dataArr = processList.toArray(new int[processList.size()][]);

        // 오름차순 정렬 -> 시간 제한
//        int n = dataArr.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (dataArr[j][columnSort] > dataArr[j + 1][columnSort]) {
//                    int[] temp = dataArr[j];
//                    dataArr[j] = dataArr[j + 1];
//                    dataArr[j + 1] = temp;
//                }
//            }
//        }
        
        
        // Arrays.sort()를 사용한 정렬
        Arrays.sort(dataArr, (a, b) -> Integer.compare(a[columnSort], b[columnSort]));
        
        return dataArr;
    }
}
