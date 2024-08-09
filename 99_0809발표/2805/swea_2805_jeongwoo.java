import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트케이스 개수
	
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 농장의 크기
			String[] farm = new String[N]; // 농작물 가치
			for (int i = 0; i < N; i++)
				farm[i] = sc.next(); // 농작물의 가치
			
			int mid = N / 2; // 행, 열의 정가운데 인덱스
			int sum = 0;
			
			for (int i = 0; i < mid; i++) { // 각 행(정가운데 직전까지)
				for (int j = mid - i; j <= mid + i; j++) // 조건에 맞는 각 열(mid-i ~ mid+i)
				{ 
					sum += farm[i].charAt(j) - '0';
					sum += farm[N-1-i].charAt(j) - '0';
				}
			}
			for (int i = 0; i < N; i++)
				sum += farm[mid].charAt(i) - '0';
			
			System.out.println("#" + t + " " + sum);
		}
	}
}

