import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[][] visited;
	static int[][] ans;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N][M];
		ans = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			String str = sc.next();
			for(int j = 0; j<M; j++) {
				if(str.charAt(j)=='0') visited[i][j]=true;
			}
		}
		
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		Queue<Integer> level = new LinkedList<>();
		
		visited[0][0]=true;
		queueX.offer(0);
		queueY.offer(0);
		level.offer(1);
		while(!queueX.isEmpty()) {
			int i = queueX.poll();
			int j = queueY.poll();
			int thislevel = level.poll();
			visited[i][j]=true;
			if(ans[i][j]==0) ans[i][j]=thislevel;
			else ans[i][j] = Math.min(ans[i][j], thislevel);
			for(int k = 0; k<4; k++) {
				if(i+dx[k]>=0 && i+dx[k]<N && j+dy[k]>=0 && j+dy[k]<M && !visited[i+dx[k]][j+dy[k]]) {
					queueX.offer(i+dx[k]);
					queueY.offer(j+dy[k]);
					visited[i+dx[k]][j+dy[k]]=true;
					level.offer(thislevel+1);
				}
			}
		}
		System.out.println(ans[N-1][M-1]);
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
}

