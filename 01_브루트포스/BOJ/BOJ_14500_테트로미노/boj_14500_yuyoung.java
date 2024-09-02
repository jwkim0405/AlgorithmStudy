import java.util.Scanner;

public class boj_14500_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N열
        int M = sc.nextInt(); // M행
        int[][] arr = new int[M][N]; // M행 N열 2차원 배열 생성

        // 배열에 숫자 입력
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                arr[r][c] = sc.nextInt();
            }
        }

        int maxSum = 0;

        // 하늘색 테트로미노 1행 4열 배열
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N - 3; c++) {
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    sum += arr[r][c + i];
                    maxSum = Math.max(sum, maxSum);
                }
                
            }
        }

        // 노란색 2행 2열 배열
        for (int r = 0; r < M - 1; r++) {
            for (int c = 0; c < N - 1; c++) {
                int sum = arr[r][c] + arr[r][c + 1] + arr[r + 1][c] + arr[r + 1][c + 1];
                maxSum = Math.max(sum, maxSum);
            }
        }

        

        System.out.println(maxSum);
    }
}
