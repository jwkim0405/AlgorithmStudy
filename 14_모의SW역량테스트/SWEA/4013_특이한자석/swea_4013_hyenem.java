import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int K = sc.nextInt();
			int[][] arr = new int[4][8];
			int[] pointer = new int[4];
			
			for (int i =0; i<4; i++) {
				for(int j = 0; j<8; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i<K; i++) {
				int num = sc.nextInt()-1;
				int direction = sc.nextInt()*(-1);
				
				// 연속해서 다른 극이 붙어있는 경우를 찾음
				// 왼쪽부터
				int count = 0;
				for(int j = num-1; j>=0; j--) {
					if(arr[j+1][(pointer[j+1]+6)%8] == arr[j][(pointer[j]+2)%8]) break;
					else {
						count++;
					}
				}
				//이제 돌리기
				int nowdirection = direction;
				for(int j = 1; j<=count; j++) {
					nowdirection*=(-1);
					pointer[num-j]=(pointer[num-j]+nowdirection+8)%8;
				}
					
				// 다음 오른쪽
				count = 0;
				for(int j = num+1; j<4; j++) {
					if(arr[j-1][(pointer[j-1]+2)%8] == arr[j][(pointer[j]+6)%8]) break;
					else {
						count++;
					}
				}
				//이제 돌리기
				nowdirection = direction;
				for(int j = 1; j<=count; j++) {
					nowdirection*=(-1);
					pointer[num+j]=(pointer[num+j]+nowdirection+8)%8;
				}
				
				//마지막으로 자기 자신 돌리기
				pointer[num] = (pointer[num]+direction+8)%8;
			}
			
			int ans = 0;
			for(int i = 0; i<4; i++) {
				if(arr[i][pointer[i]]==1) {
					ans+=(int)Math.pow(2,i);
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
}

