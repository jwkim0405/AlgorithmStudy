package swea17404;

import java.util.Scanner;

public class Main {
	
	public static int N;
	public static int[][] arr;
	public static int[] color;
	public static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][3];
		color = new int[N];
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<3; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		combination(1,arr[0][0]);
		
		color[0]=1;
		combination(1,arr[0][1]);
		
		color[0]=2;
		combination(1,arr[0][2]);
		
		System.out.println(ans);
		
	}

	static void combination(int idx, int sum) {
		if(idx==N) {
			if(color[0]!=color[N-1]) {
				if(ans>sum) ans = sum;
			}
			return;
		}
		
		color[idx]=(color[idx-1]+1)%3;
		combination(idx+1, sum+arr[idx][color[idx]]);
		color[idx]=(color[idx-1]+2)%3;
		combination(idx+1, sum+arr[idx][color[idx]]);
	}
}

