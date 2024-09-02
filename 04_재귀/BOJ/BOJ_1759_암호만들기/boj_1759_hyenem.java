import java.util.Arrays;
import java.util.Scanner;

public class Boj_1759_hyenem {
	
	static void dfs(int L, int C, int start, int con, int vo, String str, char[] arr) {
		if(con+vo == L) {
			if(con>=2 && vo>=1) {
				System.out.println(str);
			}
		} else {
			for (int i = start+1; i<C; i++) {
				if (arr[i]=='a' ||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') {
					dfs(L, C, i, con, vo+1, str+arr[i], arr);		
				} else {
					dfs(L, C, i, con+1, vo, str+arr[i], arr);			
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int C = sc.nextInt();
		
		char[] candidate = new char[C];
		for (int i =0; i<C; i++) {
			candidate[i]=sc.next().charAt(0);
		}
		
		Arrays.sort(candidate);
		
		dfs(L, C, -1, 0, 0, "", candidate);
		
	}
}

