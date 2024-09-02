import java.util.Arrays;
import java.util.Scanner;

public class boj_2309_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int[] tmp = new int[arr.length];	//2개의 요소를 제외할 임의의 배열
		int sum = 0;	//tmp 요소 합을 누적할 변수
		
		for(int i=0; i<arr.length; i++) {	//입력값을 배열에 저장
			arr[i] = sc.nextInt();
		}

		out : for(int r=0; r<arr.length; r++) {	//요소의 첫 번쨰부터 시작
			for(int c=r+1; c<arr.length; c++) {	//요소의 두 번째부터 시작
				System.arraycopy(arr, 0, tmp, 0, arr.length);	//일단 복사해
				tmp[r] = -1;	//임의로 값 변경 - 해당 값은 나중에 더해지지 않도록 한다. 
				tmp[c] = -1;
				sum = 0;
				
				for(int j=0; j<tmp.length; j++) {
					if(tmp[j] == -1) continue;	//요소값이 -1인 경우 건너뛰기
					sum += tmp[j];
				}
				
				if(sum == 100) {	//가짜난쟁이를 색출한 경우
					Arrays.sort(tmp);
					for (int a : tmp) {
						if(a == -1) continue;	//요소값이 -1인 경우 건너뛰기
						System.out.println(a);
					}
					break out;
				}
			}
		}
		
	}

}
