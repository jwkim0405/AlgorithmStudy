import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] waiting = new int[N]; // 사람의 수 만큼의 대기줄
		for(int i = 0; i < N; i++) { // 걸리는 시간 채우기
			waiting[i] = sc.nextInt();			
		}
				
		Arrays.sort(waiting); // 정렬
		
		// 누적합 만들기
		int result = waiting[0];
		for(int i = 1; i < N; i++) {
			waiting[i] += waiting[i-1];
			result += waiting[i];
		}		
		
		System.out.println(result);
		
	}
}

