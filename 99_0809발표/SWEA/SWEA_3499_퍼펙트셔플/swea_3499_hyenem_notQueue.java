
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			String[] arr = new String[N];
			for (int i = 0; i<N; i++) {
				arr[i]= sc.next();
			}
			
			String[] newArr = new String[N];
			for (int i = 0; i<(N+1)/2; i++) {
				newArr[2*i]=arr[i];
			}
			for (int i = 0; i<N/2; i++) {
				if(N%2==0) newArr[N-1-2*i]=arr[N-1-i];
				else newArr[N-2-2*i]=arr[N-1-i];
			}
			System.out.print("#"+test_case);
			for (int i =0 ;i <N; i++) {
				System.out.print(" "+newArr[i]);
			}
			System.out.println();
		}
	}
}

