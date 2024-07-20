import java.util.Scanner;

public class boj_14500_hyenem {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+4][M+4];
		for (int i = 2; i<N+2; i++) {
			for(int j = 2; j<M+2; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i = 1; i<N+3; i++) {
			arr[i][1]=-4000;
			arr[i][M+2]=-4000;
		}
		for(int i = 1; i<M+3; i++) {
			arr[1][i]=-4000;
			arr[N+2][i]=-4000;
		}
		
		int sum = 0;
		int max = 0;
		//가로 3개 연속 있는 경우
		for(int i=2; i<N+2; i++) {
			for (int j = 2; j<M-1; j++) {
				int sur = Math.max(Math.max(Math.max(arr[i][j-1], arr[i][j+3]),
											Math.max(arr[i-1][j], arr[i+1][j])),
									Math.max(Math.max(arr[i-1][j+1], arr[i+1][j+1]),
											Math.max(arr[i-1][j+2], arr[i+1][j+2])));
				sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+sur;
				if (sum>max) max = sum;
			}
		}
		
		//세로 3개 연속 있는 경우
		for(int i=2; i<N-1; i++) {
			for (int j = 2; j<M+2; j++) {
				int sur = Math.max(Math.max(Math.max(arr[i-1][j], arr[i+3][j]),
											Math.max(arr[i][j-1], arr[i][j+1])),
									Math.max(Math.max(arr[i+1][j-1], arr[i+1][j+1]),
											Math.max(arr[i+2][j-1], arr[i+2][j+1])));
				sum = arr[i][j]+arr[i+1][j]+arr[i+2][j]+sur;
				if (sum>max) max = sum;
			}
		}
		
		//연속 3개가 없는 경우
		for(int i=2; i<N+2; i++) {
			for (int j = 2; j<M; j++) {
				int sur = Math.max(Math.max(arr[i-1][j]+arr[i-1][j+1], arr[i-1][j]+arr[i+1][j+1]),
									Math.max(arr[i+1][j]+arr[i+1][j+1], arr[i+1][j]+ arr[i-1][j+1]));
				sum = arr[i][j]+arr[i][j+1]+sur;
				if (sum>max) max = sum;
			}
		}
		
		for(int j=2; j<M+2; j++) {
			for (int i = 2; i<N; i++) {
				int sur = Math.max(Math.max(arr[i][j-1]+arr[i+1][j-1], arr[i][j-1]+arr[i+1][j+1]),
									Math.max(arr[i][j+1]+arr[i+1][j+1], arr[i][j+1]+ arr[i+1][j-1]));
				sum = arr[i][j]+arr[i+1][j]+sur;
				if (sum>max) max = sum;
			}
		}
		System.out.print(max);
	}
}

