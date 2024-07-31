import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=0; test_case<T; test_case++) {
			String str = sc.next();
			int ans = 0;
			int count = 1;
			for (int i = 0; i<str.length(); i++) {
				if(str.charAt(i)=='O') {
					ans += count++;
				} else {
					count = 1;
				}
			}
			
			System.out.println(ans);
			
		}
	}

}

