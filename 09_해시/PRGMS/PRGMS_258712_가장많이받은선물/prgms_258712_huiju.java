import java.util.*;
class Solution {
	
	public static void main(String[] args) {
		String[] friends = {"muzi", "ryan", "frodo", "neo"};
		String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
		solution(friends, gifts);
	}
	    public int solution(String[] friends, String[] gifts) {
	        int friendsLen = friends.length;
	        //현재까지 주고받은 선물 개수를 저장할 배열
	       int[][] currGift = new int[friendsLen][friendsLen];
	        //앞으로 받을 선물 개수를 저장할 배열
	        int[] futGift = new int[friendsLen];
	        Map<String, Integer> map = new HashMap<>();
	        //이름, 번호 해시맵에 저장
	        for(int i=0; i<friendsLen; i++){
	            map.put(friends[i], i);    
	        }
	        
	        //gifts배열의 문자열을 하나씩 뽑아 currGifts를 채운다(예시의 주고받은 선물 표와 같음)
	        for(String names : gifts){
	            String[] tmp = names.split(" ");
	            currGift[map.get(tmp[0])][map.get(tmp[1])]++;
	        }
	        /*
	        1. 서로 선물을 주고받은 기록이 있고 a-b가 0이 아님
	             1. a-b 양수 → a++
	             2. 음수 → b++
	        2. 기록  없거나 a-b가 0임
	             1. 선물지수 계산(앞서 생성한 2차원배열 활용)
	                a선물지수-b선물지수 양수 → a++
	                음수 → b++
	                0 → 넘어감
	        
	        
	        */
	        
	        
	    }
	}


}