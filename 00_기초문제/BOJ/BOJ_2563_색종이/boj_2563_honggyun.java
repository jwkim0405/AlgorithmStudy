import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("./src/input.txt"));
		
		// 색종이 문제
		/* 
		1. 도화지 저장할 2차원 배열 만들기
		2. 색종이 수 받고 그만큼 반복
		3. input으로 받는 두 수는 색종이의 왼쪽 하단 꼭짓점 좌표 
		-> y에 + 10 해주고 10x10 2중 for문 돌려서 숫자++ 채우기
		4. 반복 끝나면 0이 아닌 개수 다 더하기 
			- 길이 10이면 그 안에 배열은 11개 들어감
			- 길이 n에 대해 (n+1)^2에 대한 중복 없는 넓이와 숫자의 합이 같다
		 */
		Scanner sc = new Scanner(System.in);
		
		int[][] wallpaper = new int[101][101]; // 도화지 0~100
		
		int N = sc.nextInt(); // 색종이 개수
		for(int i = 0; i < N; i++) { // 색종이 붙이기
			int x = sc.nextInt(); // 색종이의 왼쪽 변 좌표
			int y = sc.nextInt(); // 색종이의 아랫 변 좌표
			
			// 색종이의 길이-1 == 색종이 길이 안에 있는 배열 개수
			for(int a = x; a <= x+9; a++) { // x~ x+10-1
				for(int b = y+9; b >= y; b--) { // 도화지를 y축을 기준으로 거꾸로 뒤집어서 센 것과 같음
					wallpaper[a][b]++;

				}
			}	
			
		}
		
		int cnt = 0;		
		for(int a = 0; a < 100; a++) {
			for(int b = 0; b < 100; b++) {
				if(wallpaper[a][b] != 0)  cnt++;
					else continue;				
			}
		}

		System.out.println(cnt);
	}

}
