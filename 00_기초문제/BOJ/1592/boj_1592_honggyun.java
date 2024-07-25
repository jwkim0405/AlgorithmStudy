import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		
		// 영식이와 친구들 문제
		
		/*
		 * << 문제 요약 >>
		 * 1. 원형 탁자에 시계 방향 1~N으로 앉기
		 * 2. 1번에 앉은 사람이 공을 받고 다른 사람에게 던짐
		 * 3. 받은 사람이 다시 다른 사람에게 공을 던짐
		 * 	-> 공을 M미만으로 받은 사람이 공을 던질 때,
		 * 	3-1. 받은 횟수가 홀수면 자기 위치에서 시계 방향으로 L번째 있는 사람에게
		 * 	3-2. 받은 횟수가 짞수면 자기 위치에서 반시계 방향으로 L번째 있는 사람에게
		 * 4. 반복하다가 한 사람이 공을 M번 받으면 종료
		 * 5. 공을 총 몇 번 던지는가?
		 * 
		 * << 입출력 >>
		 * 입력: 한 줄에 N, M, L이 입력으로 들어옴 3<=N<50 자연수, M<= 자연수, L<=N-1 자연수 
		 * 출력: 첫째 줄에 횟수 출력 
		 * 
		 * << 알고리즘 생각 >>
		 * N명이 앉는 원형 탁자 - 길이가 N인 일차원 배열에서 들어오는 값을 N으로 나눈 나머지와 같음
		 * 우선 1~N을 저장할 일차원 배열 friends 생성.
		 * 공을 받는 횟수를 저장할 일차원 배열 cnts 생성.
		 * 1. 1번 자리 사람이 공을 받으므로 cnt[0]++; 하고 시작
		 * 2. cnt[0]이 홀수인지 짝수인지 검사 (첫 시행에서는 1이니 홀수)
		 * 3-1. cnt[0]이 홀수면 -> idx = (0 + L) % N; <- 시계 방향으로 돌면 오름차순이니까
		 * 반시계의 경우: 1 ->(-1) N ->(-2) N-1 -> N-2 -> ... -> 2 
		 * 3-2. cnt[0]이 짝수면 -> idx = (0 + (N-L)) % N;
		 * 4. 반복  
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();	
				
		int sum = 0;		

		// 공 받은 횟수를 저장할 일차원 배열 생성
		int[] counts = new int[N];
		
		// 처음에 1번 자리에 앉은 사람이 공을 받으므로
		int idx = 0;
		counts[idx] = 1;		
		
		// M이 1이면 받는 순간 던지지 않고 종료되므로
		if(M == counts[idx]) {
			System.out.println(sum);
			return;
		}
				
		// 1번 자리에 앉은 사람이 공을 던지면 1은 홀수 -> 시계방향
		/* 만약 idx = N-1인 사람이 공을 받았고 L이 1이라면? => 0으로 가야됨!
		 * idx + L % N == 0 맞음
		 */			
		/* 만약 idx = N-1인 사람이 공을 받았고 L이 N-1이라면? => N-2로 가야됨!
		 * idx + L == N-1 + N - 1 == 2N - 2 == N + (N-2)
		 * idx + L % N == N-2 맞음!
		 */
		
		// sum은 공을 던지는 횟수!
		idx = idx + L;	
		sum++;
		// 공 던지고 받기 게임 스타트~!
		while(counts[0] < M) { // 아무 사람이나 공을 M번 받으면 종료되므로 0번을 기준으로 세팅
			// 공을 받는 시점
			counts[idx]++;			
						
			// 공을 받고나서 L번이면 종료			
			if(counts[idx] == M) break;
			
			// 공을 던진다
			// 홀수 케이스
			if(counts[idx] % 2 != 0) {
				idx = (idx + L) % N;				
			} else {
			//짝수 케이스
				/*
				 * 만약 idx = 0인 사람이 공을 받았고 L이 1이라면? => N-1로 가야됨!
				 * idx + (N-L) % N == N-1 맞음
				 * 만약 idx = 0인 사람이 공을 받았고 L이 N-1이라면? => 1로 가야됨!
				 * idx + (N-L) == 0 + N - N + 1 == 1 => 1 % N == 1맞음!
				 */
				idx = (idx + (N - L)) % N;
			}
			
			sum++;
			
		}
		
		System.out.println(sum);
		
	}

}
