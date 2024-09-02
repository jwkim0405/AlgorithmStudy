package boj_11404_플로이드;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		
		for(int i = 0; i<N+1; i++) {
			for(int j = 0; j<N+1; j++) {
				if(i!=j) arr[i][j]=Integer.MAX_VALUE;
			}
		}
		
		// 한번만에 가는 경우
		for(int i = 0; i<K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y]=Math.min(arr[x][y], sc.nextInt());
		}

		
		//전체를 다 들른다고 쳤을 때 총 N-2번까지 들를 수 있음
		//j에서 i를 거쳐서 k로 가는 경로를 볼것임.
		for(int repeat=0; repeat<N-1; repeat++) {
				for(int j = 1; j<N+1; j++) {
					for(int k = 1; k<N+1; k++) {
						for(int i = 1; i<N+1; i++) {
						if(arr[j][i]+arr[i][k]<0) continue;
						arr[j][k]=Math.min(arr[j][k],arr[j][i]+arr[i][k]);
					}
				}
			}		
		}
		
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				if(arr[i][j]==Integer.MAX_VALUE) arr[i][j]=0;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}		
	}
}
