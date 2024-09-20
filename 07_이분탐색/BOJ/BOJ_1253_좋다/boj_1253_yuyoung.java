import java.util.Arrays;
import java.util.Scanner;

public class boj_1253_yuyoung {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N개의 수 입력
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 오름차순 정렬
		Arrays.sort(arr);
		
		int count = 0;
		
		// 이진 탐색
		for(int k = 0; k < N; k++) {
			int i = 0; // 첫번째 수
			int j = N - 1; // 두번째 수
			
			while (i < j) {
				// 두 수 중에서 합이 되려는 값과 같으면 안됨
				if(i == k) {
					i++;
					continue;
				}
				if(j == k) {
					j--;
					continue;
				}
				
				// 두 수의 합
				int sum = arr[i] + arr[j];
				
				// 두 수의 합이 같으면 조건 만족
				if(sum == arr[k]) {
					count++;
					break;
				}
				
				if(sum < arr[k]) {
					i++;
				} else {
					j--;
				}
			}
		}
		
		System.out.println(count);
	}
}
