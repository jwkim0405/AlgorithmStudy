import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxX = sc.nextInt();
		int maxY = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int N = sc.nextInt();
		
		if(N< maxX-x) x+=N;
		else {
			if(((N-(maxX-x))/maxX)%2==0) x=maxX-(N-(maxX-x))%maxX;
			else x=(N-(maxX-x))%maxX;
		}
		if(N< maxY-y) y+=N;
		else {
			if(((N-(maxY-y))/maxY)%2==0) y=maxY-(N-(maxY-y))%maxY;
			else y=(N-(maxY-y))%maxY;
		}

		
		System.out.println(x+" "+y);
	}
}

