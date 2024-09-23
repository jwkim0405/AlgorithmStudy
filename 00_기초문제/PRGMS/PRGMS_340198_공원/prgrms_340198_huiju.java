
public class prgrms_340198_huiju {

	public static void main(String[] args) {

		int[] mats = {5,3,2};
		String[][] parks = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
				{"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
				{"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, 
				{"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, 
				{"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, 
				{"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
		System.out.println(Solution_340198.solution(mats, parks));
		
	}

}

class Solution_340198 {
    public static int solution(int[] mats, String[][] park) {
        //펼 수 있는 돗자리의 최대 한 변 길이
        int max = -1;
        
        //돗자리 개수만큼 반복
        for(int i=0; i<mats.length; i++){
        	
            //돗자리크기+1만큼 반복 : 돗자리를 펼 수 있는 범위 설정
            for(int j=0; j < park.length - mats[i] + 1; j++){
                out : for(int k=0; k < park[j].length - mats[i] + 1; k++){
                	
                    //빈 곳을 찾은 경우
                    if(park[j][k].equals("-1")){
                        
                        //돗자리를 펼 수 있는지 확인
                        for(int a=j; a < j + mats[i]; a++){
                            for(int b=k; b < k + mats[i]; b++){
                            	
                                //돗자리를 펼 수 있는 영역이 아닌 경우 out으로 돌아감
                                if(!park[a][b].equals("-1")) {
                                    continue out;
                                }
                            }
                        }
                    //돗자리를 펼 수 있을 경우 max 업데이트
                    max = Math.max(max, mats[i]);
                    }//if
                }//out
            }
        }
        return max;
    }
}