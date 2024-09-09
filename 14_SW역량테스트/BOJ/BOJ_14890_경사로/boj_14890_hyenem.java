import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int x = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for (int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			int count = 0;
			end:for (int i = 0; i<N; i++) {
				int[] nowRow = arr[i];
				boolean[] visited = new boolean[N];
				for(int j = 1; j<N; j++) {					
					if(nowRow[j-1]==nowRow[j]) continue;
					else if(nowRow[j-1]-nowRow[j]==1) {
						if(j+x-1>=N) continue end;
						for(int k = 0; k<x; k++) {
							if(nowRow[j]!=nowRow[j+k] || visited[j+k]) continue end;
						}
						for(int k = 0; k<x; k++) {
							visited[j+k]=true;
						}
					} else if(nowRow[j-1]-nowRow[j]==-1) {
						if(j-x<0) continue end;
						for(int k = 0; k<x; k++) {
							if(nowRow[j-1]!=nowRow[j-k-1]|| visited[j-k-1]) continue end;
						}
						for(int k = 0; k<x; k++) {
							visited[j-k-1]=true;
						}
					} else {
						continue end;
					}
				}
				count++;
			}
			
			end:for (int i = 0; i<N; i++) {
				int[] nowCol = new int[N];
				for (int j = 0; j<N; j++) {
					nowCol[j]=arr[j][i];
				}
				boolean[] visited = new boolean[N];
				for(int j = 1; j<N; j++) {					
					if(nowCol[j-1]==nowCol[j]) continue;
					else if(nowCol[j-1]-nowCol[j]==1) {
						if(j+x-1>=N) continue end;
						for(int k = 0; k<x; k++) {
							if(nowCol[j]!=nowCol[j+k] || visited[j+k]) continue end;
						}
						for(int k = 0; k<x; k++) {
							visited[j+k]=true;
						}
					} else if(nowCol[j-1]-nowCol[j]==-1) {
						if(j-x<0) continue end;
						for(int k = 0; k<x; k++) {
							if(nowCol[j-1]!=nowCol[j-k-1]|| visited[j-k-1]) continue end;
						}
						for(int k = 0; k<x; k++) {
							visited[j-k-1]=true;
						}
					} else {
						continue end;
					}
				}
				count++;
			}
			System.out.println(count);
		}
	}
