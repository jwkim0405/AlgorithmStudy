import java.util.Scanner;
public class boj_2563_yuyoung {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 흰색 도화지 100X100 배열
		int[][] paper = new int[100][100];
		int N = sc.nextInt(); // 검은 색종이 수
		
		int[][] position = new int[N][2]; // 색종이 위치
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				position[i][j] = sc.nextInt();
			}
		} // 색종이 위치 입력
		
		for (int i = 0; i < N; i++) {
			int dr = position[i][0];
			int dc = position[i][1];
			
			for(int r = dr; r < dr + 10; r++) {
				for (int c = dc; c < dc + 10; c++) {
					if (r < 100 & c < 100) { // 범위 이내
						if (paper[r][c] == 0) {
							paper[r][c] = 1;
						} // 비어있을 경우에만 1로 채움
					}
				}
			}
			
		}
		
		int area = 0; // 색종이 넓이
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) { // 채워진 넓이
					area++;
				}
			}
		}
		
		System.out.println(area);
		
	}
}
