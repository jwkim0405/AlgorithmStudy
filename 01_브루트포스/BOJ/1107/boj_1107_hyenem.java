import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N+4][N+4];
		for (int i = 0; i<N; i++) {
			String str = sc.next();
			for(int j = 0; j<N; j++) {
				arr[i+2][j+2]=str.charAt(j);
			}
		}
		
		int max = 1;
		for (int i=2; i<N+2; i++) {
			for (int j=2; j<N+2; j++) {
				int count = 0;
				int change = 0;
				int k = j;
				while(change<2) {
					if(arr[i][k]==arr[i][j]) {
						count++;
						k++;
					} else if(arr[i-1][k]==arr[i][j]||arr[i+1][k]==arr[i][j]) {
						change++;
						if (change>1) break;
						count++;
						k++;
					} else if (arr[i-1][j-1]==arr[i][j]||arr[i+1][j-1]==arr[i][j]) {
                        change++;
						if (change>1) break;
						count++;
						break;
					} else if (arr[i][j-2]==arr[i][j]||arr[i][k+1]==arr[i][j]){
                        change++;
						if (change>1) break;
						count++;
						break;
					} else {
						break;
					}
				}
				if (count>max) max = count;
			}
		}
		
		for (int i=2; i<N+2; i++) {
			for (int j=2; j<N+2; j++) {
				int count = 0;
				int change = 0;
				int k = i;
				while(change<2) {
					if(arr[k][j]==arr[i][j]) {
						count++;
						k++;
					} else if(arr[k][j-1]==arr[i][j]||arr[k][j+1]==arr[i][j]) {
						change++;
						if (change>1) break;
						count++;
						k++;
					} else if (arr[i-1][j-1]==arr[i][j]||arr[i-1][j+1]==arr[i][j]) {
						change++;
						if (change>1) break;
                        count++;
						break;
					} else if(arr[i-2][j]==arr[i][j]||arr[k+1][j]==arr[i][j]){
						change++;
						if (change>1) break;
                        count++;
						break;
					} else{
						break;
					}
				}
				if (count>max) max = count;
			}
		}
		
		System.out.println(max);
	}
}