import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<data.length; i++){
            if(data[i][extIdx]<val_ext){
                list.add(i);
            }
        }
        
        int[][] ans = new int[list.size()][4];
        for(int i = 0; i<ans.length; i++){
            ans[i]=data[list.get(i)];
        }
        Arrays.sort(ans, (int[] o1, int[] o2)->o1[sortIdx]-o2[sortIdx]);
        
        return ans;
    }
}
