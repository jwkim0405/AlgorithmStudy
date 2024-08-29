//냅색
import java.util.Arrays;
import java.util.Scanner;

public class boj_12865_huiju {
	
	static int n;		//물품의 수
	static int k;		//버틸 수 있는 무게
	static int[][] arr;	//물건의 무게, 가치를 저장할 배열
	static int[][] dp;	//가치의 최댓값을 저장할 이차원 배열
	static int maxWeight;	//이전 최대 무게
	static int maxValue;	//이전 최대 가치
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n+1][2];	
		dp = new int[n+1][k+1];	//물건을 넣지 않은 경우를 위한 빈 공간 추가
		
		for(int i=1; i<n+1; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
//		System.out.println(Arrays.deepToString(arr));
		//------------------------------------------------------
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<k+1; j++) {
				
				/*조건
				 * 1. 이전 최대 무게와 현재 무게를 더했을 때 k보다 큰 경우(물건을 넣을 수 없는 경우)
				 * 		1-1. dp에 이전 최대 가치를 저장
				 * 2. 이전 최대 무게와 현재 무게를 더했을 때 k보다 작거나 같을 경우(물건을 넣을 수 있는 경우)
				 * 		2-1. 이전 최대 가치와 현재 가치를 더해 dp에 저장
				 *  */
				if(arr[i][0] > j) {	//물건을 넣을 수 없는 경우
					//dp에 해당 무게에서의 최대 가치를 대입한다.
					
					dp[i][j] = dp[i-1][j];	//바로 위의 값을 가져온다
//					System.out.println("if : dp[][] : " + dp[i][j]);
					
				}else {	//물건을 넣을 수 있는 경우
					//해당 무게에서의 최대 가치와 해당 무게에서의 최대 가치 + 현재 무게와 매칭되어 있는 가치 중 더 큰 값을 선택한다
					
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);	//이거 모르겠음
					
//					System.out.println("else : dp[][] : " + dp[i][j]);
					
				} 
			
			}
		}
		
		for(int[] num : dp) {
			for(int num2 : num) {
				System.out.print(num2 + " ");
			}
			System.out.println();
		}
		
		System.out.println(dp[n][k]);
		
		
		
	}
}
