package 활주로_건설;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int possible = 0; // 건설 가능한 줄의 개수 저장할 변수

    public static void main(String[] args) throws IOException {
        // 활주로 건설
        System.setIn(new FileInputStream("./src/활주로_건설/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int X = sc.nextInt();

            // 지형 정보 배열 만들기
            int[][] areaInfo = new int[N][N]; // 정배치
            int[][] verticalAreaInfo = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    areaInfo[i][j] = sc.nextInt();
                    verticalAreaInfo[j][i] = areaInfo[i][j]; // 가로세로 반전
                }
            }

            // 가로 순회
            checkConstructable(areaInfo, N, X);
//            System.out.printf("#%d %d\n", test_case, possible);

            // 세로 순회
            checkConstructable(verticalAreaInfo, N, X);

            System.out.printf("#%d %d\n", test_case, possible);
            possible = 0; // possible 초기화

        }

    }

    static void checkConstructable(int[][] info, int N, int X) {
        //--------------------------------------------------------------------
        nextLine: // label
        for(int r = 0; r < N; r++) {
            int maxHeight = 0; // 각 줄에서 최대 높이
            int maxHeightIdx = -1; // 최대 높이를 처음 만났을 때의 column index
            // 순회하면서 max값 먼저 찾기
            for(int c = 0; c < N; c++) {
                if(info[r][c] > maxHeight) {
                    maxHeight = info[r][c];
                    maxHeightIdx = c;
                }
            }

            // 역방향 순회 후 정방향 순회
            // 역방향 순회
            int cnt = 1; // 지형 개수 저장
            for(int c = maxHeightIdx; c > 0; c--) { // 1까지만 봐도 완전 탐색
                int height = info[r][c];
                int nextHeight = info[r][c-1];

                if(height == nextHeight) {
                    cnt++; // 지금 값과 다음 값이 같으면 개수 올려주기
                    if(c == 1 && cnt < X && height != maxHeight) continue nextLine; // 같은 숫자로 끝에 다다랐는데 cnt가 X보다 작으면
                    
                } else if(Math.abs(height - nextHeight) > 1) { // 높이 차가 1보다 더 크면 건설 fail
                    continue nextLine;

                } else if(height-1 == nextHeight) {
                    // 역방향 검사는 조금 다르게 해야 됨!
                    // 2 1 2 2 3 4
                    // 지금이 max면 일단 내려감
                    // max가 아니라면 그 때까지의 cnt가 x이상인지 확인(이전 숫자에서 현재 숫자로 내려왔던게 가능했는지 체크)
                    if(c == 1 && X != 1) continue nextLine;
                    else if(height == maxHeight) cnt = 1;
                    else {
                        if(cnt >= X) cnt = 1; // cnt가 x 이상이면 이전 height와 지금 height사이에 활주로 건설 가능
                        else continue nextLine; // 건설 fail
                    }

                } else if(height+1 == nextHeight) { // 다음 칸이 더 높은데 cnt가 충분한 경우 1 2 1 1 2 3 2
                    if(cnt >= 2*X) cnt = 1; // 건설 ongoing
                    else continue nextLine;
                }
            }

            cnt = 1;
            // 정방향 순회
            for(int c = maxHeightIdx; c < N-1; c++) { // 1까지만 봐도 완전 탐색
                int height = info[r][c];
                int nextHeight = info[r][c+1];

                if(height == nextHeight) {
                    cnt++; // 지금 값과 다음 값이 같으면 개수 올려주기
                    if(c == N-2 && cnt < X && height != maxHeight) continue nextLine; // 같은 숫자로 끝에 다다랐는데 cnt가 X보다 작으면

                }
                else if(Math.abs(height - nextHeight) > 1) continue nextLine; // 높이 차가 1보다 더 크면 건설 fail
                else if(height-1 == nextHeight) { // 높이가 1 낮거나 끝일때
                    if(c == N-2 && X != 1) continue nextLine; // 마지막에 최대 값보다 1개 낮은 게 왔는데 x가 1이 아니면
                    else if(height == maxHeight) cnt = 1;
                    else {
                        if(cnt >= X) cnt = 1; // cnt가 x 이상이면 이전 height와 지금 height사이에 활주로 건설 가능
                        else continue nextLine; // 건설 fail

                    }
                } else if(height+1 == nextHeight) { // 다음 칸이 더 높은데 cnt가 충분한 경우 1 2 1 1 2 3 2
                    if(cnt >= 2*X) cnt = 1; // 건설 ongoing
                    else continue nextLine;
                }
            }
            //--------------------------------------------------------------------
//            System.out.println(r);
            // 모든 순회가 통과되면
            possible++;
        }
    }

}
