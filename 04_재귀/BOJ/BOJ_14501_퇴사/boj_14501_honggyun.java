import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		
		// 퇴사 문제
		/* << 알고리즘 아이디어 >>
		 * 오늘(0) + N+1 = 퇴사 날
		 * 1 <= N <= 15
		 * 상담에 걸리는 일 수 안에 퇴사 날이 있으면 그 상담은 불가능
		 * -> if i(날짜) + Ti - 1(일수) >= N+1이면, Pi(수익) = 0으로 하기?
		 * 상담에 걸리는 일 수 안에 있는 다른 상담은 불가능
		 * if i 고르면 -> i + Ti가 될 때까지 continue?
		 * 
		 * << 핵심 >>
		 * 최대 수익 구하기
		 * how to ?
		 * 방식) 
		 * - 아이디어 1
		 * i_x = (i_(x-1) + Ti_(x-1))를 해나가며 (i_x + Ti_x) < (N+1) 일 때까지 시행하는 모든 경우의 수를 체크
		 * 시행하는 한 세트(x값이 1개 돌아가는 세트)마다 tmp에 값을 저장하고, 맨 마지막에 tmp와 sum의 값을 비교해서 큰 쪽을 sum에 저장
		 * 최종적으로 sum에 저장된 값을 출력
		 * 
<<<<<<< HEAD
		 * - 아이디어 2
		 * 1. i = N(마지막 날)을 탐색. 
		 * 2-1. if N + TN > N+1 이면 그 상담은 불가능하므로 continue로 다음 반복 실행
		 * 2-2. if N + TN <= N+1 이면 그 상담은 가능. N을 cnt(반복문 밖)에, PN을 tmp에 저장한다.
		 * if N - 1 == 1이면 마지막 탐색. (if문을 N번 돌릴 것이라 케어될 듯)
		 * 3. i = N-1을 탐색. (이동)
		 * 4-1. if N-1 + T(N-1) > N이면 N-1날 상담은 불가능하므로 continue로 다음 재귀 실행
		 * 4-2. if N-1 + T(N-1) <= N이면 상담 가능. P(N-1)을 tmp에 더한다. 
		 * 이후 재귀로 가능한 가장 적은 i가 될 때까지 탐색
		 * 5. sum과 tmp를 비교하고 더 큰 쪽을 sum에 저장.
		 * ----------------------------------------------------------------------
		 * 6. 다음 반복에서 i = N-1부터 탐색 시작.
		 * 7-1. if N-1 >= cnt면 중복된 탐색이므로 continue로 다음 반복 실행
		 * 7-2. if N-1 < cnt면 이전 반복에서 하지 않은 탐색이므로 재귀 실행
		 * 
		 * ==> 생각해보니 오히려 첫날부터 시작하는 걸 이 과정으로 탐색하면 될 거 같은 느낌???? 
		 * ==> 재귀가 너무 헷갈린다!!
		 * 
		 * 첫 시행을 제외하고 결국엔
		 * n번째로 점프했을 때의 Pn과, P(n+1) + P((n+1)+T(n+1)) 
=======
		 * << 구현 >>
		 * 1. x을 고른다.
		 * 1-1. x + Tx - 1 <= N인지 검사한다. false라면 이전까지 저장한 sum을 반환하고 종료한다.
		 * 1-2. true라면, Px을 sum에 더한다.
		 * 1-3. x + Tx <= y <= N 범위 중에 한 값을 고른다. 
		 * 2-1. y + Ty - 1 <= N인지 검사한다. false라면 이전까지 저장한 sum을 반환하고 종료한다.
		 * 2-2. true라면, Py를 sum에 더한다.
		 * 반복
>>>>>>> 0ec491c12ebd24b132ab9ccc0f63393eab287030
		 * 
		 * << ?! >> 
		 * 1. (i=0;i<n;i++) 0번째 i를 고른다
		 * 2. 0+T0-1이 n 이하인지 검사한다. false라면 continue;
		 * 3. true라면, P0을 저장한다.
		 * 4. 0+T0을 고른다. 
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 2줄짜리 이중배열로 T와 P 저장
		int[][] counselTable = new int[2][N];
		
		for(int i = 0; i < N; i++) {
			counselTable[0][i] = sc.nextInt();
			counselTable[1][i] = sc.nextInt();		
						
		}
			
		int sum = 0;
		int result = searchMaximum(N, counselTable, 0, sum);
		System.out.println("난 main메소드의 result라고 해 = " + result);
		
	}
	
	// 진짜 역순으로 돌려야하나??????????????????????
	
	// 재귀로 돌릴 함수 생성
	public static int searchMaximum(int N, int[][] counselTable, int idx, int sum) {
		// 1. (idx = 0; idx < n; idx++) 돌아갈 것?
		int T = counselTable[0][idx];
		int P = counselTable[1][idx];
		
		// 값을 어떻게 저장해야 잘 저장한단 말이오... 
		
		System.out.println("idx는 =" + idx + ", " + "T는 = " + T);
		
		// 2. 상담일이 상담 가능한 조건인지 검사. 
		// idx + T_idx - 1이 n 이하인지 검사한다. 
		// false라면 이전까지 저장한 sum 반환
		if(idx + T - 1 > N) {
			System.out.println("idx는 =" + idx);
			return sum;
		} else {	
		// 3. true라면, P0을 저장한다.	
		sum += P; 
		System.out.println("idx는 =" + idx + ", " + "tmp는 = " + tmp + ", " + "sum은 = " + sum);
		
		// 4. 0+T0을 고른다. 이 때, idx >= N이면 예외처리를 한다.
		if(idx+1 >= N || idx+T >= N)  {
			return sum; 
		}
		
		searchMaximum(N, counselTable, idx+T, sum);					
		// 반복을 굴린다. 데굴데굴.
		return searchMaximum(N, counselTable, idx+1, sum);			
			
		}

		
	}

}
