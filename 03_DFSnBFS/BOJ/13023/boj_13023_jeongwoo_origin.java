// 초기 제출 코드
// 메모리 24000KB
// 메모리 더 적게 사용하는 이유?

import java.util.*;

public class Main {
    static ArrayList<Integer>[] v;
    static boolean[] visited;
    static boolean isConnected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        v = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            v[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        for (int i = 0; i < K; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            // 간선 연결 정보 저장
            v[num1].add(num2);
            v[num2].add(num1);
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            isConnected = false;
            search(i, 1);
            visited[i] = false;
            if (isConnected) {
                result = 1;
                break;
            }
        }

        // 결과 출력
        System.out.println(result);

    }
    static void search(int root, int depth) {
        visited[root] = true;
        // 깊이가 5 이상이면 함수 종료
        if (depth >= 5) {
            isConnected = true;
            return;
        }

        // 연결된 정점들 탐색
        int size = v[root].size();
        for (int i = 0; i < size; i++) {
            int item = v[root].get(i);
            if (!visited[item]) { // 방문 안했다면 가서 탐색
                search(item, depth+1);
                visited[item] = false; // backtracking
            }
        }

    }
}


