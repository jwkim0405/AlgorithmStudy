import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class prgms_42583_huiju {

	public static void main(String[] args) {

		int[] arr = {7,4,5,6};
		
		System.out.println(solution(2, 10, arr));	
		
	}
public static int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int timeCnt = 0;  	//최소 시간을 업데이트할 변수
        int cnt = 0;   		//다리를 건너고 있는 트럭의 무게를 전부 합한 값을 저장할 변수
        int idx = 0;       	//대기트럭의 인덱스
        int outCnt = 0;		//다리에서 빠져나온 트럭의 수를 누적할 변수
        
        Queue<Integer> bridge = new LinkedList<>();			//다리 위에 있는 트럭을 저장할 큐
        List<Integer> list = new ArrayList<>();				//다리 위에 트럭이 얼마나 오래 있었는지 저장할 리스트
        
        //outCnt가 기존 대기트럭.length가 될 때까지 반복한다.
        while(!(outCnt == truck_weights.length)){
            
            /*1. bridge에 트럭을 추가
             * 	- idx < 대기트럭.length일 때 
             * 	- (weight - cnt) > 대기트럭[idx]일 때
             * 	
             *2. bridge에서 트럭을 빼는 동시에 outCnt++ (다리를 지나는 데에 걸리는 시간 = bridge_length초,,?)
             *	-> 트럭이 다리 위에 있었던 시간이 다리의 길이가 될 때
             * 
             * 3. 다리 위에 있는 트럭들이 다리 위에서 보낸 시간을 1씩 더해줌*/
        		
        	//while문을 반복할 때마다 시간을 누적한다
        	timeCnt++;	
//        	System.out.println(bridge);
        	
        	//1. bridge에 트럭 추가
            if(idx < truck_weights.length && (weight - cnt) >= truck_weights[idx]){
            	
            	cnt += truck_weights[idx];				//cnt에 트럭의 무게를 누적한다
            	list.add(1);							//해당 트럭이 다리에 들어간 시간을 추가
                bridge.offer(truck_weights[idx++]);		//다리에 트럭을 올린다(?)
                
                
            }
            
            //2. bridge에서 트럭을 빼내기
            for(int i=0; i<list.size(); i++) {
            	
            	if(list.get(i) == bridge_length) {		//해당 인덱스의 트럭이 다리에 있었던 시간이 다리 길이와 같아질 경우
            		
                	int tmp = bridge.poll();				//bridge에 들어있는 첫 트럭을 꺼낸다
                	cnt -= tmp;								//cnt에서 꺼낸 트력의 무게를 뺀다
                	outCnt++;								//다리에서 벗어난 트럭의 개수를 누적한다

            	}
            }
            
            //3. //트럭이 다리에 있던 시간 1씩 올려주기
            for(int i=0; i<list.size(); i++)
            	list.set(i, list.get(i)+1);
            
        }
        
        return timeCnt+1;	//마지막 요소가 빠지는 시간도 더해줌
    }
}
