//10828. 스택

import java.util.ArrayList;
import java.util.Scanner;

public class boj_10828_huiju {

	public static void main(String[] args) {
		
		boj_10828_huiju method = new boj_10828_huiju();
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> stackList = new ArrayList<>(1);	//리스트를 사용해 들어오는 리터럴 수만큼 배열사이즈를 조정한다? 이게 되나?
		int inputNum = sc.nextInt();
		
		for(int i=0; i<inputNum; i++) {
			String order = sc.next();
			if(order.contains("push")) { 
				stackList.add(sc.nextInt());
			}
			else if(order.contains("pop")) method.pop(stackList);
			else if(order.contains("size")) System.out.println(stackList.size()); 
			else if(order.contains("empty")) method.empty(stackList);
			else if(order.contains("top")) method.top(stackList);
		}
		
	}
	
	void pop(ArrayList<Integer> arrayList) {	//arrayList 가장 위에 있는 숫자를 출력 후 제거(들어있는 정수가 없을 경우 -1 출력)
		if(arrayList.size()==0) {
			System.out.println(-1);
			return;
		}
		System.out.println(arrayList.get(arrayList.size()-1));
		arrayList.remove(arrayList.size()-1);
	}
	
	void empty(ArrayList<Integer> arrayList) {	//arrayList가 비어있으면 1, 아니면 0을 출력
		System.out.println(arrayList.size()==0? 1 : 0 );
	}
	
	void top(ArrayList<Integer> arrayList) {
		if(arrayList.size()==0) {
			System.out.println(-1);
			return;
		}
		System.out.println(arrayList.get(arrayList.size()-1));
	}
}
