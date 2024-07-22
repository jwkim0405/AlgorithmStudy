import java.util.Arrays;
import java.util.Scanner;

public class Boj_14501_hyenem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] tList = new int[N];
		int[] pList = new int[N];
		
		for(int i =0; i<N; i++) {
			tList[i]=sc.nextInt();
			pList[i]=sc.nextInt();
		}
		
		int[] DP = new int[N+1];
		for (int i =0; i<N; i++) {
			for(int j=N; j>=tList[i]+i; j--) {
				DP[j]=Math.max(DP[i]+pList[i], DP[j]);
			}
		}
		System.out.println(DP[N]);
	}
}

