import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 나머지 문제
		
		/*
		 * T = 10개로 고정
		 * 한 줄에 하나씩, 1000이하의 0을 포함하는 정수
		 * 
		 * << 알고리즘 생각 >>
		 * 서로 다른 나머지의 개수 구하기
		 * 1. 나머지들을 반복문으로 10번 돌려서 도출
		 * 2. 집합에 그 값들을 넣어 중복 제거
		 * 3. 집합의 크기(size())로 정답 도출
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 값을 넣을 집합 생성
		HashSet<Integer> rests = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int inputNum = sc.nextInt();
			int rest = inputNum % 42;
			
			// 집합에 값 넣어주기
			rests.add(rest);			
		}
		
		int result = rests.size();
		
		System.out.println(result);		
	}
}
