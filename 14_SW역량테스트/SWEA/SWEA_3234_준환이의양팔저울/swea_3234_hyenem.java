import java.util.Scanner;

public class Solution {
	
	static int N, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1 ; test_case<=T; test_case++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i]=sc.nextInt();
			}
			
			ans = 0;
			for(int i=0; i<=N; i++) {
				combination(i, 0);
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static void combination(int start, int team) {
		if(start==N) {
			compute(0, 0, team, 0);
			return;
		}
		for(int i = start; i<N; i++) {
			combination(i+1, team|(1<<start));
		}
	}
	
	static void compute(int left, int right, int team, int visited) {
		if(visited==(1<<N)-1) {
			ans++;
			return;
		}
		for(int i = 0; i<N; i++) {
			if((visited&(1<<i))!=0) continue;
			if((team&(1<<i))==0) {
				compute(left+arr[i], right, team, visited|(1<<i));
			} else if (left>=right+arr[i]) {
				compute(left, right+arr[i], team, visited|(1<<i));
			}
		}
	}
}

