import java.util.Arrays;
import java.util.Scanner;

public class boj_1244_huiju_실패 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			
			char[] chArr = sc.next().toCharArray();	//배열
			int n = sc.nextInt();	//교환횟수
//			System.out.println(Arrays.toString(chArr));
			//---------------------
			
			for(int i=0; i<n; i++) {	//주어진 횟수만큼 반복
				int max = 0;	//가장 큰 값을 저장할 변수
				int idx = i+1;	//가장 큰 값을 찾을 반복문의 인덱스
				for(; idx<chArr.length; idx++) {
					max = Math.max(max, chArr[idx]);	//최댓값 업데이트
				}
				
				char tmp = chArr[i];
				System.out.println("tmp : "+tmp);
				chArr[i] = (char)max;
				chArr[chArr.length-i-1] = (char)tmp;
				
				System.out.println("chArr[idx-1] : "+chArr[idx-1]);
				System.out.println(Arrays.toString(chArr));
				
			}
			
			
			//출력
			System.out.print("#"+tc+" ");
			for(int i=0; i<chArr.length; i++) {
				System.out.print(""+chArr[i]);
			}
			System.out.println();
		}
		
	}

}
