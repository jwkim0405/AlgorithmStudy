import java.util.Scanner;

public class boj_2292_huiju {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(hexagon(n));
	}
	
	static int a=1;	//초기값 : 1(벌집 중심)
	static int iToStatic = 0;
	
	static int hexagon(int n) {	
		if(n==1) return 1;
		for(int i=1;;i++) {	//무한 반복
			a += 6*i;
//			System.out.println(a);
			if(n <= a) {
				iToStatic = i+1;	//초기값 1 타일만큼을 더해줌
				break;
			}
		}
		return iToStatic;
		
	}
	
}
