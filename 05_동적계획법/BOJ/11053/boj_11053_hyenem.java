import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1; i<N+1; i++) {
			arr[i]=sc.nextInt();
		}
		
		ArrayList<Integer> sort = new ArrayList<>();
		sort.add(Integer.MIN_VALUE);
		for(int i = 1; i<N+1; i++) {
			if(!sort.contains(arr[i])) sort.add(arr[i]);
		}
		
		sort.sort(null);
		int M = sort.size();
		
		int[][] DP = new int[M][N+1];
		
		for(int i = 1; i<M; i++) {
			for(int j=1; j<N+1; j++) {
				if(arr[j]==sort.get(i)) DP[i][j]=DP[i-1][j-1]+1;
				else DP[i][j]=Math.max(DP[i-1][j],DP[i][j-1]);
			}
		}
		
		System.out.println(DP[M-1][N]);
	}
}
