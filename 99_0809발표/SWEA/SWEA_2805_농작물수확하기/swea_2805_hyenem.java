import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			for (int i = 0; i<=N/2; i++) {
				String str = sc.next();
				for(int j = N/2-i; j<=N/2+i;j++) {
					sum += str.charAt(j)-'0';
				}
			}
			for (int i = N/2-1; i>=0; i--) {
				String str = sc.next();
				for(int j =  N/2-i; j<=N/2+i;j++) {
					sum += str.charAt(j)-'0';
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
