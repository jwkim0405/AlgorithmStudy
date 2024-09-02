package BOJ_1753_최단경로;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<int[]>[] adj = new ArrayList[V+1];
		for(int i = 0; i<V+1; i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i= 0; i<E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			adj[start].add(new int[] {end, weight});
		}
		
		int[] ans = new int[V+1];
		for(int i = 1; i<V+1; i++) {
			ans[i]=Integer.MAX_VALUE;
		}
		
		for(int i = 0; i<adj[K].size(); i++) {
			ans[adj[K].get(i)[0]]=adj[K].get(i)[1];
		}
		
		for(int repeat = 0; repeat<V; repeat++) {
			for(int i = 1; i<V+1; i++) {
				if(ans[i]==Integer.MAX_VALUE) continue;
				for(int j=0; j<adj[i].size(); j++) {
					ans[adj[i].get(j)[0]]
							= Math.min(ans[adj[i].get(j)[0]], ans[i]+adj[i].get(j)[1]);
				}
			}
		}
		
		ans[K]=0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<V+1; i++) {
			if(ans[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else {
				sb.append(ans[i]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}

