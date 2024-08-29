import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[K+1];
		for(int i = 0; i<N; i++) {
			int W = sc.nextInt();
			int V = sc.nextInt();
			for(int j=K; j>=W; j--) {
				arr[j]=Math.max(arr[j], arr[j-W]+V);
			}
		}
		System.out.println(arr[K]);
		
		
	}
}

