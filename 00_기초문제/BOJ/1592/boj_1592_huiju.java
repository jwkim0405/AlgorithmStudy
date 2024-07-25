import java.util.Scanner;

public class boj_1592_huiju {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		System.out.println((n / getGCD(n, l)) * (m-1));	// n/최대공약수 * (m-1)
		
		
	}

	public static int getGCD(int n, int l) {	//최대공약수 구하기
        if (n % l == 0) {
            return l;
        }
        return getGCD(l, n%l);
    }
}
