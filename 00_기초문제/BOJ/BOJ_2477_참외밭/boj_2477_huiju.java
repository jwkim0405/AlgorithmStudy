//import java.util.Arrays;
import java.util.Scanner;

public class boj_2477_huiju {

	public static void main(String[] args) {
		//반례?

		Scanner sc = new Scanner(System.in);
		int melon = sc.nextInt();			//참외의 수
		int[][] field = new int[6][2]; 
		int[][] tmpField = new int[6][2];	//방향이 두 개씩 있는 요소들을 저장할 배열
		int[] tArr = new int[2];			//방향이 하나인 요소들의 1차원배열 좌표를 저장할 배열
		int bSqre = 1;					//방향이 하나인 요소의 큰 사각형 넓이를 저장할 변수
		int sSqre = 1;					//방향이 두개인 요소의 작은 사각형 넓이를 저장할 변수
		
		for(int r=0; r<6; r++)		//입력값을 배열로 저장
			for(int c=0; c<2; c++)	//r : 방향, c : 길이
				field[r][c] = sc.nextInt();


		//방향이 두 개씩 있는 값 찾기
		for(int i=0; i<field.length; i++) {
			for(int j=i+1; j<field.length; j++) {
				if(field[i][0] == field[j][0]) {	//방향 값이 같은 요소를 찾을 경우
					tmpField[i][0] = field[i][0];	//각각의 요소들을 임시배열에 저장
					tmpField[i][1] = field[i][1];
					tmpField[j][0] = field[j][0];
					tmpField[j][1] = field[j][1];
				}
			}
		}
		
		//방향이 하나만 있는 값의 큰 사각형 찾기
		int idx = 0;
		for(int t=0; t<tmpField.length; t++) {
			if(tmpField[t][0] == 0) {	//방향이 하나인 요소를 찾을 경우
				bSqre *= field[t][1];	//큰 사각형의 넓이를 구한다.
				tArr[idx++] = t;			//해당 요소의 r좌표를 저장한다.

			}
		}
		
		//방향이 두 개인 값의 작은 사각형 찾기
		//총 2번 실행한다.
		//요소의 인덱스가 연속되지 않을 경우를 고려하여 
		//%6으로 배열 범위를 넘어가지 않는 선에서 1회성 순환을 한다
		for(int t=2; t<4; t++) 
			sSqre *= tmpField[(tArr[1]+t)%6][1];
		
		
		System.out.println((bSqre - sSqre) * melon);	//답 출력
	}

}


//7
//1 60
//3 20
//1 100
//4 50
//2 160
//3 30




