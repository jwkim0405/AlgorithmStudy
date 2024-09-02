import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[2][6];
		for (int i = 0; i<N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt()-1;
			arr[gender][grade]++;
		}
		
		int ans=0;
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<6; j++) {
				if (arr[i][j]==0) continue;
				
				ans += (arr[i][j]-1)/K+1;
			}
		}
		
		System.out.println(ans);
	}
}

