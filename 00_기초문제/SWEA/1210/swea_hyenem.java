import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        for (int T = 0; T < 10; T++){
            
            int test_case = sc.nextInt();
            int[][] array= new int[100][102];
            
            for (int i = 0; i<100; i++){
                for (int j = 1; j<101; j++){
                    array[i][j] = sc.nextInt();
                }
                array[i][0]=0;
                array[i][101]=0;
            }

            int point = 0;
            int end = 0;
            int answer = 0;

            
            for (int j = 0; j<102; j++){
                if (array[99][j]==2){
                    end = j;
                }
            }
            
			for (int i = 98; i>0; i--){
                if (array[i][end-1]==1){
                    while (array[i][end-1]==1){
                        end--;
                    }
                }else if (array[i][end+1]==1){
                    while (array[i][end+1]==1){
                        end++;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, end-1);
        }
    }
}

