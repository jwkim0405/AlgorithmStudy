import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=0; test_case<4; test_case++) {
			int[][] arr = new int[2][4];
			for(int i = 0; i<2; i++) {
				for (int j = 0; j<4; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			

			
			if(arr[0][0]>arr[1][2]||arr[0][2]<arr[1][0]
					||arr[0][1]>arr[1][3]||arr[0][3]<arr[1][1]) {
				System.out.println('d');
				continue;
			} else if(arr[0][0]==arr[1][2]||arr[0][2]==arr[1][0]) {
				if(arr[0][1]==arr[1][3] || arr[0][3]==arr[1][1]) {
					System.out.println('c');
					continue;
				} else {
					System.out.println('b');
					continue;
				}
			} else if(arr[0][1]==arr[1][3] || arr[0][3]==arr[1][1]) {
				if(arr[0][0]==arr[1][2]||arr[0][2]==arr[1][0]) {
					System.out.println('c');
					continue;
				} else {
					System.out.println('b');
				}
			} else if(arr[0][0]==arr[1][2]||arr[0][2]==arr[1][0]) {
				if(!(arr[0][1]==arr[1][3] || arr[0][3]==arr[1][1])) {
					System.out.println('b');
				}
			} else {
				System.out.println('a');
			}
		}
	}
}

