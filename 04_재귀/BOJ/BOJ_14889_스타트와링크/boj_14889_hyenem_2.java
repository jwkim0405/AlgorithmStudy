import java.util.Scanner;

public class Boj_14889_hyenem_2 {
	
	static int N;
	static int[] teamArr;
	static int[][] arr;
	static int Min=100000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		teamArr = new int[N];
		teamArr[0]=1;
		arr = new int[N][N];
		for (int i =0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		combination(1,1);
		System.out.println(Min);
	}
	
	static void combination(int start, int num) {
		if(num == N/2) {
			compute();
			return;
		} else if (start>=N) {
			return;
		}
		teamArr[start]=1;
		combination(start+1, num+1);
		
		teamArr[start]=0;
		combination(start+1, num);
		
	}
	
	static void compute() {
		int distance = 0;
		for (int i = 0; i<N-1; i++) {
			for (int j = i+1; j<N; j++) {
				if(teamArr[i]==1 && teamArr[j]==1) {
					distance += arr[i][j];
					distance += arr[j][i];
				} else if (teamArr[i]==0 && teamArr[j]==0) {
					distance -= arr[i][j];
					distance -= arr[j][i];
				}
			}
		}
		Min = Math.min(Math.abs(distance), Min);
	}
}

