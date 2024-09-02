import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	
	static ArrayList<int[]> list = new ArrayList<>();
	
	
	public static void main(String[] args) {
		list.add(new int[0]);
		list.add(new int[] {0, 1, 2, 3});
		list.add(new int[] {0, 1});
		list.add(new int[] {2, 3});
		list.add(new int[] {0, 3});
		list.add(new int[] {1, 3});
		list.add(new int[] {1, 2});
		list.add(new int[] {0, 2});

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();
			int[][] arr = new int[N][M];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			boolean[][] visited = new boolean[N][M];
			
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{R, C, 1});
			visited[R][C]=true;
			
			
			int ans = 0;
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				int num = arr[now[0]][now[1]];
				int depth = now[2];
				ans++;
				for(int ele : list.get(num)) {
					if(inRange(now[0]+dx[ele], now[1]+dy[ele])
							&& !visited[now[0]+dx[ele]][now[1]+dy[ele]] && depth+1<=L) {
						for(int i : list.get(arr[now[0]+dx[ele]][now[1]+dy[ele]])) {
							if(dx[ele]==-dx[i] && dy[ele]==-dy[i]) {
								visited[now[0]+dx[ele]][now[1]+dy[ele]]=true;
								queue.offer(new int[] {now[0]+dx[ele], now[1]+dy[ele], depth+1});								
							}
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static boolean inRange(int i , int j) {
		if(i>=0 && i<N && j>=0 && j<M) return true;
		else return false;
	}
}

