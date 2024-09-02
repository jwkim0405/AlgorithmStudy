import java.util.Scanner;

public class boj_2851_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] score = new int[10];
		int nowSum = 0;
		int updateSum = 0;
		int nowAbs = 0;
		int updateAbs = 0;
		int result = 0;
		
		for(int i=0; i<10; i++) {	//입력값을 배열에 저장
			score[i] = sc.nextInt();
		}
		
		for(int j=0; j<score.length; j++) {
			if(nowSum < 100) {	//현재 점수의 총합이 100보다 작을 때
				updateSum += score[j];	//updateSum에 다음 점수를 더한다.
				
				if(updateSum >= 100) {	//만약 updateSum이 100을 넘었다면
					nowAbs = Math.abs(nowSum-100);
					updateAbs = Math.abs(updateSum-100);

					if(nowAbs == updateAbs) 	//절대값이 같은 경우 더 큰 수 출력
						{result = nowSum > updateSum ? nowSum : updateSum ; break;}
					else 						//절대값이 다른 경우 100에 더 가까운 수 출력
						{result = nowAbs > updateAbs ? updateSum : nowSum ; break;}
				}else {	//updateSum이 100을 넘지 않았다면
					nowSum = updateSum;	//nowSum에 updateSum을 대입
				}
			}
		}
		if(updateSum < 100) 	//모든 점수를 다 더했는데 100보다 작은 경우
			result = updateSum;
		
		System.out.println(result);
		
		
	}

}

