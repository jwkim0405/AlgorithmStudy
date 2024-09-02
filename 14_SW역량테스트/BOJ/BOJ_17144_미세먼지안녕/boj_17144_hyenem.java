import java.util.Scanner;

public class Main {
	
	static int R;
	static int C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int T = sc.nextInt();
		arr = new int[R][C];
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		//매초마다
		for(int repeat = 0; repeat<T; repeat++) {
			int[][] tmparr = new int[R][C];
			//확산하기
			for(int i = 0; i < R; i++) {
				for(int j = 0; j<C; j++) {
					if(arr[i][j]!=0) {
						int count = 0;
						for(int k = 0; k<4; k++) {
							if(inRange(i+dx[k], j+dy[k])) {
								count++;
								tmparr[i+dx[k]][j+dy[k]]+=arr[i][j]/5;
							}
						}
						arr[i][j]-=(arr[i][j]/5)*count;
					}
				}
			}
			
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					arr[i][j]+=tmparr[i][j];
				}
			}

			
			// 위쪽 공기청정기 위치 찾으면서 왼쪽 모서리 이동
			int airclean = 1;
			while(arr[airclean][0]!=-1) {
				airclean++;
			}
			
			for(int i = airclean-1; i>0 ; i--) {
				arr[i][0]=arr[i-1][0];
			}
			//아래 사이클 왼쪽 모서리도 이동
			for(int i = airclean+2; i<R-1; i++) {
				arr[i][0]=arr[i+1][0];
			}
			
			// 가장 위 아래 모서리 이동
			for(int i = 0; i<C-1; i++) {
				arr[0][i]=arr[0][i+1];
				arr[R-1][i]=arr[R-1][i+1];
			}
			
			// 오른쪽 모서리 이동
			for(int i = 0; i<airclean ; i++) {
				arr[i][C-1]=arr[i+1][C-1];
			}
			for(int i=R-1; i>airclean+1; i--) {
				arr[i][C-1]=arr[i-1][C-1];
			}
			
			//가운데 모이는 모서리 이동
			for(int i = C-1; i>1; i--) {
				arr[airclean][i]=arr[airclean][i-1];
				arr[airclean+1][i]=arr[airclean+1][i-1];
			}
			arr[airclean][1]=0;
			arr[airclean+1][1]=0;

		}

		
		int ans = 2;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				ans+=arr[i][j];
			}
		}
		System.out.println(Math.max(ans,0));
		;
	}
	
	static boolean inRange(int i, int j) {
		if(i>=0 && i<R && j>=0 && j<C && arr[i][j]!=-1) return true;
		else return false;
	}
}

