package boj;

import java.util.Scanner;
import java.lang.Math;

public class boj_1592_jeongwoo {
	public static int gcd(int a, int b) {
		int num = Math.min(a, b);
		int res = 1;
		for (int i = 2; i <= num; i++) {
			if (a % i == 0 && b % i == 0)
				res = i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		if (m == 1)
			System.out.println(0);
		else
			System.out.println((m-1) * n / gcd(n, l));
	}
}
