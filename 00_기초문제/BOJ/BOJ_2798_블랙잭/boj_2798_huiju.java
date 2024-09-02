//import java.util.Arrays;
import java.util.Scanner;

public class boj_2798_huiju {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;
		int[] numArr = new int[n];
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(numArr));
		
		for(int i=0; i<numArr.length-2; i++) {	//마지막 두 개의 번호는 셀 필요 없음
			for(int j=i+1; j<numArr.length-1; j++) {
				for(int k=j+1; k<numArr.length; k++) {
					//2. 만약 더한 수가 M보다 크거나 M 이상이면 continue
					if(numArr[i]+numArr[j]+numArr[k] < max 
							|| numArr[i]+numArr[j]+numArr[k] > m) continue;
					
					max = numArr[i]+numArr[j]+numArr[k] ;
				}
			}
			
		}
		System.out.println(max);
		
		
	}

}
