import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class swea_7733_huiju {
	static int n;		//치즈 한 변의 길이
	static int max;	//가장 많은 치즈덩어리가 생기는 날의 덩어리 수
	static int maxEle;	//치즈의 2차원 배열 요소 중 가장 큰 요소를 저장할 변수
	static int cnt;		//덩어리를 1개 찾을 때마다 1씩 누적하는 변수
	
	static int[][] arr;		//치즈 2차원 배열
	static boolean[][] eaten;	//치즈배열이 0인지 확인할 배열
	static int[] dc = {0, 0, -1, 1};		//델타배열 가로 - 상하좌우
	static int[] dr = {-1, 1, 0, 0};		//델타배열 세로
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("7733_input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {	//테케 수만큼 반복
			
			max = 1;	//가장 초기의 치즈 덩어리 개수는 1개이다
			maxEle = 0;
			n = sc.nextInt();
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {	//원본배열 저장
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
					maxEle = Math.max(maxEle, arr[i][j]);
				}
			}			
			//---------------------------------------
			for(int day=1; day<=maxEle; day++) {	//가장 큰 요소의 크기만큼 반복
				
				cnt = 0;
				eaten = new boolean[n][n];	//하루를 지나칠 때마다 초기화
				
				//오늘의 날짜와 이전 날짜에 해당하는 eaten 배열의 요소(이미 먹은 요소)를 true로 바꾼다
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						
						if(arr[i][j] <= day) {	 
							eaten[i][j] = true;	
						}
						
					}
				}
				//-----
				//치즈 덩어리의 개수 구하기
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						
						//아직 먹히지 않은(false로 저장된) 치즈의 경우
						if(!eaten[i][j]) {
							//치즈 덩어리의 개수를 1 더하고
							cnt++;	
							//덩어리의 경계를 찾아 해당 덩어리의 모든 요소를 true로 만들기
							dfs(i, j);	
						}
						
					}
				}
				
				//기존의 최대 덩어리 개수와 현재 날짜의 덩어리 개수 비교
				max = Math.max(max, cnt);	
				
			}//day > maxEle -> 빠져나옴
			
			System.out.printf("#%d %d\n",tc, max);
			
		}

	}

	//덩어리의 경계를 찾는 메서드
	private static void dfs(int i, int j) {

		for(int d=0; d<dr.length; d++) {	//델타배열의 인덱스를 한 칸씩 옮긴다
			
			int ir = i + dr[d];
			int ic = j + dc[d];
			
			//원본 치즈 배열의 범위에서 벗어나지 않을 때
			if(0 <= ir && ir < n && 0 <= ic && ic < n) {

				//요정이 이미 먹은 치즈의 경우(true) continue
				if(eaten[ir][ic]) continue;	
				
				//먹지 않은 치즈의 덩어리를 true로 바꿔준다
				eaten[ir][ic] = true;	
				//위에서 true로 바꾼 치즈덩어리를 중심으로 다시 델타탐색을 시작한다
				dfs(ir, ic);	

			}
			
			// => 종료 시 해당 덩어리의 eaten 배열은 전부 true로 바뀌었기 때문에
			//	  다음 덩어리를 찾으러 갈 때 이 덩어리는 조사하지 않을 수 있음 
		}
		
	}


}
