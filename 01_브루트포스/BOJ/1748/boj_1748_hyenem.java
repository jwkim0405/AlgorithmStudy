import java.util.Scanner;

public class boj_1748_hyenem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int multiple10 = 9; //n자리 수의 개
		int spot = 1;		//n
		int accum = 0;
		
		while (N-multiple10>=0) {
			N -= multiple10;
			accum += multiple10*spot;
			multiple10 *=10;
			spot ++;
			
		}

		System.out.println(accum+N*spot);
	}
}

