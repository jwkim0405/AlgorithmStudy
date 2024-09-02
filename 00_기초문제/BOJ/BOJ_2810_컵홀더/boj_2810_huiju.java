import java.util.Scanner;

public class boj_2810_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//좌석의 수
		String[] info = sc.next().split(""); 	//좌석 정보
		int amOfL = 0;	//amount of L,, L좌석의 수를 누적하는 변수
		int amOfS = 0;	//amount of S,, S좌석의 수를 누적하는 변수
		int result = 0;
		
		
		for(int i=0; i<info.length; i++) {
			if(info[i].equals("L")) amOfL++;	//L의 개수를 구한다
			else amOfS++;	//S의 개수를 구한다
		}
		
		if(amOfL <= 2) result = info.length;
		else result = amOfS + amOfL/2 + 1;
		
		System.out.println(result);
	}

}

