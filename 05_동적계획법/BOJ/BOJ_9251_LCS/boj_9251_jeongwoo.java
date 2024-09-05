import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strA = sc.next();
        String strB = sc.next();

        int N = strA.length();
        int M = strB.length();
        int[][] map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char charA = strA.charAt(i-1); // i번째 자리 값 (index 1부터 생각)
                char charB = strB.charAt(j-1); // i번째 자리 값 (index 1부터 생각)

                if (charA == charB) {
                    map[i][j] = map[i-1][j-1] + 1;
                } else {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }
        System.out.println(map[N][M]);
    }
}

