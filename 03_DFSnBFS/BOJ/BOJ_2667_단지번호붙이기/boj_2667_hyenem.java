
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static int N;
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i<N; i++) {
			String str = sc.next();
			for (int j = 0; j<N; j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}

		int ans = 0;
		int[] ansArr = new int[(int)Math.pow(N, 2)];
		int point =0;
		for (int i = 0; i<N; i++) {
			for (int j =0; j<N; j++) {
				if(arr[i][j]==1) {
					num = 0;
					DFS(i,j);
					ansArr[point++]=num;
					ans++;	
				}
			}
		}
		Arrays.sort(ansArr);
		System.out.println(ans);
		for (int i = (int)Math.pow(N, 2)-point; i<(int)Math.pow(N, 2); i++) {
			System.out.println(ansArr[i]);
		}
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1}; 
	
	static void DFS(int i, int j) {
		num++;
		arr[i][j]=0;
		for (int k =0; k<4; k++) {
			if(i+dy[k]<N && i+dy[k]>-1 && j+dx[k]<N && j+dx[k]>-1) {
				if(arr[i+dy[k]][j+dx[k]]==1) {
					DFS(i+dy[k],j+dx[k]);
				}	
			}
		}
	}

}

