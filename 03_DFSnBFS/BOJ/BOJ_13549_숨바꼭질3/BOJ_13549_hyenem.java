import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> nextqueue = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		
		int count = 0;
		int thisItem = N;
		if(thisItem==0) queue.offer(thisItem);
		else {
			while(thisItem<visited.length) {
				if(!visited[thisItem]) {
					visited[thisItem]=true;
					queue.offer(thisItem);
				}
				thisItem*=2;
			}
		}
		end: while(true) {
//			System.out.println(queue);
			while(!queue.isEmpty()) {
				thisItem=queue.poll();
				if (thisItem==K) break end;
				if(thisItem+1<visited.length && !visited[thisItem+1]) {
					nextqueue.offer(thisItem+1);
				}
				if(thisItem-1>=0 && !visited[thisItem-1]) {
					nextqueue.offer(thisItem-1);
				}
			}
			count++;
			while(!nextqueue.isEmpty()) {
				thisItem = nextqueue.poll();
				if (thisItem==0) {
					visited[thisItem]=true;
					queue.offer(thisItem);
					continue;
				}
				while(thisItem<visited.length) {
					if(!visited[thisItem]) {
						visited[thisItem]=true;
						queue.offer(thisItem);
					}
					thisItem*=2;
				}
			}
		}
		
		System.out.println(count);
	}
}

