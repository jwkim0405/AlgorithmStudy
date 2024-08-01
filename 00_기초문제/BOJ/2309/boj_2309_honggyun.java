import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		// 일곱 난쟁이 문제
		Scanner sc = new Scanner(System.in);
		
		// 난쟁이들의 키 합
		int sum = 0;
		int[] dwarfs = new int[9];
		
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
			sum += dwarfs[i];
		}
		
		// sum에서 원래 7난쟁이 키 합 빼기
		sum -= 100;
		
		// 2중 포문으로 브루트 포스 -> sum이 되는 조합 찾기
out:	for(int i = 0; i < 8; i++) { // 8번째 난쟁이까지만 탐색하면 됨
			for(int j = i+1; j < 9; j++) {
				if(sum == dwarfs[i] + dwarfs[j]) {
					dwarfs[i] = 0;
					dwarfs[j] = 0;
					break out; // 두 난쟁이의 합이 sum이면 가짜!
				}
			}
		}
		
		// quick sort
		Arrays.sort(dwarfs);
		for(int i = 0; i < 9; i++) {
			if(dwarfs[i] != 0) System.out.println(dwarfs[i]);
		}
		

	}

}
