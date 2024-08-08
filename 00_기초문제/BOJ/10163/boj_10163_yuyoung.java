import java.util.Scanner;

public class boj_10163_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 색종이의 수
        int[][] arr = new int[1001][1001];

        for (int n = 1; n <= N; n++) {
            int sj = sc.nextInt(); // 색종이 시작 열
            int si = sc.nextInt(); // 색종이 시작 행
            int w = sc.nextInt(); // 색종이 가로 길이
            int h = sc.nextInt(); // 색종이 세로 길이
            for (int i = si; i < si + h; i++) {
                for (int j = sj; j < sj + w; j++) {
                    arr[i][j] = n; // 색종이 번호
                }
            }
        }

        int[] cnt = new int[N + 1]; // 각 종이의 면적
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                cnt[arr[i][j]]++; // 해당 종이 번호 갯수가 넓이
            }
        }
        // 각 종이의 면적 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(cnt[i]);
        }
    }
}
