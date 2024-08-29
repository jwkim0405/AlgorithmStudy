import java.util.Arrays;
import java.util.Scanner;

public class boj_11404_huiju {
	static int n;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		int m = sc.nextInt();
		int[][] info = new int[m][3];
		map = new int[n+1][n+1];
		int INF = 9900001; // 100000 * (100-1);	//오버플로우 발생 우려... MAX_VALUE 안씀
		
		for(int i=0; i<m; i++) {
			info[i][0] = sc.nextInt();	//시작도시 a
			info[i][1] = sc.nextInt();	//도착도시 b
			info[i][2] = sc.nextInt();	//비용 c
			
		}
		
		
//		System.out.println(Arrays.deepToString(info));
		//------------------------------------
		
		//map배열 초기화 - 나자신은 0, 그외 INF
		for(int i=1; i<=n; i++) { 
			for(int j=0; j<=n; j++) {
				if(i == j) continue;
				else map[i][j] = INF;
				
			}
		}

		//map배열에 주어진 값 대입 -> 동일한 경로일 경우 비용이 최소인 것으로 업데이트
		for(int i=0; i<m; i++) {	//아헷갈려,, 수정하고싶은데 졸류
			map[info[i][0]][info[i][1]] 
					= Math.min(map[info[i][0]][info[i][1]], info[i][2]);
		}

		shortestPath(n);

		for(int i=1; i<=n; i++) {	//바뀌지 않은 값(INF)을 0으로 바꿔준다
			for(int j=1; j<=n; j++) {
				if(map[i][j] == INF) 
					map[i][j] = 0;
				System.out.print(map[i][j] + " ");	//출력
			}
			System.out.println();
		}
		

	}

	static void shortestPath(int n) {

			for(int k=1; k<=n; k++) { // 경유지 			
				for(int i=1; i<=n; i++) { // 출발지				
				if(i==k) continue;				
				for(int j=1; j<=n; j++) { // 도착지 					
					if(i==j || j==k) continue;					
					if(map[i][j] > map[i][k]+ map[k][j]) {	//경유지를 거친 길이가 더 짧을 경우 업데이트
						map[i][j] = map[i][k] + map[k][j];					
					}				
				}			
			}						
		}
	}
}
