import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 직사각형을 만드는 방법 문제
		
		/*
		 * << 문제 요약 >>
		 * 정사각형 n개로 만들 수 있는 중복되지 않은 직사각형의 개수는?
		 * 회전, 이동해서 만들 수 있는 모양이면 중복!
		 * 
		 * << 알고리즘 생각 >>
		 * 직사각형의 한 변의 길이를 k라고 하면, 만들 수 있는 직사각형은 k의 배수.
		 * 이 때 n개를 전부 활용해서 만들 수 있는 직사각형의 개수는
		 * k가 1부터 시작해서 점점 늘어나는 구조.
		 * 중복이 되지 않는 직사각형의 개수는 나누는 숫자가 나눠서 나오는 몫보다 작거나 같은 경우의 수
		 * e.g.) n = 24 -> 1*24, 2*12, 3*8, 4*6 -> 4개 가능
		 * 
		 * << Input & Output >>
		 *  1 <= n <= 1만
		 * 만들 수 있는 직사각형의 총 개수를 출력
		 * 
		 * 
		 * << 구현 >>
		 * n = sc.nextInt()
		 * int restut = 0;
		 * 
		 * 전체 반복 1~n까지의 합 구하기
		 * for(i<n) {
		 *  
		 * n개의 정사각형을 전부 사용해서 만들 수 있는 직사각형의 개수 = An
		 * int An = 0;
		 * int cnt = 1;
		 * 
		 * while true {
		 * 	if(cnt > (n / cnt)) { break; }
		 * 		else if(cnt <= (n / cnt) && n % cnt == 0) {
		 * 		cnt++;
		 *	} 
		 * }
		 * 
		 * result += cnt;
		 * cnt = 1;
		 * 
		 * } 
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 결과 저장할 값 생성
		int result = 0;
		
		// 전체 반복
		for(int i = 1; i < n + 1; i++) {
			
			// cnt: n개의 정사각형을 전부 사용해서 만들 수 있는 직사각형 개수	
			int cnt = 0;	
			for(int j = 1; j < i + 1; j++) { // 사실 약수의 개수/2 + 1번까지만 돌리면 됨
				
				if(j > (i / j)) {
					break; // 나누는 숫자(j)가 몫(n/j)보다 커질 때 break
				} else if(j <= (i/j) && (i % j) == 0) { // 그 이전에 나누어 떨어지는 약수면 cnt++	
						cnt++;			
					}
			}		
			result += cnt;
		}
		
		System.out.println(result);
		
	}

}
