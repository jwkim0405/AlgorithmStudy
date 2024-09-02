import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 합분해 문제
		
		/*
		 * << 문제 요약 >>
		 * 0~N까지의 정수 중에서 K개를 골라 더해 그 합이 N이 되는 경우의 수를 구하기
		 * 덧셈의 순서가 바뀌어도 다른 경우로 세기 -> 단순 2배?
		 * 한 개의 수를 여러 번 쓸 수 있다. <- 1 + 1 + 1 + 1 ... 처럼 인듯
		 * 	
		 * << Input & Output >>
		 * 첫 줄에 N, K가 주어짐
		 * 
		 * 답을 10억으로 나눈 나머지를 출력 < 10억 미만이면 그냥 출력, 10억 이상이면 나눠서 나머지 출력하면
		 * 시간 절약 가능할듯!
		 * 
		 * << 알고리즘 생각 >>
		 * 하나씩 천천히 나눠서 보면,
		 * K=1 -> N => 0+1개 == A_1
		 * K=2 -> 0+N, 1+(N-1), ... N+0 => (N+1)*1개 == sum(A_1) (0~N범위) 
		 * K=3 -> (N+1)(N+2)/2 == sum(A_2) (0~N범위)
		 * K=4 -> ((N+1)(N+2)/2) * (N+1) == sum(A_3) (0~N범위)
		 * ...
		 * K -> sum(A_(K-1)) (0~N범위) 
		 * => A_K = (N+1)*A_(K-1)
		 * 
		 * << Input & Output >>
		 * 한 줄에 1<=N<=200, 1<=K<=200이 주어짐
		 * 
		 * << 구현 >>
		 * for문으로 0부터 N까지 돌려서 나온 값을 저장하고, 그걸 다시 for문에 넣고 돌리는 과정이 필요함
		 * 
		 * 1. N이랑 K 받기 
		 * 2. 재귀문으로 구현?
		 * public static int divideSum(int N, int K) {
		 * 		int sum = 0;
		 * 		if(K == 1) return 1;
		 * 		for(int i = 0; i <= N; i++) {
		 * 			sum += i+1
		 *		 }
			return (N+1) * divideSum(N, K-1)
			}
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result = divideSum(N, K);
		if(result < 1000000000) {
			System.out.println(result);
		} else {
			System.out.println(result % 1000000000);
		}				
	}
	
	// 값을 구해줄 재귀 함수 정의
	public static int divideSum(int N, int K) {
		// 시그마 값 저장할 변수 생성
		int sum = 0;
		
		if(K == 1) return 1; // 기본값 설정
		
		// 시그마 0에서 N까지 1씩 더하기 -> f(1) {for(i=0;i<=N;i++){sum += 1}}
		// 시그마 0에서 N까지 (시그마 0에서 N까지 1씩 더하기) -> sum += f(f(1)) <- 2번항
		for(int i = 0; i <= N; i++) {
			sum += divideSum(i, K-1);			
		}
		
		return sum;
	}

}
