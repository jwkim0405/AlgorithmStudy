	import java.util.Arrays;
	import java.util.Scanner;
	
	public class boj_1107_hyenem {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] brokenButton = new int[M];
			for (int i = 0; i<M; i++) {
				brokenButton[i] = sc.nextInt();
			}
			
			int[] nonBrokenButton = new int[10-M];
			end: for (int i=0, idx = 0; i<10; i++) {
				for (int j = 0; j < M; j++) {
					if (brokenButton[j]==i) continue end;
				}
				nonBrokenButton[idx++]=i;
			}
			
			int nLength = Integer.toString(N).length();
			int min = Math.abs(N-100);
					
			for (int i = nLength-1; i < nLength+2 ;i++) {
				for (int j = 0; j<(int)Math.pow(10-M, i); j++) {
					int nowNum = 0;
					String str = Integer.toString(j, 10-M);
					while(str.length()!=i) {
						str = "0"+str;
					}
					for (int k = 0; k<i; k++) {
						nowNum += nonBrokenButton[str.charAt(k)-'0']*(int)Math.pow(10, i-k-1);
					}
					int nowMin = min;
					if(nowNum!=0) {
						nowMin = Math.abs(N-nowNum)+Integer.toString(nowNum).length();
					}
					if (nowMin<min) min=nowMin;
				}
			}
			System.out.println(min);
		}
	}
