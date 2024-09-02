package BOJ;
import java.util.Scanner;
import java.lang.Math;

public class boj_3085_jeongwoo {

    // 가로 색상 확인
    public static int h_cntColor(char[][] charCandy, int n) {
        int max = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (charCandy[i][j] == charCandy[i][j+1]) {
                    cnt++;
                    if (max < cnt)
                        max = cnt;
                }
                else
                    cnt = 1;
            }
            cnt  = 1;
        }
        return max;
    }

    // 세로 색상 확인
    public static int v_cntColor(char[][] charCandy, int n) {
        int max = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (charCandy[j][i] == charCandy[j+1][i]) {
                    cnt++;
                    if (max < cnt)
                        max = cnt;
                }
                else
                    cnt = 1;
            }
            cnt = 1;
        }
        return max;
    }

    // 가로, 세로 전체에서 max값 찾기
    public static int max(char[][] charCandy, int n) {
        int h_max = h_cntColor(charCandy, n);
        int v_max = v_cntColor(charCandy, n);

        int result = Math.max(h_max, v_max);
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 크기 n 입력
        int n = sc.nextInt();

        // n개의 String 배열 생성(입력에 띄어쓰기 없어서 1차원으로 받음)
        String[] candy = new String[n];

        // candy 배열 값 입력
        for (int i = 0; i < n; i++)
            candy[i] = sc.next();

        // String으로 받은 candy를 char형 2차원 배열로 변환
        char[][] charCandy = new char[n][n];
        for (int i = 0; i < n; i++) {
            charCandy[i] = candy[i].toCharArray();
        }

        int total_max = 0;

//         가로 바꿔주기
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n-1; j++) {
                // i,j와 i, j+1 위치 바꾸기
                char temp = charCandy[i][j];
                charCandy[i][j] = charCandy[i][j+1];
                charCandy[i][j+1] = temp;
//                System.out.print(max(charCandy, n) + " ");
                if (total_max < max(charCandy, n))
                    total_max = max(charCandy, n);

                // i,j와 i, j+1 위치 원상복귀
                temp = charCandy[i][j];
                charCandy[i][j] = charCandy[i][j+1];
                charCandy[i][j+1] = temp;
            }
        }
//        System.out.println();
//         세로 바꿔주기
        for (int i = 0; i < n-1; i ++) {
            for (int j = 0; j < n; j++) {
                // i,j와 i+1, j 위치 바꾸기
                char temp = charCandy[i][j];
                charCandy[i][j] = charCandy[i+1][j];
                charCandy[i+1][j] = temp;
//                System.out.println(max(charCandy, n) + " ");
                if (total_max < max(charCandy, n))
                    total_max = max(charCandy, n);
                // i,j와 i, j+1 위치 원상복귀
                temp = charCandy[i][j];
                charCandy[i][j] = charCandy[i+1][j];
                charCandy[i+1][j] = temp;
            }
        }
//        System.out.println();
        System.out.print(total_max);
    } // main
} // class boj_3085_jeongwoo
