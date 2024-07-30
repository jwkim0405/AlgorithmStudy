import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Main{
    static int N;
	static int M;
	static int V;
	
	static boolean[][] adj;
	static boolean[] visited;
	static int point;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		adj = new boolean[N][N];
		visited = new boolean[N];
		point = 0;
		
		for (int i =0; i<M; i++) {
			int ni = sc.nextInt()-1;
			int nj = sc.nextInt()-1;
			adj[ni][nj]=true;
			adj[nj][ni]=true;
		}
		
		DFS(V-1);
		System.out.println();
		visited = new boolean[N];
		BFS(V-1);
	}
	
	static void DFS(int i) {
		visited[i]=true;
		System.out.print(i+1 +" ");
		for (int j =0; j<N; j++) {
			if(adj[i][j]==true) {
				if(!visited[j]) DFS(j);
			}
		}
	}
	
	static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i]=true;
		
		while(!queue.isEmpty()) {
			int nowi = queue.poll();
			System.out.print(nowi+1 + " ");
			for (int j =0; j<N; j++) {
				if(adj[nowi][j] && !(visited[j])) {
					queue.add(j);
					visited[j]=true;
				}
			}
		}

	}
}
