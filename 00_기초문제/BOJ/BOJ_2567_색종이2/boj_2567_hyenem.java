import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i<N; i++) {
			arr[i][0]= sc.nextInt();
			arr[i][1]= sc.nextInt();
		}
		
		arrsortX(arr);
		int sumX = 10;
		for (int i =1; i<N; i++) {
			int high=arr[i][1]+10;
			int low=arr[i][1];

			for(int j =i-1; j>=0; j--) {
				if(arr[j][0]+10<arr[i][0]) break;
				if(arr[j][1]>arr[i][1]) high = Math.min(high, arr[j][1]);
				else low = Math.max(low, arr[j][1]+10);
			}
			sumX+=Math.max(high-low,0);
		}
		
		arrsortY(arr);
		int sumY = 10;
		for (int i =1; i<N; i++) {
			int high=arr[i][0]+10;
			int low=arr[i][0];
			for(int j =i-1; j>=0; j--) {
				if(arr[j][1]+10<arr[i][1]) break;
				if(arr[j][0]>arr[i][0]) high = Math.min(high, arr[j][0]);
				else low = Math.max(low, arr[j][0]+10);
			}
			sumY+=Math.max(high-low,0);
		}
		
		
		System.out.println(2*(sumX+sumY));
	}
	
	static void arrsortX(int[][] arr){
		for (int i =0; i<N-1; i++) {
			for (int j =i+1; j<N; j++) {
				if(arr[i][0]>arr[j][0]) {
					int[] tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
				
			}
		}
	}
	static void arrsortY(int[][] arr){
		for (int i =0; i<N-1; i++) {
			for (int j =i+1; j<N; j++) {
				if(arr[i][1]>arr[j][1]) {
					int[] tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
				
			}
		}
	}
}

