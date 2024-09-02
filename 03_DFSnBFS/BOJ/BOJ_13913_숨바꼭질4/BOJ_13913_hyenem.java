import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack = new Stack<>();
	static boolean[] visited;
	static int count;
	static int K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> queue = new LinkedList<>();
		Deque<Integer> nextqueue = new LinkedList<>();
		
		int N = sc.nextInt();
		K = sc.nextInt();
		if(K<N) {
			System.out.println(N-K);
			for(int i = N; i>=K; i--) {
				sb.append(i);
				sb.append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		visited = new boolean[Math.max(N, K)*2+1];
		int[] adj = new int[Math.max(N, K)*2+1];
		for(int i = 0; i<adj.length; i++) {
			adj[i]=-1;
		}
		
		count = 0;
		visited[N]=true;
		queue.offer(N);
		end: while(true) {
			while(!queue.isEmpty()) {
				int thisItem = queue.poll();
				if(thisItem==K) break end;
				if(thisItem+1<visited.length && !visited[thisItem+1]) {
					visited[thisItem+1]=true;
					adj[thisItem+1]=thisItem;
					nextqueue.offer(thisItem+1);
				}
				if(thisItem-1>=0 && !visited[thisItem-1]) {
					visited[thisItem-1]=true;
					adj[thisItem-1]=thisItem;
					nextqueue.offer(thisItem-1);
				}
				if(thisItem*2<visited.length && !visited[thisItem*2]) {
					visited[thisItem*2]=true;
					adj[thisItem*2]=thisItem;
					nextqueue.offer(thisItem*2);
				}
			}
			count++;
			while(!nextqueue.isEmpty()) {
				queue.offer(nextqueue.poll());
			}
		}
		System.out.println(count);
		
		String path = "";
		int thisItem = K;
		while(thisItem!=-1) {
			path = thisItem+" "+path;
			thisItem = adj[thisItem];
		}
		System.out.println(path);
	}
}

