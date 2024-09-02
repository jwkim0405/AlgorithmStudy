import java.util.Scanner;

public class Solution {
	
	static int sum;
	static int min;
	static int[] cost;
	static int[] anual;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			
			cost = new int[4];
			for(int i =0; i<4; i++) {
				cost[i]=sc.nextInt();
			}
			
			// 일년권을 구매하는 경우 모든 상황을 커버할 수 있음.
			min = cost[3];
			anual = new int[13];
			
			for(int i = 1; i<=12; i++) {
				anual[i]=sc.nextInt();
			}
			
			sum = 0;
			dfs(1);
			
			System.out.println("#"+test_case+" "+min);
		}
	}
	
	static void dfs(int start) {
		if(start>12) {
			min = Math.min(min, sum);
		} else if(start<=10) {
			sum+=cost[0]*anual[start];
			dfs(start+1);
			sum-=cost[0]*anual[start];
			sum+=cost[1];
			dfs(start+1);
			sum-=cost[1];
			sum+=cost[2];
			dfs(start+3);
			sum-=cost[2];
		} else {
			sum+=cost[0]*anual[start];
			dfs(start+1);
			sum-=cost[0]*anual[start];
			sum+=cost[1];
			dfs(start+1);
			sum-=cost[1];
		}
	}
}

