import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] brokenButton = new int[M];
		
		for (int i = 0; i < M; i++) {
			brokenButton[i]=sc.nextInt();
		}
		
		int[] nonBrokenButton = new int[10-M];
		int point = 0;
		here : for (int i = 0; i<10; i++) {
			for (int j = 0; j<M; j++) {
				if (brokenButton[j]==i) {
					continue here;
				}
			}
			nonBrokenButton[point++]=i;
		}
		
		int nLength = 1;
		if (N!=0) {
			nLength = (int)(Math.log10(N)+1);
		} 
		
		int min = Math.abs(N-100);
		
		int searchingNum = 1;
		int multipleNum = 1;
		for (int i = 1; i<nLength; i++) {
			searchingNum *= (10-M);
			multipleNum *= 10;
		}

		for (int i = 0; i < searchingNum*(10-M)-1; i++) {
			int nowNum = 0;
			int nowDivideNum = searchingNum;
			int nowmultipleNum = multipleNum;
			int divideNum = i;
			for (int j = 0; j<nLength; j++) {
				nowNum += nonBrokenButton[divideNum/nowDivideNum]*nowmultipleNum;
				divideNum -= (divideNum/nowDivideNum)*nowDivideNum;
				nowDivideNum/=(10-M);
				nowmultipleNum/=10;
			}
		
			int nowMin = Math.abs(nowNum-N) + 1;
			if (nowNum!=0) {
				nowMin = Math.abs(nowNum-N) + (int)(Math.log10(nowNum)) + 1;
			}

			if (min>nowMin) {
				min = nowMin;
			}
		}
		
		System.out.print(min);
	}
}
