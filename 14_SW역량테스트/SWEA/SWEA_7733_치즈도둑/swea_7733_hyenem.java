import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int maxCount = 1;
            for(int time = 0 ; time<100; time++){
                int count = 0;
                boolean[][] visited = new boolean[N][N];
                Queue<int[]> queue = new LinkedList<>();
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<N; j++){
                        if(arr[i][j]<time || visited[i][j]) continue;
                        visited[i][j]=true;
                        queue.offer(new int[]{i,j});
                        while(!queue.isEmpty()){
                            int[] thisItem = queue.poll();
                            int x = thisItem[0];
                            int y = thisItem[1];
                            
                            for(int k = 0; k<4; k++){
                                int newx = x+dx[k];
                                int newy = y+dy[k];
                                if(newx>=0 && newy>=0 && newx<N && newy<N && arr[newx][newy]>=time && !visited[newx][newy]){
                                    visited[newx][newy]=true;
                                    queue.offer(new int[]{newx, newy});
                                }
                            }
                        }
                        count ++;
                    }
                }
                if(maxCount<count) {
                    maxCount= count;
                }
            }
            System.out.println("#"+test_case+" "+maxCount);
		}
	}
}
