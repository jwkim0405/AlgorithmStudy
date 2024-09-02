import java.util.*;

public class Solution {
	// 여는 괄호와 닫는 괄호를 각각 key, value로 저장할 map
	static Map<Character, Character> map = new HashMap<>();
	
	static {
		map.put('(', ')');
		map.put('<', '>');
		map.put('{', '}');
		map.put('[', ']');
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt(); // testCase 길이
			String str = sc.next(); // testCase 문자열 입력
			
			int result = isValid(str, T); // 유효성 검사
			System.out.println("#" + t + " " + result); // 결과 출력
		}
	}
	
	// 스택 구현 클래스
	public static class Stack {
		List<Character> stack = new ArrayList<>();
		int top = -1;
		
		void push(char c) {
			top++;
			stack.add(c);
		}
		
		char pop() {
			char popItem = peek();
			stack.remove(top--);
			return popItem;
		}
		
		char peek() {
			return stack.get(top);
		}
		
		boolean isEmpty() {
			return top == -1;
		}
		
	}
	
	// 유효성 검사 메서드
	static int isValid(String str, int T) {
		Stack stack = new Stack();
		
		for (int i = 0; i < T; i++) {
			char c = str.charAt(i);
			if (map.containsKey(c))
				stack.push(c);
			else {
				char popItem = stack.pop();
				if (map.get(popItem) != c)
					return 0;
			}
		}
		if (stack.isEmpty())
			return 1;
		else 
			return 0;
	}
}
