import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class edge implements Comparable<edge>{
		int node1;
		int node2;
		int weight;
		
		edge(int node1, int node2, int weight){
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int[] p;
	static int[] rank;
	
	static int findSet(int node){
		if (node!=p[node]) p[node]=findSet(p[node]);
		return p[node];
	}
	
	static void union(int node1, int node2) {
		int root1 = findSet(node1);
		int root2 = findSet(node2);
		if(rank[root1]>rank[root2]) p[root2]=root1;
		else {
			p[root1]=root2;
			if(rank[root1]==rank[root2]) rank[root2]++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		p=new int[V+1];
		rank = new int[V+1];
		
		PriorityQueue<edge> queue = new PriorityQueue<>();
		for(int i =0; i<V; i++) p[i]=i;
		
		for(int i = 0; i<E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			queue.offer(new edge(x, y, w));
		}
		
		int count = 0;
		int ans = 0;
		while(count!=V-1) {
			edge e = queue.poll();
			if(findSet(e.node1)!=findSet(e.node2)) {
				union(e.node1, e.node2);
				count++;
				ans+= e.weight;
			}
		}
		System.out.println(ans);
		
	}
}
