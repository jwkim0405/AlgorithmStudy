import java.util.PriorityQueue;

public class prgms_250121_데이터분석 {

}

class Solution {
    static int sortNum;	
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
    	
    	String[] keywords = {"code", "date", "maximum", "remain"};
    	
        //ext값이 val_ext보다 작은 데이터의 인덱스를 저장할 임시 배열
        int[] tmp1 = new int[data.length];
        //tmp1의 인덱스
        int idx = 0;
        int extNum = 0;
        
        //sortNum, extNum : code, date, maximum, remain을 String 배열로 저장했을 때 
        //sort_by, ext에 할당된 문자열의 인덱스를 저장하는 변수
        for(int i=0; i<keywords.length; i++) {
        	if(ext.equals(keywords[i]))
        		extNum = i;
        	if(sort_by.equals(keywords[i]))
        		sortNum = i;
        }
        
        //for문을 돌면서 data[i][extNum]값이 val_ext값보다 작은 데이터의 인덱스만 tmp1에 저장한다
        for(int i=0; i<data.length; i++){
            if(val_ext - data[i][extNum] > 0)
                tmp1[idx++] = i;
        }
        
        //tmp1에 저장된 인덱스의 개수만큼 공간을 가지는 이차원 배열
        int[][] tmp2 = new int[idx][];
        
        //sort_by를 기준으로 오름차순 정렬한다
        PriorityQueue<MyCompare> queue = new PriorityQueue<>();
        for(int i=0; i<idx; i++){
            queue.offer(new MyCompare(data[tmp1[i]]));
        }
        
        //큐에서 정렬된 배열을 꺼내 tmp2에 저장한다
        for(int i=0; i<idx; i++){
            tmp2[i] = queue.poll().arr;
        }
        
        //반환!
        return tmp2;
    }
    
}

class MyCompare implements Comparable<MyCompare>{
    int[] arr;
    
    public MyCompare(int[] arr){
        this.arr = arr;
    }
    
    @Override
    public int compareTo(MyCompare mc){
        return this.arr[Solution.sortNum] - mc.arr[Solution.sortNum];
        
    }
    
}