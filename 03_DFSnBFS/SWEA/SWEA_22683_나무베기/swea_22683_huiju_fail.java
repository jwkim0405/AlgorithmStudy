import java.util.*;

class swea_22683_나무베기 {
	static int n, k;
	static char[][] field;
	static boolean[][] visited;
	static int startR, startC, endR, endC;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	//현재 위치 + 부속물?
	static class Location{
		int r, c, dir, operCnt, treeCnt;
		//r, c : 위치
		//dir : 바라보고 있는 방향
		//operCnt : 현재까지의 명령 개수
		//treeCnt : 벨 수 있는 남은 나무 수

		Location(int r, int c, int dir, int operCnt, int treeCnt){
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.operCnt = operCnt;
			this.treeCnt = treeCnt;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {

			n = sc.nextInt();
			k = sc.nextInt();
			field = new char[n][n];
			visited = new boolean[n][n];

			for(int i=0; i<n; i++) {
				field[i] = sc.next().toCharArray();
				for(int j=0; j<n; j++) {
					if(field[i][j] == 'X') {
						startR = i;
						startC = j;
					}else if(field[i][j] == 'Y') {
						endR = i;
						endC = j;
					}
				}
			}//입력 끝
			
			//출력
			System.out.printf("#%d %d\n", tc, bfs(startR, startC));
			

		}//테케 개수만큼 반복 끝
	}

	private static int bfs(int startR, int startC) {

		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(startR, startC, 0, 0, k));
		visited[startR][startC] = true;

		while(!q.isEmpty()) {
			
			Location l = q.poll();
			
			//델타배열 길이만큼 반복
			for(int i=0; i<4; i++) {
				int r = l.r + dr[i];
				int c = l.c + dc[i];

				//field 범위 안 && 방문체크x 
				if(r >= 0 && c >= 0 && r < n && c < n && !visited[r][c]) {
					visited[r][c] = true;
					//T(나무)일 경우 && 벨 수 있는 나무 수가 남아있을 경우
					if(field[r][c] == 'T' && l.treeCnt > 0) {
						System.out.println("나무");

						//현재 바라보는 방향이 전진하려는 방향과 동일할 경우
						if(l.dir == i) {
							q.offer(new Location(r, c, l.dir, l.operCnt+1, l.treeCnt-1));
							System.out.println("동일");}
						//현재 바라보는 방향이 전진하려는 방향과 동일하지 않을 경우
						else if(Math.abs(l.dir - i) == 1) {
							q.offer(new Location(r, c, i, l.operCnt+2, l.treeCnt-1));
						System.out.println("다름");}
						else if(Math.abs(l.dir - i) == 2) {
							q.offer(new Location(r, c, i, l.operCnt+3, l.treeCnt-1));
							System.out.println("다름");}

					}//'T'일 때

					//G(땅)일 경우
					else if(field[r][c] == 'G') {
						System.out.println("땅");
						visited[r][c] = true;

						//현재 바라보는 방향이 전진하려는 방향과 동일할 경우
						if(l.dir == i) {
							q.offer(new Location(r, c, l.dir, l.operCnt+1, l.treeCnt));
							System.out.println("동일");}
						//현재 바라보는 방향이 전진하려는 방향과 동일하지 않을 경우
						else {
							q.offer(new Location(r, c, i, l.operCnt+2, l.treeCnt));
							System.out.println("다름");}

					}//'G'일 때

					//Y(도착점)일 경우
					else if(field[r][c] == 'Y') {
						System.out.println("도착점");
						
						if(l.dir == i)  return l.operCnt;
						//현재 바라보는 방향이 전진하려는 방향과 동일하지 않을 경우
						else return l.operCnt+1;
					}
					
				}
			}//델타탐색 끝
		}//while 끝

		return -1;

	}//bfs 끝

}
//1
//5 2
//GGTGG
//GXTTG
//GGTTG
//GGTYG
//GGTGG