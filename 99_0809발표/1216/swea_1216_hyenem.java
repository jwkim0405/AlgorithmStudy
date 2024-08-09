
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int T = 0; T<10; T++) {
			
			int test_case = sc.nextInt();
			String[] arr = new String[100];
			for (int i = 0; i<100; i++) {
				arr[i]=sc.next();
			}
			
			int ans = 0;
			end2: for (int max = 100; max>0; max--) {
				for (int i = 0; i<100; i++) {
					end: for (int j = 0; j<101-max; j++) {
						for (int k = 0; k<max/2; k++) {
							if(arr[i].charAt(j+k)!=arr[i].charAt(j+max-k-1)) {
								continue end;
							}
						}
						ans = max;
						break end2;
					}
				}
			}
			
			end4: for (int max = 100; max>ans; max--) {
				for (int i = 0; i<100; i++) {
					end3: for (int j = 0; j<101-max; j++) {
						for (int k = 0; k<max/2; k++) {
							if(arr[j+k].charAt(i)!=arr[j+max-k-1].charAt(i)) {
								continue end3;
							}
						}
						ans = max;
						break end4;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
}
