import java.util.Scanner;

public class Main {

    static int[][] map;
    static int N, L;
    static int cnt; // 각 행, 각 열의 같은 값 연속으로 나오는 횟수
    static int res = 0; // 지나갈 수 있는 길의 개수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 지도의 크기
        L = sc.nextInt(); // 경사로의 가로 길이

        map = new int[N][N]; // 지도의 높이 저장할 배열

        // 지도 높이 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        row_search(); // 가로 탐색
        col_search(); // 세로 탐색

        System.out.println(res);
    } // main

    static void row_search() {
        // 가로 탐색(0~N-1행)
        NEXT:
        for (int i = 0; i < N; i++) {
            cnt = 1;
            for (int  j = 1; j < N; j++) {
                // 1. 값이 같으면, 오른쪽으로 이동(cnt++)
                if (map[i][j-1] == map[i][j]) {
                    cnt++;
                }
                // 2. 오른쪽 높이가 한 칸 높은 경우 (경사로가 만들어질 수 있다면 ++)
                else if ((map[i][j-1] + 1 == map[i][j]) && cnt >= L) {
                    cnt = 1; // 연속 높이 cnt 1로 초기화
                }
                // 3. 오른쪽 높이가 한 칸 낮은 경우
                else if (map[i][j-1] -1 == map[i][j]) {
                    // L만큼 반복되는지 확인
                    for (int k = 1; k < L; k++) {
                        if (j + k >= N || map[i][j] != map[i][j + k]) {// 인덱스 범위 벗어나거나 값이 다르면 out
//                            System.out.println(i + " " + j + " " + "탈출");
                            continue NEXT; // 다음 fori 문 tlfgod
                        }
                    }
                    cnt = 0;
                    j += (L-1); // 경사로를 놓은 이후부터 보겠다.
                }
                // 3. 이외의 경우 -> 다음 for i문 실행
                // - 오른쪽 높이와의 차이가 2이상인 경우
                // - 1칸 높은데, 경사로가 만들어질 수 없는 경우
                else {
//                    System.out.println(i + " " + j + " " + "탈출");
                    continue NEXT;
                }
            } // for j
            res++; // for j문 탐색을 완료하면, 이 길은 지날 수 있음
        } // 가로탐색 for i
    }

    static void col_search() {
        // 세로 탐색(0~N-1열)
        NEXT:
        for (int i = 0; i < N; i++) {
            cnt = 1;
            for (int  j = 1; j < N; j++) {
                // 1. 값이 같으면, 아래쪽 이동(cnt++)
                if (map[j-1][i] == map[j][i]) {
                    cnt++;
                }
                // 2. 아래쪽 높이가 한 칸 높은 경우 (경사로가 만들어질 수 있다면 ++)
                else if ((map[j-1][i] + 1 == map[j][i]) && cnt >= L) {
                    cnt = 1; // 연속 높이 cnt 1로 초기화
                }
                // 3. 아래쪽 높이가 한 칸 낮은 경우
                else if (map[j-1][i] -1 == map[j][i]) {
                    // L만큼 반복되는지 확인
                    for (int k = 1; k < L; k++) {
                        if (j + k >= N || map[j][i] != map[j + k][i]) {// 인덱스 범위 벗어나거나 값이 다르면 out
//                            System.out.println(i + " " + j + " " + "탈출");
                            continue NEXT; // 다음 fori 문 tlfgod
                        }
                    }
                    cnt = 0;
                    j += (L-1); // 경사로를 놓은 이후부터 보겠다.
                }
                // 3. 이외의 경우 -> 다음 for i문 실행
                // - 아래쪽 높이와의 차이가 2이상인 경우
                // - 1칸 높은데, 경사로가 만들어질 수 없는 경우
                else {
//                    System.out.println(i + " " + j + " " + "탈출");
                    continue NEXT;
                }
            } // for j
            res++; // for j문 탐색을 완료하면, 이 길은 지날 수 있음
        } // 세로탐색 for i
    }
} // class

