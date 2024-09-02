import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		// 색종이 (B1) 문제
		/*
		색종이가 1번부터 순서대로 들어오고 반드시 뒤에 온 종이가 먼저 온 종이 위에 놓인다?
		--> 들어오는 숫자 k일때, 해당하는 범위를 k로 채우면 됨!!!!!
		다 채우고 나서 완전 탐색해서 1의 개수, 2의 개수, ... N의 개수 차례로 출력하면 된다!

		1. 색종이 장 수 N을 받는다.
		2. N만큼 반복한다.
		3. 각 숫자를 받는다.
		4. 2중 for문으로 사각형을 채운다(y는 반전으로)
		5. 다 채우고 나서 2중 for문으로 전체 배열을 탐색하면서 1의 개수부터 차례로 저장한다.
		6. 답을 하나씩 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int[][] wallpaper = new int[1001][1001]; // 평면
		
		int N = sc.nextInt(); // 색종이 개수		
		// 개수만큼 반복
		for(int t = 1; t <= N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int a = x; a < x + width; a++) {
				for(int b = y + height - 1; b >= y; b--) {
					wallpaper[a][b] = t; // 색종이 범위에 그 색종이가 몇 번째인지 기록
				}
			}			
			
		}
		
		int[] cntArr = new int[N+1]; // 카운팅 배열
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				if(wallpaper[i][j] != 0) cntArr[wallpaper[i][j]]++;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(cntArr[i] != 0) System.out.println(cntArr[i]);
				else System.out.println(0); 
		}
		
	}

}
