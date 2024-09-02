import java.util.Arrays;
import java.util.Scanner;

public class boj_2527_huiju_미완 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		outer : for(int tc=0; tc<4; tc++) {	//총 4번 반복
			int[] fSqre = new int[4];	//first Square
			int[] sSqre = new int[4];	//second Square
			
			for(int i=0; i<fSqre.length; i++) {
				fSqre[i] = sc.nextInt();
			}
			for(int i=0; i<sSqre.length; i++) {
				sSqre[i] = sc.nextInt();
			}
			
			int w = fSqre[2] > sSqre[2] ? fSqre[2] : sSqre[2];	//두 직사각형의 범위 설정
			int h = fSqre[3] > sSqre[3] ? fSqre[2] : sSqre[2];
			
			int[][] field = new int[w][h];
			
			for(int r=fSqre[0]; r<=fSqre[2]; r++) {
				for(int c=fSqre[1]; c<=fSqre[3]; c++) {
					field[r][c] = 1;	//임의의 값으로 fSqre 영역을 채움.. 동시에 채울 수 있을 것 같ㄷ긴 한데 너무 졸려요이 ㅜㅜ
				}
			}
			for(int r=sSqre[0]; r<=sSqre[2]; r++) {
				for(int c=sSqre[1]; c<=sSqre[3]; c++) {
					if(field[r][c] == 1) {		//앞서 채운 사각형을 발견할 경우 a를 출력하고 종료
						System.out.println('a');
						continue outer;
					}
					
				}
			}
			//아무것도 겹치지 않을 경우 - p1이 x2보다 작을 떄 || q1이 y2보다 작을 때(단 1직사각형이 2직사각형보다 왼쪽에 있을 때 가능함? 흠,,)
			if(fSqre[0] < sSqre[0]) {
				if(fSqre[2] < sSqre[0] || fSqre[3] < sSqre[1]) {
					System.out.println('d');
					continue outer;
					
				}
			}else {	//fSqre[0] > sSqre[0]
				if(sSqre[2] < fSqre[0] || sSqre[3] < fSqre[1]) {}
				System.out.println('d');
				continue outer;
			}
			
			//한 점이 겹칠 경우
				for(int i=0; i<3; i=i+2) {	// 0, 2
					for(int j=1; j<4; j=j+2) {	// 1, 3
						
						if(sSqre[i] == fSqre[j]) {	//가로좌표 비교
							if(sSqre[i+1] == fSqre[j+1]) {
								System.out.println('c');
								continue outer;
								
							}
						}
						
					}
						
				}
			
			
		}
		
		
	}

}
