import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data: 코드번호, 제조일, 최대수량, 현재수량
        // ext: 어떤 정보 기준으로 뽑을지(code, date, maximum, remain)
        // val_ext: 기준값
        // sort_by: 정렬 기준
        
        // ext가 val_ext보다 작은 값들을 sort_by의 기준에 따라 정렬
        String[] std = {"code", "date", "maximum", "remain"};
        int ext_num = 0;
        int sort_num = 0;
        
        for (int i = 0; i < std.length; i++) {
            if (std[i].equals(ext)) ext_num = i;
            if (std[i].equals(sort_by)) sort_num = i;
        }
        // System.out.println(ext_num + " " + sort_num);
        final int sort_final = sort_num;
        
        // 조건을 만족하는 개수 세기
        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][ext_num] < val_ext) cnt++;
        }
        // System.out.println(cnt);
        
        // 새로운 배열 생성
        int idx = 0;
        int[][] answer = new int[cnt][4];
        for (int i = 0; i < data.length; i++) {
            if (data[i][ext_num] < val_ext) {
                for (int j = 0; j < 4; j++) {
                    answer[idx][j] = data[i][j];
                }
                idx++;
            }
        }
        
        Arrays.sort(answer, (int[] o1, int[] o2)->o1[sort_final]-o2[sort_final]);
//         Arrays.sort(answer, new Comparator<> {
            
//             return o1[sort_num]-o2[sort_num];
//         });
        
        return answer;
    }
}
