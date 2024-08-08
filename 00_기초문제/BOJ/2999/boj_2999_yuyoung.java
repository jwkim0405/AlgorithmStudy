import java.util.Scanner;

public class boj_2999_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine();
        int N = word.length(); // 문자열의 길이
        int sqrt = (int) Math.sqrt(N);
        int R = 0, C = 0;
        // R의 크기는 최대 N의 제곱근까지 가능하다
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                R = i;
                C = N / i;
            }
        }

        int cnt = 0;
        char[][] arr = new char[R][C];
        
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                arr[r][c] = word.charAt(cnt++);
            }
        }
        // 열과 행 바꿔서 출력
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(arr[r][c]);
            }
        }
    }
}
