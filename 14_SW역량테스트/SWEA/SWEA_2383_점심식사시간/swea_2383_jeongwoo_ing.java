import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class swea_2383_jeongwoo_ing {
    static int[][] map;
    static int cnt; // 사람 수
    static ArrayList<int[]> stairs; // 계단 좌표 저장
    static ArrayList<int[]> group; // 전체 사람 좌표 저장
    static ArrayList<int[]> groupA;
    static ArrayList<int[]> groupB;
    static ArrayList<Integer> dist_A;
    static ArrayList<Integer> dist_B;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 지도 크기 N x N
            map = new int[N][N]; // 계단의 i, j 좌표 + 계단의 길이
            stairs = new ArrayList<>(); // 계단 좌표
            group = new ArrayList<>(); // 전체 집합
            groupA = new ArrayList<>(); // 부분집합 A
            groupB = new ArrayList<>(); // 부분집합 B

            cnt = 0; // 사람 수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 1) {
                        group.add(new int[]{i, j});
                        cnt++; // 1이 있으면 사람 수 cnt!
                    }
                    // 계단1, 2의 좌표 저장
                    if (map[i][j] > 1) {
                        stairs.add(new int[]{i, j, map[i][j]});
                    }
                }
            }

            result = Integer.MAX_VALUE;
            // 2개의 부분집합으로 나누기 -> 비트마스킹
            for (int i = 0; i < (1 << cnt); i++) {

                for (int j = 0; j < cnt; j++) {
                    // 비트마스킹 & 연산 결과 양수라면, groupA
                    if ((i & (1 << j)) > 0) {
                        groupA.add(new int[]{i, j});
                    }
                    // 0이라면, groupB
                    else {
                        groupB.add(new int[]{i, j});
                    }
                }
                // 거리 저장
                dist_A = new ArrayList<>();
                dist_B = new ArrayList<>();

                // groupA -> 1번 계단으로
                for (int j = 0; j < groupA.size(); j++) {
                    int width = Math.abs(groupA.get(j)[0] - stairs.get(0)[0]);
                    int height = Math.abs(groupA.get(j)[1] - stairs.get(0)[1]);
                    dist_A.add(width + height);
                }

                // groupB -> 2번 계단으로
                for (int j = 0; j < groupB.size(); j++) {
                    int width = Math.abs(groupB.get(j)[0] - stairs.get(1)[0]);
                    int height = Math.abs(groupB.get(j)[1] - stairs.get(1)[1]);
                    dist_B.add(width + height);
                }

                // 거리 오름차순 정렬
                Collections.sort(dist_A);
                Collections.sort(dist_B);

                // 디버깅
                System.out.println(dist_A);
                System.out.println(dist_B);

                // 계단 내려가기
                int A = stairs.get(0)[2];
                int j = A;

                while (j < dist_A.size()) {
                    // end[i] 와 start[i+계단길이] 비교
                    if (dist_A.get(j - A) + A <= dist_A.get(j)) {
                        i++;
                    } else {
                        for (int k = dist_A.size() - 1; k >= j; k--) {
                            int tmp = dist_A.get(k); // j+1부터 모두 1을 더해줌
                            dist_A.remove(k);
                            dist_A.add(k, tmp + 1);
                        }
                    }
                }

                int B = stairs.get(1)[2];
                j = B;
                while (j < dist_B.size()) {
                    // end[i] 와 start[i+계단길이] 비교
                    if (dist_B.get(j - B) + B <= dist_B.get(j)) {
                        j++;
                    } else {
                        for (int k = dist_B.size() - 1; k >= j; k--) {
                            int tmp = dist_B.get(k); // j+1부터 모두 1을 더해줌
                            dist_B.remove(k);
                            dist_B.add(k, tmp + 1);
                        }
                    }
                }
                result = Math.min(result, A);
                result = Math.min(result, B);
//                System.out.print(result + ", ");
            }
            System.out.println("#" + t + " " + result);
        } // t
    } // main
} // class

