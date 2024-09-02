import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		
		// 참외 문제
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		// 방향과 길이 저장할 배열 생성
		int[] dirArr = new int[6];
		int[] lenArr = new int[6];
		
		// 각 배열 채우기
		for(int i = 0; i < 6; i++) {
			dirArr[i] = sc.nextInt();
			lenArr[i] = sc.nextInt();
		}
		
		int n = -1;
		// 방향 중에서 짧은 직선 4개 중 4연속의 시작점을 찾는다
		for(int i = 0; i <6; i++) {
			if(dirArr[i] == dirArr[(i+2)%6] && dirArr[(i+1)%6] == dirArr[(i+3)%6]) {
				n = i;
				break;
			}
		}
		
		// 참외밭의 넓이 => 직사각형 2개 더하기
		int size = (lenArr[n] * lenArr[(n+5)%6]) + (lenArr[(n+2)%6] * lenArr[(n+3)%6]);
		
		// 총 자라는 참외 수
		int kMelon = size * k;
		
		System.out.println(kMelon);
		
	}

}
