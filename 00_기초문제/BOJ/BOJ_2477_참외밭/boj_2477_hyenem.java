import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int[] x = new int[3];
		int[] y = new int[3];
		int xIdx = 0;
		int yIdx = 0;
		for(int i = 0; i<3; i++) {
			int trash = sc.nextInt();
			x[i] = sc.nextInt();
			trash = sc.nextInt();
			y[i]=sc.nextInt();
			if(x[xIdx]<x[i]) xIdx = i;
			if(y[yIdx]<y[i]) yIdx = i;
			
		}

		int xminIdx;
		int yminIdx;
		if(xIdx==yIdx) {
			xminIdx = (xIdx+2)%3;
			yminIdx = (yIdx+1)%3;
		} else{
			xminIdx = (xIdx+1)%3;
			yminIdx = (yIdx+2)%3;
		}
		
		System.out.println(((x[xIdx]*y[yIdx]) - (x[xminIdx]*y[yminIdx]))*amount);
	}
}

