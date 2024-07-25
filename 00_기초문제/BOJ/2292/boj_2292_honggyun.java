import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 벌집 문제
		
		/*
		 * << 문제 요약 >>		 * 
		 * 1부터 시작 -> 6시부터 시작해서 반시계 방향으로 칸 채움
		 *  1 <= N <= 10억
		 *  1~N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지
		 *  (시작 && 끝 포함)
		 *  
		 *  << 알고리즘 생각 >>
		 *  방이 육각형으로 이루어져 있음
		 *  1 -> (+6) 7 -> (+12) 19 -> (+18) 37 -> 
		 *  An = 1 + sum(6*(k-1));
		 *  
		 *  => 1+1 ~ A2 <<< 1칸만에 갈 수 있는 범위
		 *  => A2+1 ~ A3 <<< 2칸만에 갈 수 있는 범위
		 *  ...
		 *  => A(n-1)+1 ~ An <<< n-1칸만에 갈 수 있는 범위 
		 *  
		 *  << 구현 >>
		 *  N이 들어오면 숫자보다 커지는 An의 최소값 찾기
		 *  n이 답
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	
		
		// 일반항을 구하기 위해 6의 배수의 합을 저장할 값 생성
		// 1번: 1부터 시작, 2번항부터 6씩 더해짐
		int sum = 1;
		int cnt = 1;
		
		while (true) {
			if(sum >= N) {
				break;
			}
			
			cnt++;
			sum += 6 * (cnt-1);
		}
		
		System.out.println(cnt);
		
		
	}

}
