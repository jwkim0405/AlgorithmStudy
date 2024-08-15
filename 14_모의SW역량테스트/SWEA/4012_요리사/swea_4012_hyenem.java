
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N;
    static boolean[] split;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            split = new boolean[N];
            split[0]=true;
            
            arr =new int[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            
            ans = Integer.MAX_VALUE;
            combination(1,1);
            System.out.println("#"+test_case+" "+ans);
            
		}
	}
    static void combination(int start, int count){
        if(count==N/2){
            int sum = 0;
            for (int i = 0; i<N; i++){
                for(int j = i+1; j<N; j++){
                    if(split[i] && split[j]) sum+=arr[i][j]+arr[j][i];
                    else if(!split[i] && !split[j]) sum-= arr[i][j]+arr[j][i];
                }
            }
            ans = Math.min(ans, Math.abs(sum));
            return;
        }
        if(start>=N) return;
        combination(start+1,count);
        split[start]=true;
        combination(start+1, count+1);
        split[start]=false;
    }
}
