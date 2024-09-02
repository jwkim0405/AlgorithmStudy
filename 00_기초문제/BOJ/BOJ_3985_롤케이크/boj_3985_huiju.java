import java.util.Scanner;

public class tmp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int expMax = 0;	//가장 많이 받을 줄 알았던 사람의 예상조각개수를 저장하는 변수
		int audMax = 0;	//실제로 많이 받은 사람의 조각개수를 저장하는 변수
		int exp = 0;	//가장많이받을줄알앗던사람의번호
		int aud = 0;	//실제로가장많이받은사람의번호
		int[] cake = new int[l];	//케이크 길이만큼의 배열
		
		for(int i=0; i<n; i++) {
			int cnt = 0;	//현재 사람이 받는 케이크의 개수
			int start = sc.nextInt();	//케이크 개수 적는 시작점
			int end = sc.nextInt();		//케이크 개수 적는 끝..점
			
			if(expMax<(end - start)) {	//가장많이받을줄알앗던사람을 구하는 조건식
				expMax = end - start;
				exp = i+1;
			}
			
			for(int j=start-1; j<=end-1; j++) {	//현재 사람이 받는 케이크 개수를 구하는 반복문
				if(cake[j] == 0) {
					cake[j] = i+1;
					cnt++;
				}
			}
			
			if(audMax<cnt) {	//실제로가장많이받는사람을 구하는 조건식
				audMax = cnt;
				aud = i+1;
			}
		}
		System.out.printf("%d\n%d", exp, aud);
		
		
	}

}
