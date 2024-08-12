import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 1; i<=N; i++) {
			queue.offer(i);
		}
		
		System.out.print('<');
		int nowitem = 0;
		while(!queue.isEmpty()) {
			if(nowitem!=0) System.out.print(nowitem+", ");
			for(int i = 1; i<K; i++) {
				queue.offer(queue.poll());
			}
			nowitem = queue.poll();
		}
		System.out.print(nowitem+">");
	}
}

