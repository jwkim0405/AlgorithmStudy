import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] ans;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N];
		ans = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(sc.nextInt()==1) list[i].add(j);
			}
		}
				
		for(int i = 0; i<N; i++) {
			if(list[i].size()==0) continue;
			boolean[] visited = new boolean[N];
			dfs(i, i, visited, 0);
			for(int k = 0; k<N ; k++) {
				if(visited[k]) {
					ans[i][k]=1;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			for (int j= 0; j<N; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	static void dfs(int i, int j, boolean[] visited, int count) {
		if(visited[j]) return;
		if(count!=0) visited[j]=true;
		if(list[j].size()==0) return;
		for(int k = 0 ;k<list[j].size(); k++) {
			dfs(i, list[j].get(k), visited, count+1);
		}
	}
}

