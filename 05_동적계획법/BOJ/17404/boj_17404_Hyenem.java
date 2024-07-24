package swea17404;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		int[][] DP = new int [N][3];
		for (int i =0; i<N; i++) {
			for (int j = 0; j<3; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		DP[0][0]=arr[0][0];
		DP[0][1]=arr[0][0];
		DP[0][2]=arr[0][0];
		
		for (int i =1; i<N; i++) {
			DP[i][0]=Math.min(DP[i-1][1], DP[i-1][2])+arr[i][0];
			DP[i][1]=Math.min(DP[i-1][0], DP[i-1][2])+arr[i][1];
			DP[i][2]=Math.min(DP[i-1][0], DP[i-1][1])+arr[i][2];
			if(i==1) DP[i][0]=Integer.MAX_VALUE;
		}
		if(min>Math.min(DP[N-1][1], DP[N-1][2])) min=Math.min(DP[N-1][1], DP[N-1][2]);
		
		DP[0][0]=arr[0][1];
		DP[0][1]=arr[0][1];
		DP[0][2]=arr[0][1];
		
		for (int i =1; i<N; i++) {
			DP[i][0]=Math.min(DP[i-1][1], DP[i-1][2])+arr[i][0];
			DP[i][1]=Math.min(DP[i-1][0], DP[i-1][2])+arr[i][1];
			DP[i][2]=Math.min(DP[i-1][0], DP[i-1][1])+arr[i][2];
			if(i==1) DP[i][1]=Integer.MAX_VALUE;

		}
		
		if(min>Math.min(DP[N-1][0], DP[N-1][2])) min=Math.min(DP[N-1][0], DP[N-1][2]);
		
		DP[0][0]=arr[0][2];
		DP[0][1]=arr[0][2];
		DP[0][2]=arr[0][2];
		
		for (int i =1; i<N; i++) {
			DP[i][0]=Math.min(DP[i-1][1], DP[i-1][2])+arr[i][0];
			DP[i][1]=Math.min(DP[i-1][0], DP[i-1][2])+arr[i][1];
			DP[i][2]=Math.min(DP[i-1][0], DP[i-1][1])+arr[i][2];
			if(i==1) DP[i][2]=Integer.MAX_VALUE;

		}
		
		if(min>Math.min(DP[N-1][1], DP[N-1][0])) min=Math.min(DP[N-1][1], DP[N-1][0]);
		
		System.out.println(min);
	}

}

