import java.util.Scanner;

public class boj_1107_hyenem {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] brokenButton = new int[M];
		for (int i = 0; i<M; i++) {
			brokenButton[i]=sc.nextInt();
		}
		
		int min = Math.abs(N-100);
		int nowMin = min;
		end: for (int i = N; i<=1000000; i++) {
			String str = Integer.toString(i);
			for (int j = 0; j<str.length(); j++) {
				for (int k =0; k<M; k++) {
					if(str.charAt(j)-'0'==brokenButton[k]) continue end;
				}
			}
			nowMin = i - N + Integer.toString(i).length();
			if (min>nowMin) min = nowMin;
			break;
		}

		end: for (int i = N; i>=0; i--) {
			String str = Integer.toString(i);
			for (int j = 0; j<str.length(); j++) {
				for (int k =0; k<M; k++) {
					if(str.charAt(j)-'0'==brokenButton[k]) continue end;
				}
			}
			nowMin = N-i+ Integer.toString(i).length();
			if (min>nowMin) min = nowMin;
		}
		
		System.out.println(min);
	}
}

