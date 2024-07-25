import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 블랙잭 문제
		
		/*
		 * << 문제 요약 >>
		 * N장의 카드를 모두 숫자가 보이도록 바닥에 놓음 -> 3개의 숫자가 생김
		 * 임의의 숫자 M이 주어짐
		 * N장의 카드 중 3장을 고름
		 * -> 그 합이 M을 넘지 않으면서 가장 가까운 수여야 함
		 * 
		 * 그 합을 구하기
		 * 
		 * << 입력 & 출력 >>
		 * 첫 줄에 3<=N<=100과 10<=M<=30만
		 * 둘째 줄에 N장의 카드에 쓰여있는 수가 주어짐 (각각 <= 10만)
		 * 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우의 수만 주어짐
		 * 
		 * << 알고리즘 생각 >>

		 * 아마 풀이는 가능한 모든 조합을 구해서 그 합이 M을 넘지 않는 경우 중 가장 큰 수 구하기.
		 * 이걸 어떻게 코딩으로 구현한담?
		 * 
		 * 1. 둘째 줄에 들어오는, 카드에 쓰여 있는 수들을 일차원 배열에 저장
		 * 2. 3중 for문으로 돌려서 해결..?
		 * 첫째 0 i 
		 * 둘째 1 j>i
		 * 셋째 2 3 4 k>j
		 * 3. 가장 바깥 for문보다도 밖에 sum 생성
		 * for문 돌면서 if 배열.length == 3 이면 배열 값들 더하고 sum이랑 비교해서 큰 값 저장 << 3번째 for문에서 자동적으로 3자리가 채워져서 저장할 필요x
		 * if 배열 값들 더한 값이 m 초과가 되면 종료하고 sum값 출력
		 * 
		 * << 구현 >>
		 * int[] cardList = new int[N];
 		 * for(int i = 0; i < N; i++) cardList[i] = sc.nextInt();
		 * 
		 * int[] resultList = new int[3];
		 * int sum = 0;
		 * 
		 * for(int i = 0; i < N; i++) {
		 * 	for(int j = i+1; j < N; j++ {
		 * 		for(int k = j+1; k < N; k++ {
		 *			int tmpSum = [i] + [j] + [k];
		 *			if(tmpSum > sum) sum = tmpSum; 			
					이 for문에서 3자리가 참!
		 * 		}
		 * 		
		 * 
		 * 	}
		 * 
		 * }
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] cardList = new int[N];
		
		// N장의 카드 숫자 저장
		for(int i = 0; i < N; i++) {
			cardList[i] = sc.nextInt();
		}
		
		// 최종 합을 저장할 변수 생성
		int sum = 0;
		
out:	for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					int tmpSum = cardList[i] + cardList[j] + cardList[k];
					// 합이 M을 넘으면 continue
					if(tmpSum > M) continue;		
					// 합이 sum보다 크다면 저장
					if(tmpSum > sum) sum = tmpSum;
					
				}
			}
			
		}

		System.out.println(sum);
		
	}

}
