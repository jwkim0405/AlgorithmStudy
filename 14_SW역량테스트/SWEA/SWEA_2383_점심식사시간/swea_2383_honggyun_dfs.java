
import java.sql.Array;
import java.util.*;
import java.io.*;

public class Solution {
	static int N; // 방 한 변의 길이
	static int[][] map; // 방
	static ArrayList<int[]> pInfo; // 사람
	static int pCnt; // 사람 명수
	static int[][] stairs; // 계단
	static int[] matching; // 사람->계단 매칭
	static int result; // 결과를 저장할 변수


	static int recursive_cnt;
	// 어떤 계단 입구로 가는지 고르는 부분
	// idx: 사람 인덱스, 1부터 시작
	static void chooseStair(int idx) {
		// 기저 조건
		// 모든 사람을 다 보았을 때
		if(idx > pCnt) {
			recursive_cnt++;
			// 계단 입구 내려가기
			goingDownStair();
			return;
		}

		// 재귀 부분
		for(int sidx = 0; sidx <= 1; sidx++) {
			matching[idx] = sidx; // 0: 1번 계단을 고른다, 1: 2번 계단을 고른다.
			chooseStair(idx+1);
		}
	}
	
	// 계단 내려가는 부분
	static void goingDownStair() {
		PriorityQueue<Integer> stair1Entrance = new PriorityQueue<>(); // 1번 계단 입구
		PriorityQueue<Integer> stair1 = new PriorityQueue<>(); // 1번 계단 입구
		PriorityQueue<Integer> stair2Entrance = new PriorityQueue<>(); // 2번 계단 입구
		PriorityQueue<Integer> stair2 = new PriorityQueue<>(); // 1번 계단 입구

		// queue에 배정
		for(int idx = 1; idx <= pCnt; idx++) {
			if(matching[idx] == 0) stair1Entrance.add(calcMovingTime(idx, 0)); // 이동 시간 배정
			else stair2Entrance.add(calcMovingTime(idx, 1)); // 이동 시간 배정
		}

		// 정렬되어 있지 않더라도, binary heap으로 구성되어 있기 때문에 poll 할 때 반드시 요소 중 최솟값(최소힙)이 poll 됨

		int k1 = stairs[0][2];
		int k2 = stairs[1][2];

		int time = 0;

		// 입구가 전부 빌 때까지 반복 -> 계단 위로
		while(!stair1Entrance.isEmpty() || !stair2Entrance.isEmpty()) {
			// 계단 입구 큐가 비어있지 않고 계단 위 큐의 사이즈가 3 미만이면 입구 큐에서 위 큐로 옮기기(1분 기다려야하니 +1)
			if(!stair1Entrance.isEmpty() && stair1.size() < 3) stair1.add(stair1Entrance.poll() + 1);
			if(!stair2Entrance.isEmpty() && stair2.size() < 3) stair2.add(stair2Entrance.poll() + 1);

			// 계단 위 큐의 사이즈가 3이면
			if(!stair1Entrance.isEmpty() && stair1.size() == 3) {
				//  위 큐에서 1개를 뽑고 기다린 시간 계산(그 값 + 계단길이 - 입구 큐에서 들어가려는 값)
				int underStair = stair1.poll(); // 계단을 완전히 내려간 사람
				int finished = underStair + k1;
				if(time < finished) time = finished;

				int overStair = stair1Entrance.poll(); // 계단 입구에서 기다린 사람
				int waiting = finished - overStair;

				// 계단 입구에서 기다린 시간이 1분 보다 크면 진입 시간을 finished로 변경
				if(waiting > 1) overStair = finished;
				else overStair++; // 아니면 1분 기다리고 입장
				
				// 계단 위로 입장
				stair1.add(overStair);
			}

			// 계단 위 큐의 사이즈가 3이면
			if(!stair2Entrance.isEmpty() && stair2.size() == 3) {
				//  위 큐에서 1개를 뽑고 기다린 시간 계산(그 값 + 계단길이 - 입구 큐에서 들어가려는 값)
				int underStair = stair2.poll(); // 계단을 완전히 내려간 사람
				int finished = underStair + k2;
				if(time < finished) time = finished; // 계단 내려간 시간 갱신

				int overStair = stair2Entrance.poll(); // 계단 입구에서 기다린 사람
				int waiting = finished - overStair;

				// 계단 입구에서 기다린 시간이 1분 보다 크면 진입 시간을 finished로 변경
				if(waiting > 1) overStair = finished;
				else overStair += 1; // 아니면 1분 기다리고 입장

				// 계단 위로 입장
				stair2.add(overStair);
			}
		} // 계단 위 입장 끝

		// 입구 큐가 비었는데 위 큐가 남아있다면 위 큐의 사이즈-1만큼 반복 돌려서 다 비우고 맨 마지막 뽑은 시간 +K를 임시 총 시간 변수a에 저장
		if(!stair1.isEmpty()) {
			int size = stair1.size();
			for(int i = 0; i < size; i++) {
				int lastPeople = stair1.poll();
				if(i == size-1) {
					if(time < lastPeople + k1) time = lastPeople + k1;
				}
			}
		}

		if(!stair2.isEmpty()) {
			int size = stair2.size();
			for(int i = 0; i < size; i++) {
				int lastPeople = stair2.poll();
				if(i == size-1) {
					if(time < lastPeople + k2) time = lastPeople + k2;
				}
			}
		}

		// 최솟값 저장
		if(time < result) result = time;

	}

	// 계단 입구까지 가는 시간 계산
	static int calcMovingTime(int idx, int sidx) {
		int movingTime = Math.abs(pInfo.get(idx)[0] - stairs[sidx][0]) + Math.abs(pInfo.get(idx)[1] - stairs[sidx][1]);
		pInfo.get(idx)[2] = movingTime;
		return movingTime;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 1. T, N, map, queue 4개
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			pInfo = new ArrayList<>(); // 0: row, 1: col, 2: time to stair entrance
			stairs = new int[2][3];
			result = Integer.MAX_VALUE;
			
			Arrays.fill(stairs[0], -1); // 1번 계단 판별을 위해 초기화

			// 방 정보
			pCnt = 0; // 사람 명 수 세기
			pInfo.add(new int[3]);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					
					if(map[i][j] == 1) { // 사람 저장
						pCnt++;
						pInfo.add(new int[3]);
						pInfo.get(pCnt)[0] = i; // PR
						pInfo.get(pCnt)[1] = j; // PC
					} else if(map[i][j] > 1) { // 계단 저장
						if(stairs[0][0] == -1) { // 1번 계단
							stairs[0][0] = i;
							stairs[0][1] = j;
							stairs[0][2] = map[i][j];
						} else { // 2번 계단
							stairs[1][0] = i;
							stairs[1][1] = j;
							stairs[1][2] = map[i][j];
						}
					}
				}
			} // 방 정보 처리 끝

			matching = new int[pCnt+1];

			// 시뮬
			chooseStair(1);
			System.out.printf("#%d %d\n", tc, result);

		} //tc 종료	
	} // main 종료
}
