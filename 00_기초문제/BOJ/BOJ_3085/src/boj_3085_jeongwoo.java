import java.util.Scanner;
import java.lang.Math;

public class boj_3085_jeongwoo {
	// 가로 탐색
	public static int h_search() {
		
	}
	
	// 세로 탐색
	public static int v_search() {
		
	}
	
	// 4가지 색 중 가장 큰 값 반환
	public static int max_color() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 보드의 크기 n 입력
		int n = sc.nextInt();
		
		// 보드판 배열 생성
		String[] board = new String[n];
		
		// 색깔별 max 크기 관리 배열
		int[] color = new int[4];
		
		// 보드판 배열 값 입력(공백X)
		// 1차원 배열로 받아서 각 String 내의 값은 CharAt()으로 확인!
		for (int i = 0; i < n; i++)
			board[i] = sc.next();
		
		
		
		
		for (int i = 0; i < n; i++) 
			System.out.println(board[i].charAt(0));
		
	}
}
