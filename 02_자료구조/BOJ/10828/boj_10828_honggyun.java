import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		
		int N = sc.nextInt();
		// Stack		
		// Order 1 <= N <= 1만 명령의 수
		// Number 1 <= X <= 10만
		// intArr로 구현 -> 길이가 최대 10,000이므로 메모리 할당은 최대 4만byte = 0.04MB
		
		// 빈 스택 생성
		int[] stack = new int[N]; 
		// int형은 0으로 자동 초기화 되므로, X는 1이상의 정수이므로
		// stack[0] == 0이면 정수가 없다고 생각 가능!
		
		
		// << method >>
		int cnt = 0;		
		
		for(int i = 0; i < N; i++) {		
		// push X -> X를 스택에 넣기
			// 한 개의 명령
			String order = sc.next();
			
			if(order.equals("push")) {
				// push만 X를 가지므로
				int X = sc.nextInt();
				
				stack[cnt++] = X;	
				
			} else if(order.equals("pop")) {				
				// pop -> 가장 위에 있는 정수를 빼고 그 수를 출력. 정수가 아예 없으면 -1 출력
				if(stack[0] == 0) {
					sb.append(-1 + "");
					sb.append("\n");			
					
				} else {					
					int resNum = stack[cnt - 1];					
					stack[cnt - 1] = 0;
					cnt--;
					sb.append(resNum + "");
					sb.append("\n");					

				}			
				
			} else if(order.equals("size")) {
				// size -> 스택에 들어있는 정수 개수 출력
				// 정수 없으면 0
				if(stack[0] == 0) {
					sb.append(0 + "");
					sb.append("\n");					

					
				} else {
					sb.append(cnt + "");
					sb.append("\n");					

				}
				
			} else if(order.equals("empty")) {
				// empty -> 비어있으면 1 아니면 0
				if(stack[0] == 0) {
					sb.append(1 + "");
					sb.append("\n");					

					
				} else {
					sb.append(0 + "");
					sb.append("\n");					

				}
				
			} else if(order.equals("top")) {
				// top -> 스택의 가장 위에 있는 정수 출력. 정수가 아예 없으면 -1
				if(stack[0] == 0) {
					sb.append(-1 + "");
					sb.append("\n");					

					
				} else {	
					int resNum = stack[cnt - 1];
					sb.append(resNum + "");
					sb.append("\n");

				}
				
			}
			
			
		}
		
		System.out.println(sb);
	}

}
