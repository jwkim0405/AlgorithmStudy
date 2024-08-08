import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("./src/input.txt"));
		// 농작물 수확하기
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테케 개수
		// 테케 개수만큼 반복
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 농장 한 변의 크기
			int sum = 0; // 농작물 전체 수확량
			// 농장에 농작물 심기
			for(int r = 0; r < N; r++) { // rows
				String plantsPerRow = sc.next();
				for(int c = 0; c < N; c++) { // columns
					// 농작물 심자마자 수확해버리기
					if(r <= (N/2) 
							&& (N/2) - r <= c 
							&& c <= (N/2) + r) 
					{
						sum += (int) (plantsPerRow.charAt(c) - '0');
						continue;
						
					} else if(r > (N/2) 
							&& (N/2) - (N-1 - r) <= c 
							&& c <= (N/2) + (N-1 - r)) 
					{
						sum += (int) (plantsPerRow.charAt(c) - '0');
						continue;
					}	
					
					// 수확 못한 농작물들도 가치는 매겨보기
					int plant = (int) (plantsPerRow.charAt(c) - '0');
					
				}
			}
			
			System.out.printf("#%d %d\n", test_case, sum);
			
			
		}		
		
	}

}
