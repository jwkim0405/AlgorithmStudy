import java.util.Arrays;
import java.util.Scanner;

public class boj_3079_yuyoung {
	static int N;
	static long M, max;
	static int[] T;
	static long result = Long.MAX_VALUE;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 사람 수
		M = sc.nextInt(); // 입국심사대 갯수
		// 각 심사대에서 심사를 하는데 걸리는 시간
		T = new int[N];
		for(int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			max = Math.max(max, T[i]); // 가장 긴 심사시간
		}

		// 이진 탐색
		binarySearch();
		
		System.out.println(result);
	}

	private static void binarySearch() {
		long low = 0;
		long high = M * max; // 가장 오래 걸리는 심사대에 모든 사람이 심사를 받는 경우
		
		while (low <= high) {
			long mid = (low + high) / 2;

			long sum = 0; // mid 동안 처리할 수 있는 사람 수
			for (int time : T) {
				sum += mid / time; // mid 시간 내에 각 심사대에서 처리할 수 있는 사람 수
				if (sum >= M) { // 필요한 사람 수 M을 넘기면 더 계산할 필요 없음
					break;
				}
			}

			if (sum >= M) { // M명 이상 처리 가능하면
				result = Math.min(result, mid);
				high = mid - 1; // 더 작은 시간대에서 탐색
			} else { // M명 처리 불가능하면
				low = mid + 1; // 시간을 늘림
			}
		}
		
	}
}
