import java.util.Scanner;
//조합
public class swea_1494_huiju {
	static int n;				//지렁이 수
	static int[][] worms;		//지렁이 좌표를 저장할 배열
	static boolean[] visited;	//방문체크할 배열
	static long min;//최솟값을 업데이트할 변수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {	//테케수만큼 반복
			
			n = sc.nextInt();
			min = Long.MAX_VALUE;
			visited = new boolean[n];
			worms = new int[n][2];
			
			for(int i=0; i<n; i++) {
				worms[i][0] = sc.nextInt();	//x
				worms[i][1] = sc.nextInt();	//y
			}
			
			backTracking(0,0);
					
			System.out.printf("#%d %d\n",tc,min);
			
		}//테케수만큼 반복 끝
		
	}

	private static void backTracking(int idx, int cnt) {

		if(cnt == n/2) {	//지렁이 수를 반절만큼 선택했을 때
			long x = 0;		//각각의 벡터를 더해줄 변수들
			long y = 0;
			
			for(int i=0; i<n; i++) {	//모든 지렁이를 순회
				if(visited[i]) {		//방문했을 경우
					x += worms[i][0];	//벡터들을 더한다
					y += worms[i][1];
				}else{					//방문하지 않았을 경우
					x -= worms[i][0];	//벡터들을 뺀다
					y -= worms[i][1];
				}
			}
			
			min = Math.min(min, x*x + y*y);	//벡터의 크기 업데이트
			return;
		}
		
		for(int i = idx; i < n; i++) {  // 수정된 부분: idx 대신 i 사용
			if(!visited[i]) {				// 아직 방문하지 않은 경우
				visited[i] = true;			// 선택 처리
				backTracking(i + 1, cnt + 1);	// 수정된 부분: idx + 1 -> i + 1로 수정
				visited[i] = false;			// 선택 해제 후 초기화
			}
		}
			
		
	}

}
