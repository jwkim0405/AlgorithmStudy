import java.util.Scanner;

public class boj_9251_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] str1 = sc.next().split("");
		String[] str2 = sc.next().split("");
		int str1Len = str1.length;
		int str2Len = str2.length;
		
		int[][] dp = new int[str1.length+1][str2.length+1];	//패딩 생성
		
		for(int i=1; i<=str1Len; i++) {		//문자 하나씩 뽑기
			for(int j=1; j<=str2Len; j++) {
				
				if(str1[i-1].equals(str2[j-1])) 	//동일할 경우
					dp[i][j] = dp[i-1][j-1] + 1;	//dp배열 대각선 위쪽 값에 1 더한 값을 대입
				else								//상이할 경우
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);	//dp배열 위 요소와 왼쪽 요소 중 더 큰 값을 가져옴
				
			}
		}
		
		System.out.println(dp[str1Len][str2Len]);
		
	}

}
