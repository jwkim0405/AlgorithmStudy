import java.util.Scanner;

public class boj_8320_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(Math.sqrt(n)%1 ==0) 
			System.out.println(halfSquare(nSqrtInt)*2-1);
		else 
			System.out.println(halfSquare(nSqrtInt)*2);
	}
	
	static int cnt = 0;	//직사각형 갯수 카운트
	static int n;
	static int nSqrtInt = (int)Math.sqrt(n);	//한 변의 최대 길이(정수)
	
	public static int halfSquare(int nSqtInt) {
		System.out.println(n);
		
		for(int i=1; i<=nSqrtInt; i++) {	//가로(혹은 세로)의 길이가 1일 때부터 시작
			//n이 i로 나눠떨어지는 경우(i가 n의 인수일 경우) cnt++, 아닐 경우 continue
			if(n%i ==0) cnt++;	
		}
		if(nSqtInt ==1) return 1;	//재귀를 돌면서 한 변의 최대 길이가 1이 될 경우 1을 반환(일반 케이스)
		n--;	//n=n-1 -> 다음 반복에서의 정사각형 갯수
		return cnt+halfSquare(nSqtInt);	//cnt에 누적(재귀 케이스)
	}

}
