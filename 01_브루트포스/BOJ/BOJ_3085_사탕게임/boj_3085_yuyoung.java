import java.util.Scanner;

public class boj_3085_yuyoung {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] arr = new char[N][N]; // NXN 2차원 배열 생성
        
        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 한 줄씩 입력받기
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        } // 배열에 사탕의 색상 (C,P,Z,Y) 입력
        
        int maxCandy = 0;

        // 행에서 가장 긴 연속 부분 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    // 값 교환
                    swap(arr, i, j, i, j + 1);

                    // 가장 긴 연속 부분 갱신
                    maxCandy = Math.max(maxCandy, getMaxCandy(arr, N));

                    // 원래대로 복구
                    swap(arr, i, j, i, j + 1);
                }
            }
        }

        // 열에서 가장 긴 연속 부분 찾기
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (arr[i][j] != arr[i + 1][j]) {
                    // 값 교환
                    swap(arr, i, j, i + 1, j);

                    // 가장 긴 연속 부분 갱신
                    maxCandy = Math.max(maxCandy, getMaxCandy(arr, N));

                    // 원래대로 복구
                    swap(arr, i, j, i + 1, j);
                }
            }
        }

        System.out.println(maxCandy);
    }

    private static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
	    } // 값 교환 메서드

    private static int getMaxCandy(char[][] arr, int N) {
        int max = 1;

        // 행에서 가장 긴 연속 부분 찾기
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 열에서 가장 긴 연속 부분 찾기
        for (int j = 0; j < N; j++) {
            int cnt = 1;
            for (int i = 0; i < N - 1; i++) {
                if (arr[i][j] == arr[i + 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}

