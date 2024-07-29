import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {	
		// OX 퀴즈 문제
		System.setIn(new FileInputStream("./input.txt")); // test를 위해
		// 각 테케마다 들어오는 퀴즈 수가 일정하지 않기 때문에 buffer로 한 줄씩 통째로 읽어오는 게 낫다 판단
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());	
		
		// 테케 수 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++) {
			// 공백이 없기 때문에 StringTokenizer는 사용하지 않았음
			String inputLine = br.readLine();
			int quizNum = inputLine.length();
			
			// 각 퀴즈 별 점수와 그 합계를 저장할 변수 생성
			int score = 0;
			int sum = 0;
			
			// 반복문 돌면서 계산
			for(int i = 0; i < quizNum; i++) {
				if(inputLine.charAt(i) == 'O') { // O면 score +1씩 
					score++;
				} else {
					score = 0; // X면 0으로 초기화
				}
				
				sum += score; // 그걸 전부 sum에 더해주기
			}
				
			
			System.out.println(sum);
				
		}
	}

}
