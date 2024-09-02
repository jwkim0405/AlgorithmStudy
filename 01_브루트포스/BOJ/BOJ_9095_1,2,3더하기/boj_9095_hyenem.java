import java.util.Scanner;



public class Main {
	
	public static int partition(int N) {
		if (N==1) return 1;
		else if (N==2) return 2;
		else if (N==3) return 4;
		else return partition(N-1)+partition(N-2)+partition(N-3);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<T+1;test_case++) {
			int num = sc.nextInt();
			System.out.println(partition(num));
		}
	}
	
}

