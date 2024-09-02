import java.util.Arrays;
import java.util.Scanner;

public class boj_1244_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//스위치 갯수 저장
		int swNum = sc.nextInt();
		//스위치 상태 저장하는 배열 공간 생성
		int[] swArr = new int[swNum];
		//스위치 상태 저장하는 배열 안에 값 저장
		for(int i=0; i<swNum; i++) 	
			swArr[i] = sc.nextInt();
		
		//학생 수 저장
		int stNum = sc.nextInt();
		//학생 성별, 받은 수 저장할 이차원 배열 생성
		int[][] stInfo = new int[stNum][2];
		for(int k=0; k<stNum; k++) {	//학생의 성별, 받은 수 정보 저장
			stInfo[k][0] = sc.nextInt();
			stInfo[k][1] = sc.nextInt();
		}
		
		for(int i=0; i<stNum; i++) {	//학생 수만큼 반복
			if(stInfo[i][0] == 2) {	//여성인 경우	//얘가 이상함
				
				//받은 수 -1만큼 반복(대칭으로 탐색)
				for(int j=1; j<stInfo[i][1]; j++) {
					
					//학생이 받은 수의 +j -j 값이 같으면 continue
					if(swArr[stInfo[i][1]-1+j]
							==swArr[stInfo[i][1]-1-j]) {
						if(stInfo[i][1]-1-j <=0 || stInfo[i][1]-1+j >=swArr.length-1) {	//swArr의 인덱스가 0이거나 마지막일 경우(탐색 마침) 2
							
							for(int t=stInfo[i][1]-1-j; t<stInfo[i][1]+j; t++){
								swArr[t] = (swArr[t]==0)? 1 : 0 ;
							}
//							System.out.println(Arrays.toString(swArr) +"swArr의 인덱스가 0이거나 마지막일 경우(탐색 마침)");
							
						}
						
					}
					//대칭된 스위치 값이 다르면 그 사이 인덱스 범위 내의 스위치 온오프를 반대로 바꾼다
					else {
						for(int t=stInfo[i][1]-j; t<stInfo[i][1]+j-1; t++){
							swArr[t] = (swArr[t]==0)? 1 : 0 ;
						}
//						System.out.println(Arrays.toString(swArr) +"대칭된 스위치 값이 다르면 그 사이 인덱스 범위 내의 스위치 온오프를 반대로 바꾼다");
						
					}
				}
			}else {	//남성인 경우
				for(int j=0; j<swNum/stInfo[i][1]; j++) {	//스위치 갯수/받은 수 만큼 반복
					swArr[stInfo[i][1]-1+j*stInfo[i][1]]	//시작위치(인덱스)+j*받은 수...가 0이면 1, 1이면 0
							= swArr[stInfo[i][1]-1+j*stInfo[i][1]]==0? 1 : 0 ;
				}
//				System.out.println(Arrays.toString(swArr)+"남성인 경우 끝남");
			}
			
		}
//		System.out.println(Arrays.toString(swArr)+"메인함수 끝남");
		for(int i=0; i<swArr.length; i++) {
			System.out.print(swArr[i] + " ");
		}
	}

}

//8
//0 1 0 1 0 0 0 1
//2
//1 3
//2 3

//8
//0 1 0 1 0 0 0 1
//1
//1 3
