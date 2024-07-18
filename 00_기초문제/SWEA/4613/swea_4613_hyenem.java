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
            int M = sc.nextInt();
            int count = 0;
            int max = 0;
            int[] countW = new int[N];
            int[] countB = new int[N];
            int[] countR = new int[N];
            String str;
            
            for (int i = 0; i < N; i++){
                str = sc.next();
                for (int j = 0; j < M; j++){
                    if (str.charAt(j)=='W'){
                        countW[i]++;
                    } else if (str.charAt(j)=='B') {
                        countB[i]++;
                    } else {
                        countR[i]++;
                    }
                }
            }

            for (int startB = 1; startB < N-1; startB++){
                for (int startR = startB+1; startR < N; startR++){
                    count=0;
                    for (int i = 0; i < startB; i++){
                        count=count+countW[i];
                    }
                    for (int i = startB; i < startR; i++){
                        count=count+countB[i];
                    }
                    for (int i = startR; i < N; i++){
                        count=count+countR[i];
                    }
                    if (count>max){
                        max = count;
                    }
                }
            }

            System.out.printf("#%d %d \n", test_case, N*M-max);
		}
	}
}
