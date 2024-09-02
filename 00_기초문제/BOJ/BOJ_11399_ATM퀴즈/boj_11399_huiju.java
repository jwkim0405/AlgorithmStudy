import java.util.Arrays;
import java.util.Scanner;

public class boj_11399_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//사람의 수
		int[] time = new int[n];	//사람마다 걸리는 시간을 저장할 배열
		
		for(int i=0; i<n; i++) {
			time[i] = sc.nextInt();
		}
		//----------------------------------------
		
		Arrays.sort(time);
		int sum = time[0];
		for(int i=1; i<n; i++) {
			time[i] = time[i-1] + time[i];
			sum += time[i];
		}
		System.out.println(Arrays.toString(time));
		
		System.out.println(sum);		
		
	}

}
