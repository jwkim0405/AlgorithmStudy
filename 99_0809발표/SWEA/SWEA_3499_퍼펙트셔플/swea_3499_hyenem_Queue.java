import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			Queue<String> queue = new LinkedList<>();
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			for (int i = 0; i<N; i++) {
				queue.offer(sc.next());
			}
			for (int i = 0; i<(N+1)/2; i++) {
				queue1.offer(queue.poll());
			}
			for (int i = 0; i<N/2; i++) {
				queue2.offer(queue.poll());
			}
			while(!queue1.isEmpty()) {
				queue.offer(queue1.poll());
                if(!queue2.isEmpty()){
					queue.offer(queue2.poll());
                }
			}
			System.out.print("#"+test_case);
			while(!queue.isEmpty()) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}
	}
}
