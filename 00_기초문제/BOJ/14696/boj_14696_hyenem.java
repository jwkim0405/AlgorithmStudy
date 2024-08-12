import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		end: for (int test_case = 1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[4];
			
			for (int i =0; i<N;i++) {
				arr[sc.nextInt()-1]++;
			}
			
			int M = sc.nextInt();
			for (int i =0; i<M;i++) {
				arr[sc.nextInt()-1]--;
			}
			
			for (int i = 3; i>=0; i--) {
				if(arr[i]==0) continue;
				else if (arr[i]>0) System.out.println('A');
				else System.out.println('B');
				continue end;
			}
			System.out.println('D');
			
		}
	}
}

