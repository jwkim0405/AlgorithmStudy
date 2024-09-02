package boj_2590;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i<5; i++) {
			arr[i]=sc.nextInt();
		}
		int ans = sc.nextInt();
		
		if(arr[4]!=0) {
			ans += arr[4];
			arr[0]=Math.max(0, arr[0]-(11*arr[4]));
		}
		
		if(arr[3]!=0) {
			ans += arr[3];
			if(arr[1]<5*arr[3]) {
				arr[0]=Math.max(0, arr[0]-(20*arr[3]-4*arr[1]));
				arr[1]=0;
			} else {
				arr[1] -= 5*arr[3];
			}
		}
		
		if(arr[2]!=0) {
			ans += arr[2]/4+1;
			if(arr[2]%4 == 0) {
				ans --;
			} else if(arr[2]%4 ==1) {
				if(arr[1]<5) {
					arr[0]=Math.max(arr[0]-(27-arr[1]*4),0);
					arr[1]=0;
				} else {
					arr[1] -= 5;
					arr[0] = Math.max(0, arr[0]-7);
				}
			} else if(arr[2]%4 ==2) {
				if(arr[1]<3) {
					arr[0]=Math.max(arr[0]-(18-arr[1]*4),0);
					arr[1]=0;
				} else {
					arr[1] -= 3;
					arr[0] = Math.max(0,arr[0]-6);
				}
			} else if(arr[2]%4 ==3) {
				if(arr[1]<1) {
					arr[0]=Math.max(arr[0]-(9-arr[1]*4),0);
					arr[1]=0;
				} else {
					arr[1] -= 1;
					arr[0] = Math.max(0, arr[0]-5);
				}
			}
		}
		
		if(arr[1]!=0) {
			ans += arr[1]/9+1;
			if(arr[1]%9==0) {
				ans--;
			}
			if(arr[1]%9 !=0) arr[0] = Math.max(0, arr[0]-36+(arr[1]%9)*4);
		}
		
		ans += arr[0]/36+1;
		if(arr[0]%36==0) ans--;
		System.out.println(ans);		
	}
}

