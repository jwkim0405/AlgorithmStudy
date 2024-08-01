import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 컵홀더 문제
		Scanner sc = new Scanner(System.in);
		
		//pseudo code		
		int N = sc.nextInt();
		String seat = sc.next();
		  
		// S 개수 L 개수 셀 변수들
		int cntS = 0;
		int cntL = 0;
		  
		char[] seats = new char[N];	

		for(int i = 0; i < N; i++) {
		  seats[i] = seat.charAt(i);
			  
		  if(seats[i] == 'S') cntS++;
			  else cntL++;
		}

		// 뭔가 모를 논리 예외 발생!
		if(cntS + cntL != N) {
			System.out.println("EMERGENCY!!!");  
		}
  	
		// 컵홀더랑 같이 저장할 새 배열 생성
		char[] seatsWithCupHolders = new char[(cntS + (cntL/2) + 1) + N];		
		
		int cnt = seats.length-1;
		
		/*
		 * seats, cnt는 문제 없음 -> 출력이 이상하니 for문 안에서 뭔가 로직 예외가 있을 것
		 * -> 반복문 범위 설정 실수!!!
		 */
		
		int cntCupHolders = 0; 
		//역방향 순회로 컵홀더 넣기
		for(int i = seatsWithCupHolders.length-1; i > 0; i--) {
			// 처음에 * 넣기
			if(i == seatsWithCupHolders.length-1) {
				seatsWithCupHolders[i] = '*';
				cntCupHolders++;
				continue;
			}		  
					
			
			if(seats[cnt] == 'L') { //L일 경우
				if(seatsWithCupHolders[i] != '\u0000') { // 이미 *을 박아놓은 곳이라면					
					continue;
				}
				
				seatsWithCupHolders[i] = 'L';
				
				if(seatsWithCupHolders[i-1] == '\u0000')  { // 커플석의 첫 좌석을 탐색하는 중이라면
					seatsWithCupHolders[i-2] = '*';	
					cntCupHolders++;
				} else { // 커플석의 두 번째 좌석을 탐색하는 중이라면
					cnt--;
					continue; // 첫 좌석에서 *을 남겨서 			
				}
				
			} else if(seats[cnt] == 'S') { // S일 경우
				if(seatsWithCupHolders[i] != '\u0000') { // 이미 *을 박아놓은 곳이라면
					continue;
				}
				
				seatsWithCupHolders[i] = 'S';
				seatsWithCupHolders[i-1] = '*'; 
				cntCupHolders++;
			}			
			
			cnt--;
			
		}	
		
		
		if(cntL == 0) {
			System.out.println(cntCupHolders - 1);
		} else {
			System.out.println(cntCupHolders);
		}

	}

}
