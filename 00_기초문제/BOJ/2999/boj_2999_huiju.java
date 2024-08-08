import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2999_huiju {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String[] message = sc.next().split(""); 
		int n = message.length;
		int r=0, c=0;
		List<Integer> list = new ArrayList<>();
		//n을 어떤 수로 나누었을 때 나누어 떨어지면 그 수는 n의 약수이다.
		for(int i=1; i<=Math.sqrt(n); i++) {	//r과 c를 구한다.

			if(n % i == 0) {	//n의 약수를 리스트에 저장한다
				list.add(i);	

				if(i != n/i) 	//만약 i가 n의 제곱근일 경우 r과 c에 i를 대입한다.
					list.add(n/i);
			}
			
			list.sort(null);	//리스트 정렬
			
			if(list.size() %2 == 0) {	//약수의 개수가 짝수인 경우
				r = list.get(list.size() / 2 -1);	//가운데 약수 두 개 중 작은 약수 r
				c = list.get(list.size() / 2);	//가운데 약수 두 개 중 큰 약수 c

			}else {	//약수의 개수가 홀수인 경우(제곱근이 존재하는 경우)
				r = list.get(list.size() / 2);	//중앙값(제곱근)이 r과 c가 된다
				c = r;
			}
		}
		
		String[][] arr = new String[r][c];
		
		int cnt=0;	//message의 글자 인덱스를 카운트할 변수
		for(int j=0; j<c; j++) {	//암호를 배열에 저장
			for(int i=0; i<r; i++) {
				
				arr[i][j] = message[cnt++];
			}
		}
		
		for(int i=0; i<arr.length; i++) {	//암호를 출력
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
		}
		
	}

}
