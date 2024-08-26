import java.util.Scanner;

public class boj_11403_yuyoung {
	static int N; // 정점의 개수
	static int[][] G; // 방향 그래프
	static int[][] result;
	static boolean[] visited; // 방문 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		G = new int[N][N];
		result = new int[N][N];
		visited = new boolean[N];
		
		// 인접 행렬 입력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// i에서 j로 가는 간선 존재 여부
				G[i][j] = sc.nextInt();
			}
		}
		
		// 각 정점에서 다른 정점으로 가는 경로 탐색
		for(int i = 0; i < N; i++) {
			// 새로운 행마다 방문 여부 초기화
			for(int j = 0; j < N; j++) {
				visited[j] = false;
			}
			
			// i에서 j로 가는 경로가 존재하면 DFS 수행
			for(int j = 0; j < N; j++) {
				if(G[i][j] == 1 && !visited[j]) {
					dfs(i,j);
				}
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int r, int c) {
		visited[c] = true;
		result[r][c] = 1; // r에서 c로 가는 경로 존재
		
		// c에서 연결된 다른 정점 선택
		for(int i = 0; i < N; i++) {
			if(G[c][i] == 1 && !visited[i]) {
				dfs(r, i);
			}
		}
	}
	
}
