import java.util.Scanner;

public class Kaing6064 {

	public static void main(String[] args) {
		//M과 N의 최소공배수 찾기 = 마지막 해
		//(M*N)/최대공약수 = 최소공배수
		//if 주어진 달력 날짜가 최소공배수를 초과할 경우 -1 출력
		//x가 돌아오는 주기를 카운트하면서 y가 N과 같은지 검사
		//y가 N과 같아지면 카운트*M+x 로 정답을 구한다
		
//		for(int i=2; i<=N; i++){	//소인수분해
		//			while(N%i ==0) {		//i로 나눴을 때 0인 경우
		//				System.out.println(i);	//i를 반환하고
		//				N/=i;	//N을 i로 나눈 몫을 N에 대입한다
		//			}
		//		}
		//		int gcd = getGCD(num1, num2);	
		//        System.out.println("the greatest common denominator : " + gcd);	//최대공약수
		//        System.out.println("the lowest common multiple : " + (num1 * num2) / gcd);	//최소공배수
		//        
		//    }
		//
		
				
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		

		for(int i=0; i<t; i++) {
			
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int lcm = (m*n)/getGCD(m,n);
			
			for(int count=x; count<=lcm; count+=m) {
				if(m+count > lcm) {	// 세어진 총 햇수가 최소공배수(마지막 해)보다 커질 때 -> 성립하지 않음
					System.out.println(-1);
					break;
				}
				int tmpY = count%n;	//y의 자리에 들어갈 수는 현재 세어진 햇수에서 N을 나눴을 때의 나머지
				if(tmpY==y)	{ 	//tmpY가 y와 같아질 때 현재까지 세어진 햇수가 정답이 된다
					System.out.println(count);
					break;
				}
			}
		}
	}

	public static int getGCD(int num1, int num2) {//최대공약수 최소공배수 구하는 메서드
		if (num1 % num2 == 0) {
			return num2;
		}
		return getGCD(num2, num1%num2);
	}

}
