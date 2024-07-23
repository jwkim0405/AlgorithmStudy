import java.util.Scanner;

public class Boj_1244_hyenem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] switchState = new int[N+1];
		switchState[0]=-1;
		for (int i = 1; i<N+1; i++) {
			switchState[i]=sc.nextInt();
		}
		
		int M = sc.nextInt();
		
		for (int i = 0; i<M; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if (gender==1) {
				for (int j = 1; j<(N/num)+1; j++) {
					switchState[j*num]=1-switchState[j*num];
				}
			} else if (gender==2) {
				switchState[num]=1-switchState[num];
				for (int j = 1; j<Math.min(num-1, N-num)+1; j++) {
					if (switchState[num-j]!=switchState[num+j]) {
						break;
					}
					switchState[num-j]=1-switchState[num-j];
					switchState[num+j]=1-switchState[num+j];
				}
			}
		}
		for(int i = 0; i<N/20;i++) {
			for (int j = 1; j<21; j++) {
				System.out.print(switchState[i*20+j]+" ");
			}
			System.out.println();
		}
		for (int i = (N/20)*20+1; i<N+1; i++) {
			System.out.print(switchState[i]+" ");
		}
	}
}

