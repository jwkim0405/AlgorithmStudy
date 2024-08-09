
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<11; test_case++) {
            int T = sc.nextInt();
			boolean[][] ladder = new boolean[99][102];
			for (int i = 0; i<99; i++) {
				for (int j = 1; j<101; j++) {
					if(sc.nextInt()==1) ladder[i][j]=true;
				}
			}
			
			int[] vertex = new int[50];
			int point = 0;
			int start = 0;
			for(int i = 1; i<101; i++) {
				int res = sc.nextInt();
				if(res==1) {
					vertex[point++] = i;
				} else if (res==2) {
					start = point;
					vertex[point++] = i;
				}
			}
			for (int i = 98; i>=0; i--) {
				if(ladder[i][vertex[start]-1]) start--;
				else if(ladder[i][vertex[start]+1]) start++;
			}
			
			System.out.println("#"+test_case+" "+(vertex[start]-1));
		}
    }
}

