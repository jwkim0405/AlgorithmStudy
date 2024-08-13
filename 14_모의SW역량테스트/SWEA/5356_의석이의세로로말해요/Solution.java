import java.util.Scanner;

public class Solution {

	static final int SIZE = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		String[] str; // 5줄의 문자열 담을 배열
		
		for (int t = 1; t <= testCase; t++)
		{
			str = new String[SIZE];

			for (int i = 0; i < SIZE; i++)
				str[i] = sc.next(); // 배열에 문자열 할당

			StringBuilder sb = new StringBuilder(); // 새롭게 만들어질 문자열 선언
			int j = -1; // 열의 인덱스
			OUT: while(true) {
				j++; // 5행을 다 돌면 열(j) 인덱스 값 ++
				int cnt = 0;
				for (int i = 0; i < SIZE; i++) {
					if (j >= str[i].length()) { // 열의 인덱스가 str[i]의 마지막 인덱스보다 크다면!
						cnt++;
						continue; // 건너 뛰기
					}
					else // 열의 인덱스에 값이 있다면
						sb.append(str[i].charAt(j));
				}
				if (cnt == 5) // 만약 5번 모두(0~4번 인덱스 값) 빈 값이 나왔다면 종료
					break OUT;
			}
			System.out.println("#" + t + " " + sb);
		}
	}
}
