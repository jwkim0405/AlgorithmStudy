import java.util.Scanner;

public class boj_17144_yuyoung {
	
	static int R;
	static int C;
	static int T;
	static int[][] arr;
	static int[][] tmp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		arr = new int[R][C];
		
		int airTop = -1;
		int airBottom = -1;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == -1) {
					if(airTop == -1) {
						airTop = i;
					} else {
						airBottom = i;
					}
				}
			}
		}
		
		for(int time = 0; time < T; time++) {
			spread();
			operate(airTop, airBottom);
		}
		
		int totalDust = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] > 0) {
					totalDust += arr[i][j];
				}
			}
		}
		
		System.out.println(totalDust);
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void spread() {
		tmp = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] > 0) {
					int amount = arr[i][j] / 5;
					int cnt = 0;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr >= 0 && nc >= 0 && nr < R && nc < C && arr[nr][nc] != -1) {
							tmp[nr][nc] += amount;
							cnt++;
						}
					}
					tmp[i][j] += arr[i][j] - amount*cnt; 
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] != -1) {
					arr[i][j] = tmp[i][j];
				}
			}
		}
		
	}
	
	
	private static void operate(int airTop, int airBottom) {
		for(int i = airTop - 1; i > 0; i--) {
			arr[i][0] = arr[i - 1][0];
		}
		for(int j = 0; j < C - 1; j++) {
			arr[0][j] = arr[0][j + 1];
		}
		for(int i = 0; i < airTop; i++) {
			arr[i][C - 1] = arr[i + 1][C - 1];
		}
		for(int j = C - 1; j > 1; j--) {
			arr[airTop][j] = arr[airTop][j - 1];
		}
		arr[airTop][1] = 0;
		
		for(int i = airBottom + 1; i < R - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}
		for(int j = 0; j < C - 1; j++) {
			arr[R - 1][j] = arr[R - 1][j + 1];
		}
		for(int i = R - 1; i > airBottom; i--) {
			arr[i][C - 1] = arr[i - 1][C - 1];
		}
		for(int j = C - 1; j > 1; j--) {
			arr[airBottom][j] = arr[airBottom][j - 1];
		}
		arr[airBottom][1] = 0;
		
	}

	
	
}