import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	// 리모컨 버튼은 0~9와 +, -.
	// +를 누르면 보고 있는 채널에서 +1
	// -를 누르면 보고 있는 채널에서 -1
		// 채널 0에서 -를 누르면 채널 변하지 않음
	// 채널은 무한대만큼 있음
	// 현재 채널 100
	
	// 첫째줄 이동하려고 하는 채널 target = N (0<= N <= 500,000)
	// 둘째줄 고장난 버튼의 개수 M (0 <= M <= 10)
	// 셋째 줄에 고장난 버튼이 주어짐. 중복 x
	
	// N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지?
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		Scanner sc = new Scanner(System.in);
		
			int target = sc.nextInt();
			
			// 예외 처리: target == 현재 채널 답으로 0 도출하고 함수 종료
			if(target == 100) {
				System.out.println(0);
				return;
			}
					
			// 최종 답 저장할 변수 생성
			int sum = 0;				
			
			int cntBroken = sc.nextInt();
			
			// 예외 처리: cntBroken == 0 이면 타겟 채널 길이 개수만 구해서 반환
			if(cntBroken == 0) {
				sum = (int) (Math.log10(target) + 1);
				System.out.println(sum);
				return;
			} else if(cntBroken == 10) { // 모든 버튼이 고장이면 abs(target - 100) 구해서 반환
				sum = Math.abs(target - 100);
				System.out.println(sum);
				return;
			}
			
			// 고장난 버튼 저장
			int[] brokenButtons = new int[cntBroken];														
			for(int i = 0; i < cntBroken; i++) {
				brokenButtons[i] = sc.nextInt();
			}				
			
			// -------------------- 구현 -------------------------
			
			// 1. target과 가장 가까운 가능한 채널 = nearest를 누른다 (자릿수 세야됨)
			// 1-a. available button 배열 저장
			int[] ableButtons = new int[(10 - cntBroken)];
			
			// 고장난거면 -> isBroken true로 바꿔서 continue로 쳐내고 나머지만 넣기!
			// 가능한 버튼 앞에 고장난 버튼 개수를 세서 가능한 버튼을 정확한 인덱스에 넣을 수 있게 조정
			int countBs = 0;
			for(int i = 0; i < 10; i++) {
				boolean isBroken = false;
				
				for(int j = 0; j < cntBroken; j++) {
					if (i != brokenButtons[j]) {
						continue;
					} else if (i == brokenButtons[j]){
						isBroken = true;
						countBs++;						
					}					
				}			
				
				if(isBroken) {
					continue;
				} else {	
					ableButtons[(i - countBs)] = i;			
				}			
				
			}						
			
			// target 값을 가공할 변수 생성
			int targetNumber = target;			
	
			// 1-b. targetNumber가 tenDigit(10의 그 자릿수 제곱)의 배수가 아닌 경우
			int nearest = 0;	
			int digits = targetNumber == 0 ? 1 : (int) (Math.log10(targetNumber) + 1); //자릿수
			int digitNumber = digits; // 자릿수 가공할 변수
			
			// 최소값들을 저장할 변수 생성
			int absMin = targetNumber;
			int tmpMin = 0;
			
out:		for (int k = 0; k < digits; k++) {
				int tenDigit = (int) Math.pow(10, (digitNumber - 1));	
				int digitCut = targetNumber / tenDigit; // 가장 높은 자릿수 값
							
				// 1-b를 두 가지로 쪼개서 탐색
				
				
				// 1-b-1.a digitCut이 ableButton에 있으면 
				boolean isAble = false;
				for(int i = 0; i < ableButtons.length; i++) {
					if(digitCut == ableButtons[i]) {
						isAble = true;
						// 값 저장하고 targetNumber에서 ableButtons[i] * tenDigit만큼 빼주기
						nearest += ableButtons[i] * tenDigit;
						targetNumber -= ableButtons[i] * tenDigit;
						digitNumber -= 1;													
						
						// targetNumber가 tenDigit의 배수였어서 빼고 났더니 0이 된 경우 nearest 확정
						// 이 아니었다! 제일 높은게 able, tenDigit 배수인데 0이 없으면 안댐!
						if(targetNumber == 0 && digitNumber > 1) {
							int tenDivider;
							for(int m = 1; m < (digitNumber + 1); m++) {
								tenDivider = (int) Math.pow(10, m);									
								nearest += ableButtons[0] * (tenDigit / tenDivider);								
							}
							break out;
						}	
												
					} else {
						isAble = false;
					}
					
				}		
				
				

				// 1-b-1.b digitCut이 ableButton에 없으면 전체 값의 차의 절대값 비교
				
				// 예외 처리: 1000의 자리수 비교에서 0과 1이 고장일 때, target보다 낮은 근삿값과 높은 근삿값의 거리가 같을 때
				// e.g. 1555(0,1,9고장) <- 2222와 888은 똑같이 667거리 차이지만 누르는 버튼 횟수는 888이 1개 더 낮음
				boolean isOutlier = brokenButtons[0] == 0 
									&& brokenButtons[1] == 1 
									&& digitCut == 1; 									
				
				for(int j = 0; j < ableButtons.length; j++) {
					if(!isAble) {
						
						int tmp = 0;
						int tenDivider = 0;

						if(isOutlier && digitNumber > 1) {						
							
							for(int m = 1; m < digitNumber; m++) {
								tenDivider = (int) Math.pow(10, m);
								tmp += ableButtons[(10 - cntBroken) - 1] * (tenDigit / tenDivider);
							}
							
							int sub = Math.abs(targetNumber - tmp);
							if (sub < absMin) {
								absMin = sub;
								tmpMin = tmp;
							}
						}
						
						// 가장 높은 자릿수 값보다 ableButtons[j]가 작을 때
						if(ableButtons[j] < digitCut) {							
							tmp = ableButtons[j] * tenDigit;
							
							if(digitNumber > 1) {
								for(int m = 1; m < digitNumber; m++) {
									tenDivider = (int) Math.pow(10, m);
									tmp += ableButtons[(10 - cntBroken) - 1] * (tenDigit / tenDivider);									
								}
							}
							
							int sub = Math.abs(targetNumber - tmp);							
							if(sub < absMin) { 
								absMin = sub;								
								tmpMin = tmp;						
							}
							
							
						} else { // 가장 높은 자릿수 값보다 ableButtons[j]가 클 때
							tmp = ableButtons[j] * tenDigit;
							
							if( digitNumber > 1) {
								for(int m = 1; m < digitNumber; m++) {
									tenDivider = (int) Math.pow(10, m);
									tmp += ableButtons[0] * (tenDigit / tenDivider);
								}
							}
							
							int sub = Math.abs(targetNumber - tmp);
							if(sub < absMin) { 
								absMin = sub;
								tmpMin = tmp;
							}
							
						}					
											
					}
				}			
				

				
			}								
			
			
			// 이제 nearest에, target에 가장 가까운 근삿값이 저장돼있음!

			nearest += tmpMin;

			// sum에 nearest의 자릿수를 더하고
			int digitOfNearest = nearest == 0 ? 1 : (int) (Math.log10(nearest) + 1);				
					
			sum += digitOfNearest;
			
			// abs(target - nearest)를 구해서 sum에 더하면 끝!
			int finalSub = Math.abs(target - nearest);
			sum += finalSub;		
			System.out.println("");
			System.out.println(sum);		
	}
	
	


}					
						
			
//			for(int i = 0; i < digits; i++) {				
//
//
//				
//				
//				for (int j = 0; j < ableButtons.length; j++) {
//					if(digitCut == ableButtons[j]) { // 가장 높은 자릿수가 ableButton에 있으면 -> 각 자릿수로 비교	
//						
//					} else { // brokenButton에 있으면 -> tenDigit 곱해서 절대값으로 비교
//						
//					}
//				}
//	
							
				
				
				// 1-b-2. 반복문 돌려서 가능한 버튼의 각 숫자들의 차의 절대값을 비교
				// 1-b-2-a. 첫 저장값이 원래 값보다 클 경우 즉시 nearest가 결정되니 종료				

								

				
				// 1-b-3. 해당하는 숫자(자릿수 곱한 값)을 저장하고 targetNumber에서 빼기
//				nearest += minIdx * tenDigit;				
//				targetNumber = min;
//				digitNumber -= 1;
//				// minIdx 초기화
//				minIdx = -1;
//			}
//			// 1-b-4. 그 후 1~3 반복
//			System.out.println(nearest);

			
			
			
/*			오류가 너무 많았던 코드들
			
			// log10 -> 0 들어오면 펑!
			
			int digitNumber = (int) (Math.log10(targetNumber) + 1);
			int digit = digitNumber;			

			// 1-c. target의 이하 자리수의 숫자와 가장 가까운 숫자 탐색(반복)
			for (int i = 0; i < digitNumber; i++) {				
				int tenDigits = (int) Math.pow(10, (digit - 1));				
				
				// target을 10^digit으로 나누고 남은 몫
				int digitCut = (int) targetNumber / tenDigits;		

				//  각 ableButtons의 값들을 몫에서 빼면서 최소값 찾기
				int min = Math.abs(digitCut - ableButtons[0]);
				int minIdx = 0;	

				// 가장 가까운 수가 ableButtons에 없을 경우 처리

				if (ableButtons.length > 1) {
					for (int j = 1; j < ableButtons.length; j++) {
						int sub = Math.abs(digitCut - ableButtons[j]);
						
						if (sub < min) {
							min = sub;
							minIdx = j;
						}
					}	
				}
				// 가장 가까운 숫자 저장
				nearest += minIdx + "";		
												
				// 이하 자리수 탐색을 위해 가장 높은 자리수 제거 + digit 초기화
				// targetNumber가 0이 아니면 && targetNumber가 tenDigits의 배수가 아니면
				if (targetNumber != 0 && (targetNumber % tenDigits) == 0) {
					targetNumber = targetNumber % tenDigits;
					digit -= 1;					
				} else { // targetNumber가 tenDigits의 배수일 때(4000, 1000)
					
				}
				
			
			}		
			
			// String to Int
			int nearestInt = Integer.parseInt(nearest);			
						
				// d. 도출된 nearest의 자리수 계산 -> sum에 더하기
			sum += Math.log10(nearestInt) + 1;
				
			
			// 2. abs(target - nearest) = sub 개수를 sum에 더한다.
			sum += Math.abs(target - nearestInt);
			
			System.out.println(sum);
			*/

