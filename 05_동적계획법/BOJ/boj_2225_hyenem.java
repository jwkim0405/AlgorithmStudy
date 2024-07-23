import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] DP = new long[N+1][K];
		
		for (int i =0; i<N+1; i++) {
			DP[i][0]=1;
		}
		
		for (int j = 1; j<K; j++) {
			for (int i = 0; i<N+1; i++) {
				for (int k = 0; k<i+1; k++) {
					DP[i][j]+=DP[k][j-1]%1000000000;
				}
			}
		}		
		System.out.println(DP[N][K-1]%1000000000);
	}
}