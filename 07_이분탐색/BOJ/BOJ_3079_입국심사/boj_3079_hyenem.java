import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		int[] arr = new int[N];
		
		int mintime = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			mintime = Math.min(mintime, arr[i]);
		}
		
		//시간은 적어도 이거보단 적게걸린다 : 가장 빨리 끝나는 검색대만을 이용해 다 통과하는 경우
		long right = mintime * M;
		long left = 1;
		long mid = 0;
		long ans = right;
		//이분탐색을 하면서 left와 right를 기준으로
		//왼쪽에 최소 시간인지 오른쪽에 최소 시간인지 확인한
		while(left<=right) {
			mid = (left+right)/2;
			long count = 0;
			// mid 시간동안 각 검색대에 몇 명이 통과할 수 있는지
			// mid를 각 검색대에서 걸리는 시간으로 나눈 
			for(int i = 0; i<N; i++) {
				count += mid/arr[i];
			}
			
			// M명 이상이 통과하면 기존 범위의 왼쪽을 봄
			// 아 그전에 정답에 mid를 저장
			if(count>=M) {
				ans = mid;
				right = mid-1;
			} else { //M명이 다 통과 못하면 범위 중 오른쪽을 
				left = mid+1;
			}
		}
		System.out.println(ans);
	}
}

