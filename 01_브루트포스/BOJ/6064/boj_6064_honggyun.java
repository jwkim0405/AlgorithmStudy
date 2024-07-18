import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 T
		int T = sc.nextInt();		
		
		// 테스트 케이스만큼 반복
		for (int test_case = 1; test_case < T + 1; test_case++) {
			// <M,N>이 마지막의 해, <x,y>는 몇 번째 해?
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// M값들과 N의 값들을 저장할 1차원 배열 생성
			int[] MGrid = new int[M];
			int[] NGrid = new int[N];
			// "x,y"로 저장하기 위해서 string 배열 생성;
			
			
			// M, N의 최소 공배수 구하기
			//int minMultiple = minMultiple(M, N);
			
			int maxDivider = 0;
			
			// 최대 공약수
			for (int i = 1; i <= M && i <= N; i++) {
				if (M % i == 0 && N % i == 0) {
					maxDivider = i;
				}
			}
			
			// 최소 공배수는 두 수를 곱하고 최대공약수를 나누면 나옴
			int minMultiple = (M * N) / maxDivider;			
			
			
			// >>>>>>>>>>>>>>>>>> input이 수 만 단위라 배열로 풀면 터짐 ㅋㅋㅋㅋㅋㅋ
			String[] calendar = new String[minMultiple];
			//>>>>>>>>>>>>>>>>>>> if랑 조건 연산자로 푸는 게 맞는 거 같다..
			
			
			// 값 채우기
			for (int i = 0; i < M; i++) {
				MGrid[i] = i + 1;
			}
			
			for (int i = 0; i < N; i++) {
				NGrid[i] = i + 1;
			}
						  
			// 반복 돌면서 calendar의 각 순서에 맞게 M값 채우기
			for (int i = 0; i < calendar.length; i++) {
				// M > i -> calendar[i] = MGrid[i]
				if (M > i) {
					calendar[i] = MGrid[i] + ",";
				} else if (M <= i) { // i가 M보다 크거나 같으면 i를 1부터 다시					
					int idxM = (i % M);
					calendar[i] = MGrid[idxM] + ",";
				}
				
				// 반복 돌면서 calendar의 각 순서에 맞게 N값 채우기
				if (N > i) {
					calendar[i] += NGrid[i] + "";
				} else if (N <= i) {					
					int idxN = (i % N);
					calendar[i] += NGrid[idxN] + "";
				}			
								
			}						
			
			// calendar 배열에서 x,y가 들어있는 값 찾기
			String target = x + "," + y;
			// k(==result)가 없을 경우 default 값 -1
			int k = -1;
			
			for (int i = 0; i < calendar.length; i ++) {
				if (calendar[i].equals(target)) {
					// result 해는 index 보다 1 크므로 1을 추가로 더해줌
					k += (i + 1) + 1;
				}
			}
			
			System.out.println(k);			
						
		}
	}
	
	// 최소 공배수 구하는 함수
	static int minMultiple(int num1, int num2) {
		int x = num1;
		int y = num2;
		
		int maxDivider = 0;
		
		// 최대 공약수
		for (int i = 1; i <= x && i <= y; i++) {
			if (x % i == 0 && y % i == 0) {
				maxDivider = i;
			}
		}
		
		// 최소 공배수는 두 수를 곱하고 최대공약수를 나누면 나옴
		int minMultiple = (x * y) / maxDivider;
		
		return minMultiple;
	}

}
