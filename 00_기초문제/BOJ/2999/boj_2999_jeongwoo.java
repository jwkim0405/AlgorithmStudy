import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); // 암호화된 문자열 입력
        int N = str.length();
        int R = 1, C = N;

        // R <= C, RxC = N을 만족하는 최대 R 찾기
        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) {
                R = i;
                C = N / R;
            }
        }

        String newStr = ""; // 해독한 문자열
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                newStr += str.charAt(i + j * R);

        System.out.println(newStr);
    }
}

