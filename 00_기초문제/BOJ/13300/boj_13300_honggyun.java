import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./input.txt"));
		
		// 방 배정 문제
		Scanner sc = new Scanner(System.in);		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 결과를 저장할 값 생성
		int result = 0;
		
		// 여학생과 남학생을 학년별로 분류해서 저장할 일차원 배열 생성
		int[] girls = new int[6];
		int[] boys = new int[6];
		
		// 반복문과 조건문으로 S와 Y에 따라 조건에 맞는 학생 수 카운트
		for(int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			
			switch(Y) {
				case 1: 
					if(S == 0) girls[0]++; 
						else boys[0]++;
					break;
					
				case 2:
					if(S == 0) girls[1]++; 
						else boys[1]++;
					break;
					
				case 3: 
					if(S == 0) girls[2]++; 
						else boys[2]++;
					break;
					
				case 4:
					if(S == 0) girls[3]++; 
						else boys[3]++;
					break;
					
				case 5: 
					if(S == 0) girls[4]++; 
						else boys[4]++;
					break;
					
				case 6:
					if(S == 0) girls[5]++; 
						else boys[5]++;
					break;
			}
			
		}	

 
		// 반복문을 통해 필요한 방 개수 탐색
		for(int i = 0; i < 6; i++) {
			if(girls[i] % K == 0) {
				result += girls[i] / K;
			} else {
				result += (girls[i] / K) + 1;
			}
			
			if(boys[i] % K == 0) {
				result += boys[i] / K;
			} else {
				result += (boys[i] / K) + 1;
			}
		}		
				
		System.out.println(result);
		
	}

}
