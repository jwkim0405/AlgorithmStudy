import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{

            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] array = new int[N][N];

    		for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    array[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            int answer = 0;

            for (int i = 0 ; i < N; i++){
                count=0;
                for (int j = 0; j < N; j++){
                    if (array[i][j]==1){
                        count++;
                        if (count==K){
                            answer++;
                        } else if(count==K+1){
                            answer--;
                        }
                    } else {
                        count=0;
                    }
                }
            }
            
            for (int j = 0 ; j < N; j++){
                count=0;
                for (int i = 0; i < N; i++){
                    if (array[i][j]==1){
                        count++;
                        if (count==K){
                            answer++;
                        } else if(count==K+1){
                            answer--;
                        }
                    } else {
                        count=0;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
	}
}
