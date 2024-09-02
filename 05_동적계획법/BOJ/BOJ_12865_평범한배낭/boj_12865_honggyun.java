import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		/*
		 * 평범한 배낭 문제	 
		 */
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물품 개수
		int K = sc.nextInt(); // 버틸 수 있는 무게(가방 최대 무게)
		
		int[][] luggage = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			luggage[i][0] = sc.nextInt(); // W
			luggage[i][1] = sc.nextInt(); // V
		}

		int[][] dp = new int[N+1][K+1]; // dp 테이블
		// dp[i][w] => 첫번째부터 i번째 물건까지 고려했을 때 w무게 이내의 최대 가치
		// 어차피 최댓값을 찾는 것이므로 결국 모든 경우를 고려할 필요가 없음!

		// 1. 초기값 채우기
		// dp[0][w] = 0 <- 어차피 초기화 돼있어서 채울 필요 없음

//		// 2. 테이블 채우기
//		for(int i = 1; i <= N; i++) {
//			for(int w = 0; w <= K; w++) { // 0~K에 대한 값들 다 채우기
//				// 2-1. i의 무게가 K보다 크면(단독으로 무게 제한 넘으면), dp[i][K] == dp[i-1][K]
//				if(luggage[i][0] > K) dp[i][w] = dp[i-1][K];
//				else { // 2-2. i의 무게가 K보다 작거나 같으면
//					if(w >= luggage[i][0]) {
//						// - i번째 물건을 선택하는 경우 -> dp[i][K] = value[i] + dp[i-1][K-weight[i]]
//						int pickI = luggage[i][1] + dp[i - 1][K - luggage[i][0]]; // i의 가치 + 이전까지의 경우에서 i를 선택할 수 있는 경우의 수 선택(K-w가 최댓값의 경우 갖고 있음)
//						int noPick = dp[i - 1][w]; // - i번째 물건을 선택하지 않는 경우 -> dp[i][K] = dp[i-1][K]
//
//						dp[i][w] = Math.max(pickI, noPick); // 이 중에서 더 큰 값을 택헤서 dp[i][K]에 대입
//					} else {
//						dp[i][w] = dp[i-1][w];
//					}
//				}
//			}
//		}

		for(int i = 1; i <= N; i++) {
			dp[i][0] = 0; // 선택하지 않는 경우 0
			for(int w = 1; w <= K; w++) {
				if(w >= luggage[i][0]) {
					int noPick = dp[i-1][w];
					int pick = luggage[i][1] + dp[i-1][w-luggage[i][0]];
					dp[i][w] = Math.max(noPick, pick);
				} else dp[i][w] = dp[i-1][w];
			}
		}

		int maximum = dp[N][K];
		// 반복이 끝나면 dp[N][K]에 원하는 최대 가치가 있음
		System.out.println(maximum);

//===========================================================================================================
		// 3. dp[N][K]가 우리가 원하는 답.
		//		int cnt = N-1;
//		int[] cache = new int[N]; // DP를 위한 배열
//		int max = 0; // 최대값을 저장할 변수
//		for(int i = 0; i < (int) Math.pow(2, N); i++) {
//			int sumW = 0;
//			int sumV = 0;
//
//			for(int j = 0; j < N; j++) {
//				if(sumW > K) { // 무게 초과하면 다음 경우의 수로
//					break;
//				}
//
//				sumW += cache[j] * luggage[j][0]; // 무게
//				sumV += cache[j] * luggage[j][1]; // 가치
//			}
//
//			if(sumW <= K && sumV > max) max = sumV; // 최댓값 저장
//
//			// 다음 경우의 수로
//			while(cnt >= 0) {
//				if(cache[cnt] == 1) {
//					cache[cnt] = 0;
//					cnt--;
//				}
//				else {
//					cache[cnt] = 1; // 처음 0 만나면 1로 바꾸고
//					cnt = N-1; // cnt 초기화
//					break;
//				}
//			}
//		}
	}
}
