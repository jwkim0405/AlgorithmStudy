import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        /*
        최장 증가 부분 수열 찾기
        A 크기 N <= 1000
        Ai <= 1000
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열 길이
        int[] sequence = new int[N+1];
        for(int i = 1; i <= N; i++) {
            sequence[i] = sc.nextInt();
        }

        //longest common subsequence
        int[][] lcs = new int[N+1][N+1];

        /*
        1. 아무것도 선택하지 않거나, 원수열이 없는 경우 0이므로 0번째 인덱스는 0
            r <- 원수열에서 r번째까지 뽑았을 때 가능한 경우의 수
            c <- 원수열에서 c번의 수와 비교
        2-1. (r,c)에 대해, sequence(c) <= sequence(r) (조건 만족하지 않으면)
        -> lcs[r][c] = Math.max(lcs[r-1][c], lcs[r][c-1])
        -> lcs[r-1][c] => 원수열에서 r-1번째까지 뽑아봤을 때 가능한 최장 수열의 길이
        -> lcs[r][c-1] => 원수열에서 r번째까지 뽑고, c-1번 수와 비교했을 때 가능한 최장 수열의 길이
            둘 중에 큰 값이 r,c까지 봤을때의 가능한 최장 수열의 길이

        2-2. (r,c)에 대해, sequence(c) > sequence(r) (증가하는 수열 조건을 만족하면)
        -> lcs[r][c] = lcs[r-1][c-1] + 1(r-1번째 뽑았을 때 (c-1)번까지의 최장길이에서 1개 더 가능해졌다!)
        3. 전체를 봤을때 가능한 최장 수열의 길이 => lcs[n][n]
         */

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(r == c && r == 1) {
                    lcs[r][c] = 1;
                    continue;
                }
                // 조건 만족 X
                if(sequence[c] <= sequence[r]) lcs[r][c] = Math.max(lcs[r-1][c], lcs[r][c-1]);
                // 조건 만족(증가)
                else {
                    if(c > r) lcs[r][c] = Math.max(lcs[r][r]+1, lcs[r][c-1]);
                    else lcs[r][c] = Math.max(lcs[r-1][c], lcs[r][c-1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(lcs));
        System.out.println(lcs[N][N]);
    }
}
