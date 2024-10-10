import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int endX;
    static int endY;
    static int ans;
    //위, 오른쪽, 아래, 왼쪽
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] map;
    static int N;
    static int C;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
        //초기값 입력
            N = sc.nextInt();
            C = sc.nextInt();
            map = new char[N][N];
            visited = new boolean[N][N];
            int startX = 0;
            int startY = 0;
            endX = 0;
            endY = 0;
            ans = Integer.MAX_VALUE;
            for(int i = 0; i<N; i++){
                String str = sc.next();
                for(int j = 0; j<N; j++){
                    map[i][j]=str.charAt(j);
                    if(map[i][j]=='X'){
                        startX=i;
                        startY=j;
                    } else if (map[i][j]=='Y'){
                        endX = i;
                        endY = j;
                    }
                }
            }
            
            visited[startX][startY]=true;
            dfs(startX, startY, 0, 0, 0);

            //도달하지 못하면 -1 출력
            if(ans==Integer.MAX_VALUE) ans=-1;
            
            System.out.println("#"+test_case+" "+ans);
		}
	}
  //cut은 지금까지 잘려나간 나무 개수
  //count는 지금까지 온 길의 길이
  //direction은 이전 이동 방향을 저장한 것
  static void dfs(int x, int y, int cut, int count, int direction){
    //도착점에 가면 기존의 정답과 이 길의 길이를 비교해서 작은 것 저장
	  if(x==endX && y ==endY){
		  ans = Math.min(ans, count);
		  return;
	  }
	  
    // 네 방향을 돌면서
	  for(int i = 0; i<4; i++){
		  int nx = x+dx[i];
		  int ny = y+dy[i];
      //범위 안이고
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
      //아직 방문하지 않았고
			if(visited[nx][ny]) continue;
      //더이상 나무를 못자르는데 나무인 경우가 아니면
		  if(cut==C && map[nx][ny]=='T') continue;
			  
      //방문처리하고
			  visited[nx][ny]=true;
        //몇번 돌아햐나는지 결정
        int rotation = Math.min((direction-i+4)%4, 4-(direction-i+4)%4);
			  
        // 나무면 cut 하나 올리고 rotation만큼 돌고 한칸 가고
        if(map[nx][ny]=='T') dfs(nx, ny, cut+1, count+rotation+1, i);
        //나무가 아니면 cut 안늘리고 rotation만큼 돌고 한 칸 가고
			  else dfs(nx, ny, cut, count+rotation+1, i);
			  visited[nx][ny]=false;
	  }
  }
}