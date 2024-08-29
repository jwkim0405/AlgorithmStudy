
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(); // 방 row 길이
		int C = sc.nextInt(); // 방 column 길이
		int T = sc.nextInt(); // T초
		
		// 공기 청정기 2행의 위치
		int upper = -1;
		int lower = -1;
		
		int[][] room = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				room[r][c] = sc.nextInt(); // 미세먼지 측정!
				
				if(room[r][c] == -1) {
					if(upper == -1) upper = r;
					else lower = r;
				}
			}
		}
		
		// 미세먼지 델타
		// 상 우 하 좌
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		// 공기 청정기 델타
		// 우 상 좌 하
		int[] pr = { 0, -1, 0, 1 };
		int[] pc = { 1, 0, -1, 0 };
		
		// T초 동안 진행
		for(int t = 1; t <= T; t++) {
			// 1. 미세먼지 확산
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(room[r][c] == -1) continue; // 공기청정기 제외
					
					int spread = room[r][c] / 5; // 확산되는 양
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 범위 안에서 공기청정기가 아니면
						if(nr >= 0 && nr < R
						&& nc >= 0 && nc < C
						&& room[nr][nc] != -1) {
							// 확산
							room[nr][nc] += spread; 
							room[r][c] -= spread;
						}
							
					}
										
				}
			}
			
			// 2. 공기 청정기 작동
			// 위쪽
			int p = 0; // purifier
			boolean flag = false;
			int ur = upper;
			int uc = 0;
			while((ur != upper || uc != 0) || !flag) {
//				System.out.println("upperValue => " + room[upper][0]);
				flag = true;
				// 델타 범위가 배열 범위 안이면
				if(ur + pr[p] >= 0 && ur + pr[p] <= R-1
				&& uc + pc[p] >= 0 && uc + pc[p] <= C-1) {
					int nr = ur + pr[p];
					int nc = uc + pc[p];

					// 미세먼지 이동 (한 칸씩 미나 결국엔 전부 배열 범위 끝에 다 모임)
					room[nr][nc] += room[ur][uc];
					room[ur][uc] = 0;
					ur = nr;
					uc = nc;

				} else p++;


			}
			
			p = 0; // 델타 인덱스 초기화
			flag = false;
			int lr = lower;
			int lc = 0;
			while((lr != lower || lc != 0) || !flag) {
				flag = true;
				
				// 델타 범위가 배열 범위 안이면
				if(lr + pr[(4-p)%4] >= 0 && lr + pr[(4-p)%4] <= R-1
				&& lc + pc[(4-p)%4] >= 0 && lc + pc[(4-p)%4] <= C-1) {
					// 반시계 방향
					int nr = lr + pr[(4-p)%4];
					int nc = lc + pc[(4-p)%4];
					
					// 미세먼지 이동 (한 칸씩 미나 결국엔 전부 배열 범위 끝에 다 모임)
					room[nr][nc] += room[lr][lc];
					room[lr][lc] = 0;
					lr = nr;
					lc = nc;
				} else p++;
			}
			
			// 둘 다의 반복이 끝나면 (upper, 0)와 (lower, 0)에 미세먼지가 모여있음
			// 청소!
			System.out.println(Arrays.deepToString(room));
			room[upper][0] = 0;
			room[lower][0] = 0;
		}

		// 집 안에 남은 미세먼지 총량 구하기
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += room[i][j];
			}
		}
		
		System.out.println(sum);
	}
}
