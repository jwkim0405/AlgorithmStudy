import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static int N;
	static int M;
	static boolean[] visited;
	static ArrayList<Integer>[] adj;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N];
		adj = new ArrayList[N];
		
		for (int i = 0; i<N;i++) adj[i]=new ArrayList<>();
		
		for (int i = 0; i<M;i++) {
			int nowX = sc.nextInt()-1;
			int nowY = sc.nextInt()-1;
			adj[nowX].add(nowY);
			adj[nowY].add(nowX);
		}
		
		int ans = 0;
		for (int i = 0; i<N; i++) {
			if(!visited[i]) {
				DFS(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static void DFS(int start) {
		visited[start]=true;
		for (int i = 0; i<adj[start].size(); i++) {
			if(!(visited[adj[start].get(i)])) {
				DFS(adj[start].get(i));
			}
		}
	}
}

