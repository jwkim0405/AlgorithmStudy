import java.util.*;

// 람다표현식: 외부에 있는 변수에 접근할 때 final, effectively final인 경우에만 접근이 가능하다.
// list <-> array : https://mommoo.tistory.com/32

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data: 코드번호, 제조일, 최대수량, 현재수량
        // ext: 어떤 정보 기준으로 뽑을지(code, date, maximum, remain)
        // val_ext: 기준값
        // sort_by: 정렬 기준
        
        // ext가 val_ext보다 작은 값들을 sort_by의 기준에 따라 정렬
        String[] std = {"code", "date", "maximum", "remain"};
        List<String> colList = Arrays.asList(std); // String배열을 list로 변환
        int ext_num = colList.indexOf(ext);
        final int sort_num = colList.indexOf(sort_by);
 
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
