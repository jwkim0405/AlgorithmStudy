import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1158_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();

		List<Integer> list = new ArrayList<>();

		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		

		System.out.print("<");

		int idx = 0;
		while(true) {
			if(list.size() == 0) break;
			idx = (idx + k-1) % list.size() ;
			System.out.print(list.get(idx));
			list.remove(idx);
			if(list.size() != 0) {
				System.out.print(", ");
			}
		}
		System.out.print(">");

	}

}
