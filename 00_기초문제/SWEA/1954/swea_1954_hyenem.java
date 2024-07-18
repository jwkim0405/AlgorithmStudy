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
        int scale = sc.nextInt();
        int[][] matrix = new int[scale][scale];
        int x = 0;
        int y = 0;
        int switch_ = 0;
        int write = 2;
        int xrecord = 0;
        int yrecord = 0;
        matrix[0][0]=1;
        while (write <= scale * scale){
            while (true){
                xrecord = x;
                yrecord = y;
                if (switch_%4==0){
                    x++;
                } else if (switch_%4==1){
                    y++;
                } else if (switch_%4==2){
                    x--;
                } else {
                    y--;
                }
                if (matrix[y][x]!=0 ){
                    x = xrecord;
                    y = yrecord;
                    break;
                } else if ((x%(scale-1))+(y%(scale-1))==0){
                    matrix[y][x]=write;
                    write++;
                    break;
                } else {
                    matrix[y][x]=write;
                    write++;
                }
            }
            switch_++;
        }
		System.out.printf("#%d ",test_case);
        System.out.println();
        for (int i = 0 ; i<scale;i++){
            for (int j =0; j<scale;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        }
		}
	}

