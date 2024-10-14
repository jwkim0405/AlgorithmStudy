import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        List<int[]> ansList = new ArrayList<>();
        
        // idx for ext 
        int extIdx = switch(ext) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
        
        // idx for sort
        int sortIdx = switch(sort_by) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
        
        
        // find and add data item that fits the standard
        int cnt = 0;
        for(int[] d : data) {
            if(d[extIdx] < val_ext) {                
                ansList.add(d);
            }
        }
        
        // convert ArrayList to Array
        answer = new int[ansList.size()][4];
        for(int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        Arrays.sort(answer, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        return answer;
    }
}