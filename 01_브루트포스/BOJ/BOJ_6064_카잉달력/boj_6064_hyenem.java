import java.util.Scanner;

public class Main {
	public static int gcd(int a, int b) {
		int n1 = a;
		int n2 = b;
		while(n1!=n2) {
			if (n1>n2) { //n1이 더 작아짐
				int tmp1 = n1;
				n1 = n2;
				n2 = tmp1;
			}
			n2 = n2 - n1;
		}
		return n1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<T+1; test_case++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			if (Math.abs(x-y)%gcd(M, N)!=0) System.out.println(-1);
			else {
				//x가 더 작도록 순서를 바꿔
				if (y<x) {
					int tmp = M;
					M = N;
					N = tmp;
					
					tmp = x;
					x = y;
					y = tmp;
				}
				
				
				//일단 <x, x>를 만드는거야.
				int ans = x+1;
				int nowY = x;
				
				// 두번째 x가 y가 될때까지 x가 몇 바퀴 돌아야 하는지를 계산해야하는데
				// x쪽은 M번 돌면 자기 위치니까 그때 y가 y+M이 되는데,
				// 지금 mod N에 대해서 얘기하고 있으니까, N으로 나눈 나머 y가 될때까지 몇바퀴 도느냐의 문제
				while (nowY!=y) {
					nowY = (nowY+M)%N;
					ans += M;
				}
				System.out.println(ans);
			}
		}
	}
}

