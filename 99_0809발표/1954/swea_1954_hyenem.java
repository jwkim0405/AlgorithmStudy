import java.util.Scanner;
import java.io.FileInputStream;

class swea_1954_hyenem
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for ( int test_case = 1; test_case<T+1; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int[] dx = {1,0,-1,0};	//델타배열..인데 탐색이 아닌
			int[] dy = {0,1,0,-1};	//좌 하 우 상
			
			int num = 1;	//채워넣을 숫자
			int x = -1;
			int y = 0;
			for( int i = 0; i<2*N-1; i++) {
				for (int j = 0; j<(2*N-i)/2; j++) {
					x+=dx[i%4];
					y+=dy[i%4];
					arr[y][x]=num++;
				}
			}
			
            System.out.println("#"+test_case);
			for (int i=0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}


