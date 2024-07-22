import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));	
		
		//!!!!!!!!!!!!!! 출력만 줄바꿈이 있고 입력은 그냥 한 줄로 들어온다!!
		// 1차원 배열로 저장하고 돌리면 되는 쉬운 문제였음..
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();		
		
		// 1차원 배열에 스위치 저장
		int[] switchArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			switchArr[i] = sc.nextInt();
		}
		
		int studentNum = sc.nextInt();
		
		// 학생 수 만큼 시행 반복
		for(int i = 0; i < studentNum; i++) {
			int gender = sc.nextInt();
			
			// case1. 남성일 경우 (gender == 1)
			if(gender == 1) {
				int target = sc.nextInt();				
				int switchControlNum = n / target;		
				
				for(int j = 1; j < switchControlNum + 1; j++) {
					int multiplied = target * j;					
					int targets = switchArr[multiplied - 1];
					
					if(targets == 0) switchArr[multiplied - 1] = 1;
						else switchArr[multiplied - 1] = 0; 					
				}
				
//				System.out.println("남성이 수행한 후의 스위치 상황은");
//				System.out.println(Arrays.toString(switchArr));
				
			} else { // case2. 여성일 경우 (gender == 2)
				int target = sc.nextInt();
				int targetSwitch = switchArr[target -1];
				
				
				if(target == 1 || target == n) { // target이 가장 끝 스위치면 즉시 종료
					if(targetSwitch == 0) switchArr[target - 1] = 1;
						else switchArr[target - 1] = 0;
					continue;
				}
				
				int cnt = 1;
out:			while (true) {
					
					int moveBack =switchArr[(target - 1) - cnt];
					int moveForward = switchArr[(target - 1) + cnt];
					int switchesBetween;
					
					// 대칭이 아닐 경우
					if(moveBack != moveForward) {
						// 그 중에서 이전 칸이나 다음 칸이 끝 칸일 경우 그 이전까지의 칸 다 바꾸고 종료
						// moveBack ~ moveForward 사이에 있는 스위치 개수 == (2 * (cnt-1)) + 1							
						switchesBetween  = (2 * (cnt-1)) + 1 ;
						
						for(int j = 0; j < switchesBetween; j++) {
							int targetIdxes = (target - 1) - (cnt-1) + j;	
							
							if(switchArr[targetIdxes] == 0) switchArr[targetIdxes] = 1;
								else switchArr[targetIdxes] = 0;						
						}
						
//						System.out.println("여성이 비대칭에서 수행한 후의 스위치 상황은");
//						System.out.println(Arrays.toString(switchArr));
						break out;
						
					} else { // 대칭일 경우
						// 그 중에서 이전 칸이나 다음 칸이 끝 칸일 경우 그 사이 칸 다 바꾸고 종료
						if((target - 1) - cnt == 0 || (target - 1) + cnt == n - 1) {
							// moveBack ~ moveForward 사이에 있는 스위치 개수 == 2*cnt + 1							
							switchesBetween  = (2 * cnt) + 1;
							
							for(int j = 0; j < switchesBetween; j++) {
								int targetIdxes = (target - 1) - cnt + j;
								
								if(switchArr[targetIdxes] == 0) switchArr[targetIdxes] = 1;
									else switchArr[targetIdxes] = 0;
							}		
							
//							System.out.println("여성이 대칭에서 수행한 후의 스위치 상황은");
//							System.out.println(Arrays.toString(switchArr));
							
							break out;
						
						}
						
						cnt++;	
						continue;
						
					}
					
				}			

			}			
			
			
			
		}
		
//		System.out.println("전부 수행한 후의 스위치 상황은");
//		System.out.println(Arrays.toString(switchArr));
		
		// 20개 단위로 줄 바꿈 해줘야됨
		for(int i = 0; i < n; i++) {
			if((i+1) % 20 == 0 || n % 20 != 0) {
				sb.append(switchArr[i] + "");
				sb.append("\n");
			} else if(i == n-1) {
				sb.append(switchArr[i] + "");
			} else {
				sb.append(switchArr[i] + " ");
			}
			
		}
		
		System.out.println(sb);
		
	}

}			
				
		/* 알고리즘 구상
		 * 핵심 조건: 학생 성별이 남성이냐 여성이냐
		 * 스위치 개수 n <= 100
		 * 스위치 한 줄의 최대 개수 20
		 * 
		 * case 1. 남성일 경우 (gender == 1)
		 * 받은 숫자 x일 때, 스위치를 조작할 수 있는 개수 == n / x (몫)
		 * 반복문(for)을 통해 스위치를 저장한 배열 속에서 x의 배수 - 1번째(인덱스) 스위치들을 확인
		 * 0이면 1로, 1이면 0으로
		 * 
		 * case 2. 여성일 경우 (gender == 2)
		 * 받은 숫자 y일 때, 스위치를 저장한 배열 속에서 y-1번째(인덱스) 위치로 이동
		 * y-1이 20으로 나누어 떨어지는지(y-1 % 20 == 0) 검사
		 * 반복문(while)을 통해 -방향과 +방향으로 1씩 탐색하며 스위치 상태 비교
		 * 더 이상 같지 않으면 즉시 종료,
		 * 탐색한 위치 중 하나가 20으로 나누어 떨어지면서 좌우대칭을 만족하면 cnt를 올리지 않고 종료
		 * 그 때 탐색한 모든 위치의 스위치의 상태를 0이면 1로, 1이면 0으로
		 * (반복문을 돌릴 때 반복 횟수를 저장할 값을 만들기 cnt = 1; -> 
		 * 이걸 활용해서 인덱스 조절해서 탐색하고 -> 
		 * 멈췄을 때 횟수를 확인해서 y-1-cnt ~ y-1+cnt 범위 사이에 있는 스위치들 상태 바꾸기)
		 */ 	
		
		
/*
		// 길이라 인덱스가 아님!!!
		int switchRows = n < 20 ? n : 20;
		// 20이면 1줄, 21이면 2줄, 99면 5줄, 100이면 5줄		
		int switchCols = ((n - 1) / 20) + 1;					
				
		// 23이면 (2, 1)
		// 스위치 상태 저장
		int[][] switchArr = new int[switchCols][switchRows];
out:	for(int i = 0; i < switchCols; i++) {
			for(int j = 0; j < switchRows; j++) {
				if(i == switchCols - 1 && j >= (n % 20)) {					
					break out;
				} 
				
				switchArr[i][j] = sc.nextInt();	
			}
		}		
		
		int studentNum = sc.nextInt();		
		
		// 학생 수 만큼 반복 시행
		for(int i = 0; i < studentNum; i++) {			
			int gender = sc.nextInt();			
			
			// case 1. 남자일 때
			if(gender == 1) {
				// 타겟 스위치 위치
				int targetSwitch = sc.nextInt();
				
				// 스위치 조작 개수
				int numberOfChangingSwitch = n / targetSwitch;	
				
				// 타겟 스위치 위치의 배수를 만들면서 스위치 상태 확인 후 변경!
				for(int j = 1; j < numberOfChangingSwitch + 1; j++) {
					int multiplied = j * targetSwitch;					
					// 스위치 위치를 rows, cols로 가공		
					// 인덱스라 위에 switchRows,Cols와는 다름!
					// 1(0, 0) 20(0, 19) 21(1, 0) 99(4, 18) 100(4, 19)
					int targetRows = ((multiplied - 1) / 20);
					int targetCols = multiplied <= 20 ? multiplied - 1 : (multiplied - 1) % 20;
																			
					// 0이면 1로 1이면 0으로
					if(switchArr[targetRows][targetCols] == 0) switchArr[targetRows][targetCols] = 1;	
						else if(switchArr[targetRows][targetCols] == 1) switchArr[targetRows][targetCols] = 0;
				}			
							
				System.out.println("남자의 결과는");
				System.out.println(Arrays.toString(switchArr[0]));
				
			} else if(gender == 2) { 
			//case 2. 여자일 때
				int targetSwitch = sc.nextInt(); 				
				
				// 1(0, 0) 20(0, 19) 21(1, 0) 99(4, 18) 100(4, 19)
				int targetRows = ((targetSwitch - 1) / 20);
				int targetCols = targetSwitch <= 20 ? targetSwitch - 1 : (targetSwitch - 1) % 20;				
								
				System.out.println("여자 동작 중");
				System.out.println(targetRows + ", " + targetCols);
				
				// target이 0번째거나 19번째 인덱스이면 종료
				if(targetCols == 0 || targetCols == 19) {
					if(switchArr[targetRows][targetCols] == 0) switchArr[targetRows][targetCols] = 1;
						else if(switchArr[targetRows][targetCols] == 1) switchArr[targetRows][targetCols] = 0;					
					continue;
				}								
				
				int cnt = 1;
				while (true) {
					int moveBack = switchArr[targetRows][targetCols - cnt];
					int moveForward = switchArr[targetRows][targetCols + cnt];
					
					// 좌우대칭이면
					if(moveBack == moveForward) {
						// targetCols - cnt == 0 || targetCols + cnt == 19일때
						// targetCols - cnt ~ targetCols + cnt 탐색 후 스위치 바꾸고 종료
						int sub = 2 * cnt + 1; // 정지했을 때의 좌우대칭인 전체 스위치 개수
						if(moveBack == 0 || moveForward == 19) {
							for(int j = 0; j < sub; j++) {
								if(switchArr[targetRows][targetCols - cnt + j] == 0) switchArr[targetRows][targetCols - cnt + j] = 1;
									else if(switchArr[targetRows][targetCols - cnt + j] == 1) switchArr[targetRows][targetCols - cnt + j] = 0;
							}			
							
							break;
						}
						
						cnt++;
						continue;
						
					} else { //좌우대칭이 아니면 target부터 targetCols - (cnt - 1) ~ targetCols + (cnt - 1)까지 탐색 후 스위치 바꾸고 종료 
						int sub = 2 * (cnt - 1) + 1; // 정지했을 때의 좌우대칭인 전체 스위치 개수
						for(int j = 0; j < sub; j++) {
							if(switchArr[targetRows][targetCols - (cnt - 1) + j] == 0) switchArr[targetRows][targetCols - (cnt - 1) + j] = 1;
								else if(switchArr[targetRows][targetCols - (cnt - 1) + j] == 1) switchArr[targetRows][targetCols - (cnt - 1) + j] = 0;
						}					
												
						break;
					}
					
				}
				
				
				
			}				
				
			
		}
		System.out.println("최종 스위치 상태는");
		System.out.println(Arrays.toString(switchArr[0]));		
		
		
out:	for(int i = 0; i < switchCols; i++) {
			for(int j = 0; j < switchRows; j++) {
				if(i == switchCols - 1 && j >= (n % 20)) {					
					break out;
				} 
				
				if(j < switchRows - 1) {				
					System.out.print(switchArr[i][j] + " ");					
				} else if(j == switchRows - 1 && i < switchCols - 1) {					
					System.out.print(switchArr[i][j]);
					System.out.println("");
				} else {
					System.out.print(switchArr[i][j]);
				}
					
			}
		}		

*/
