import java.util.Arrays;
import java.util.Scanner;

public class boj_17144_huiju {
	static int r;
	static int c;
	static int apIdx;
	static int[][] tmp;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();	//2차원배열 가로
		c = sc.nextInt();	//2차원배열 세로
		int t = sc.nextInt();	//시간(초)
		apIdx = 0;					//air purifier..의 r인덱스
		int[][] arr = new int[r][c];	//원본 배열
		tmp = new int[r][c];	//임시 배열

		int[] dr = {-1, 1, 0, 0};	//상하좌우
		int[] dc = {0, 0, -1, 1};	//상하좌우
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				arr[i][j] = sc.nextInt();
				//공청기의 인덱스 업데이트
				if(arr[i][j] == -1 && apIdx == 0) apIdx = i;
			}
		}
		for(int i=0; i<r; i++) {
			tmp[i] = arr[i].clone();
		}
		
		//---------------------------------------

		for(int time=0; time<t; time++) {	//주어진 시간만큼 반복
			//원본배열 사방 탐색
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(arr[i][j] == -1) continue;
					int dust= arr[i][j]/5;	//빼줄 미세먼지
					for(int k=0; k<4; k++) {	//델타배열 길이만큼 반복
						int ir = i + dr[k];
						int jc = j + dc[k];
						//배열을 벗어날 경우 
						if(ir < 0 || jc < 0 || ir >= r || jc >= c || arr[ir][jc] == -1) continue;
						
						//미세먼지 확산
						tmp[ir][jc] += dust ;
						tmp[i][j] = tmp[i][j] - dust;

					}//델타배열 길이만큼 반복 끝
				}	
			}//원본배열 사방 탐색 끝
			
			//-----------여기까지 아마 완벽함,,,----------------
			
			
//			//배열 밖으로 벗어날 수 있는 요소 저장
			int point1 = tmp[0][0];
			int point2 = tmp[0][c-1];
			int point3 = tmp[r-1][0];
			int point4 = tmp[r-1][c-1];
			int point5 = tmp[apIdx][c-1];
			int point6 = tmp[apIdx+1][c-1];

			System.out.println("tmp1");
			for(int i=0; i<r; i++) {
				System.out.println(Arrays.toString(tmp[i]));
			}
			pushLR(apIdx);
			pushLR(apIdx+1);
			pushRL(0);
			pushRL(r-1);
			pushUD(r-1, c-1);
			
			System.out.println("tmp2");
			for(int i=0; i<r; i++) {
				System.out.println(Arrays.toString(tmp[i]));
			}
			
			tmp[apIdx-1][0] = -1;
			tmp[apIdx+2][0] = -1;
		}//주어진 시간만큼 반복 끝
		
		
		
		
	}//main
	
	static void pushLR(int row) {	//왼 -> 오
		for(int i=r; i>=1; i--) {
			tmp[row][i] = tmp[row][i-1];
		}
		tmp[apIdx][1] = tmp[apIdx+1][1] = 0;	//미세먼지 제거
	}
	
	static void pushRL(int row) {	//오 -> 왼
		for(int i=0; i<r; i++) {
			tmp[row][i] = tmp[row][i+1];
		}
	}
	
	static void pushUD(int row, int col) {	//위(시작점) -> 아래	얘부터 이상함 ,,
		for(int i=row-1; i<apIdx+1; i--) {
			tmp[i][col] = tmp[i-1][col]; 
		}
	}
	static void pushDU(int col) {	//아래 -> 위 이거아닌것같은데,,
		
	}

}
