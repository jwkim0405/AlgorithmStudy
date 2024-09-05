import java.util.LinkedList;
import java.util.Scanner;


public class Solution {
    static int[] weight;
    static int N; // 무게 추 개수
    static int cnt; // 총 경우의 수
    static boolean[] visited;
    static LinkedList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            weight = new int[N]; // 각각의 추 무게
            visited = new boolean[N];
            list = new LinkedList<>(); // 각각의 순서대로 담긴 N개의 추
            cnt = fact(N); // 총 경우의 수

            for (int i = 0; i < N; i++)
                weight[i] = sc.nextInt(); // 추의 각 무게

            comb(0);
            System.out.println("#" + t + " " + cnt);
        }

    }

    // 조합
    static void comb(int depth) {
        // 기저 조건
        if (depth == N) {
            // 한 가지의 순서가 정해지고, 전체 값이 담겼음
            find_result();
            return;
        }

        // 재귀 부분
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                list.push(weight[i]);

                comb(depth + 1); // 재귀

                visited[i] = false; // backtracking
                list.poll();
            }
        }
    }

    static void find_result() {
        // Left에 들어갈지, Right에 들어갈지 결정
        // 비트마스킹 & 연산 1 이상인 경우 Left, 0인 경우 Right

        NEXT:
        for (int i = 1; i < (1 << N)-1; i++) {
            // 마지막 => 왼쪽에 모두 다 있음
            int sum = 0; // 음수가 나오는 순간 return
            for (int j = 0; j < N; j++) {
                // 1 이상인 경우, Left
                if ((i & (1 << j)) > 0) {
                    sum += list.get(j);
                } else {
                    sum -= list.get(j);
                    if (sum < 0) continue NEXT; // 만약 오른쪽이 더 커지면, 바로 반환
                }
            }
            cnt++; // for문을 N번 돌고 나오면, cnt++
        }
    }

    static int fact(int x) {
        int res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }
}
