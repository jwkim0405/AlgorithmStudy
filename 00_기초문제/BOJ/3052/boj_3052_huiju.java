import java.util.ArrayList;
import java.util.Scanner;

public class boj_3052_huiju {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;	//배열 속 요소와 나머지를 비교할 변수
		int rst = 0;	//나머지
		ArrayList rstArr = new ArrayList(1);	//초기 길이를 1로 하는 동적배열
		
		for(int i=0; i<10; i++) {
			rst = sc.nextInt()%42;	//입력받은 수의 나머지를 구해서 rst에 저장
			//rstArr의 요소 중 rst와 동일한 값이 없을 경우 rstArr에 rst 추가
			if(!(rstArr.contains(rst))) rstArr.add(rst);	
		}
		System.out.println(rstArr.size());
	}

}
