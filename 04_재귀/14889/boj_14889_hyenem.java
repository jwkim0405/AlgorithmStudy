import java.util.Arrays;
import java.util.Scanner;


public class Boj_14889_hyenem {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int ans = 100000000;
		
		int[] teamStart = new int[N/2];
		int[] teamLink = new int[N/2];
		end :for (int i = (int)(Math.pow(2, N)-Math.pow(2,N/2)); 
				i > Math.pow(2,N) - Math.pow(2, N-1) + Math.pow(2, N/2-1)-2
				;i--) {
			
			int startSize = 0;
			int linkSize = 0;
			
			String digit = Integer.toString(i,2);
			for (int j = 0; j<N; j++) {
				if (digit.charAt(j)=='0') {
					if (linkSize>=N/2) continue end;
					teamLink[linkSize++]=j;
				} else if (digit.charAt(j)=='1'){
					if (startSize>=N/2) continue end;
					teamStart[startSize++]=j;
				}
			}
			
			int startPower = 0;
			int linkPower = 0;
			
			for (int j = 0; j<N/2; j++) {
				for (int k = 0; k<N/2; k++) {
					startPower += arr[teamStart[j]][teamStart[k]];
					linkPower += arr[teamLink[j]][teamLink[k]];
				}
			}
			
			if (ans > Math.abs(startPower-linkPower))
				ans = Math.abs(startPower-linkPower);
		}
		
		System.out.println(ans);
		
	}
}

