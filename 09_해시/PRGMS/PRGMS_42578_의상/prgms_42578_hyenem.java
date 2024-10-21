import java.util.*;

class Solution {
	public int solution(String[][] clothes) {
			ArrayList<Integer> list = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();
				            
			for(int i = 0; i<clothes.length; i++){
			//아직 한번도 안들어온 카테고리면 map에 추가하고
			//list에 그 인덱스에 1 추가하기(그 인덱스 옷 하나 있다는 뜻)
				if(!map.containsKey(clothes[i][1])) {
					map.put(clothes[i][1], map.size());
					list.add(1);
				}
				// 이미 그 카테고리에 옷이 들어있으면
				// 그 인덱스의 옷에 하나를 추가함
				int idx = map.get(clothes[i][1]);
				list.set(idx, list.get(idx)+1);
			}
								                                                                                                                                   
			int ans = 1;
			//곱하기로 경우의 수 계산
			for(int i= 0; i<list.size(); i++){
				ans *= list.get(i);
			}
		return ans-1;
	}
}
