import java.util.Scanner;

public class boj_1748_yuyoung {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int number = String.valueOf(N).length(); // N의 자릿수 구하기

        int Nnumber = 0; // 1부터 N까지 이어지는 숫자의 자릿수
        int sum = 0;

        for (int i = 1; i < number; i++) {
            Nnumber = i * (int)(Math.pow(10, i) - Math.pow(10, i - 1)); // 1부터 N까지 이어지는 숫자의 자릿수 구하기
            sum += Nnumber;
        }

        int sumNumber = sum + (number * (N - (int)Math.pow(10, number - 1) + 1));

        System.out.println(sumNumber);
    }
}
