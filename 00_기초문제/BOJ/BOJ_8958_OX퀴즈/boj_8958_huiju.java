import java.util.Scanner;

public class boj_8958_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i=0; i<n; i++) {	//테케 갯수만큼 반복
			String str = sc.next();
			int sum = 0;	// 결과를 누적할 변수
			int oCnt = 0;	// 연속된 o의 갯수를 누적할 변수
			for(int j=0; j<str.length(); j++) {

				if(str.indexOf('X',j)== -1) {	//x를 찾을 수 없는 경우
//					System.out.println("x를 찾을 수 없음");

					oCnt = str.length() - j;
					sum+=((oCnt+1) *(oCnt/2));
					if(oCnt%2==1) {sum+=(oCnt+1)/2;}
					break;	//필수여요,,
				}
				if(str.charAt(j) == 'O') {	//j인덱스가 o일 때
					oCnt++; 
					//					System.out.println("cnt = "+oCnt);
				}else if(str.charAt(j)== 'X') {	//j인덱스가 x일 경우
					if(oCnt==1) {sum+=1;}	//cnt가 1일 땐 1 더하기
					else {	//등비수열의 합 구하기
						sum+=((oCnt+1) *(oCnt/2));
						if(oCnt%2==1) {sum+=(oCnt+1)/2;}

					}
					oCnt = 0;

				}
			}
			System.out.println(sum);

		}

	}
}
