import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11053_huiju_timeout {
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {

//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;	//dp는 1로 초기화(나자신만 존재하는(자릿수가 하나인) 부분수열의 길이는 1이기 때문!)
		}
		//		System.out.println(Arrays.toString(arr));
		//------------------------------

		for(int i=0; i<n; i++) {
			lis(i);	//모든 부분수열 탐색하기
		}
		
		max = 0;
		
		for(int i=0; i<n; i++) {	//최댓값 찾기
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

	static int lis(int i) {

		for(int j= i-1; j>=0; j--) {
			if(arr[j] < arr[i]) 
				dp[i] = Math.max(dp[i], lis(j) + 1);
		}

		return dp[i];
	}

}

