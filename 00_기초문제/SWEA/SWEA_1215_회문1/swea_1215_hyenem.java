import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		    int searchsize = sc.nextInt();
            
            //입력값 배열 구성
            char[][] array = new char[8][8];
            String str = "A";
            for (int i = 0; i < 8; i++){
                str = sc.next();
                for (int j = 0; j < 8; j++){
                    array[i][j]=str.charAt(j);
                }
            }

            int answer = 0;
            int count = 0;
            char[] nowarray= new char[searchsize];
                
            //크기 4단위로 탐색 시작
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8-searchsize+1; j++){
                    if (array[i][j]==array[i][j+searchsize-1]){
                        count=0;
                        for (int k = 1; k<searchsize/2; k++){
                            if (array[i][j+k]==array[i][j+searchsize-1-k]){
                                count++;
                            }
                        }
                        if (count==searchsize/2-1){
                            answer++;
                        }
                    }
                }
            }   
            for (int j = 0; j < 8; j++){
                for (int i = 0; i < 8-searchsize+1; i++){
                    if (array[i][j]==array[i+searchsize-1][j]){
                        count=0;
                        for (int k = 1; k<searchsize/2; k++){
                            if (array[i+k][j]==array[i+searchsize-1-k][j]){
                                count++;
                            }
                        }
                        if (count==searchsize/2-1){
                            answer++;
                        }
                    }
                }
            }
            
            
            System.out.printf("#%d %d",test_case, answer);
			System.out.println();
		}
	}
}
