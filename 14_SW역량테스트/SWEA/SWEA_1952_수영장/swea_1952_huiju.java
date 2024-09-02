import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class swea_1952_huiju {

	static int day;		//... 각 금액들
	static int mon1;
	static int mon3;
	static int year;
	static int min;		//최소금액을 저장할 변수
	static int[] use;	//이용계획을 저장할 배열
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("1952_input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {	//테케 개수만큼 반복
			
			day = sc.nextInt();
			mon1 = sc.nextInt();
			mon3 = sc.nextInt();
			year = sc.nextInt();
			use = new int[13];	//맨앞은 0으로 비워놓음
			for(int i=1; i<use.length; i++) {
				use[i] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(use));
			//-----------------------------------------
			min = year;
			dfs(1, 0);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	private static void dfs(int month, int cost) {
		//기저조건
		if(month > 12) {	//month가 12월을 넘어가면
			min = Math.min(min, cost);	//최솟값을 업데이트
			return;
		}
		
		//재귀
		if(month == 0) 	//수영 안 가는 달의 경우
			dfs(month + 1, cost);	//1달 뒤로 넘어가고 비용은 그대로
		
		//하루이용권
		dfs(month + 1, cost + day*use[month]);
		//한달이용권
		dfs(month + 1, cost + mon1);
		//세달이용권
		dfs(month + 3, cost + mon3);
		
	}


}
