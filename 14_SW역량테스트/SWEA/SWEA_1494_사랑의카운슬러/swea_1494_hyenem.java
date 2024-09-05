import java.util.Scanner;

public class Solution {
	
	static int N;
	static long ans;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			ans = Long.MAX_VALUE;
			N = sc.nextInt();
			arr = new int[N][2];
			for(int i = 0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new int[] {x, y};
			}
			
			combination(0, 0, 0);

			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static void combination(int start, int visited, int count) {
		if(count==N/2) {
			long tmpX = 0;
			long tmpY = 0;
			for(int i = 0; i<N; i++) {
				if((visited&(1<<i))==0) {
					tmpX+=arr[i][0];
					tmpY+=arr[i][1];
				} else {
					tmpX-=arr[i][0];
					tmpY-=arr[i][1];
				}
			}
			ans = Math.min(tmpX*tmpX+tmpY*tmpY, ans);
			return;
		}
		for(int i = start; i<N; i++) {
			combination(i+1, visited|(1<<i), count+1);
		}
	}
}

