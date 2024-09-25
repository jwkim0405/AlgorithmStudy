// 위상정렬 이용하는 문제
// 험난한 여정: 메모리 초과 -> 시간초과 -> Solve !
// 메모리초과(Queue, 인접행렬 이용 => 위상정렬 구현)
    // 인접행렬 Adjarr[N+1][N+1]
    // N(1 ≤ N ≤ 32,000)
    // N * N = 1,024,000,000 (10억)

// Solve
    // 인접리스트 adjList
    // ArrayList 배열을 만들었음
    // List<Integer>[] adjList = new ArrayList[N+1];
    // 연결된 정점만 저장! => 공간 많이 아낌!
    // 그리고 위상졍렬(queue) => 연결된 곳만 for문 돌면서 inDegree--

import java.util.*;

public class boj_2252_jeongwoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 학생 수
        int M = sc.nextInt(); // M명
        int[] inDegree = new int[N+1]; // 진입차수
        Queue<Integer> queue = new LinkedList<>(); // 진입 차수 0 담을 queue
        List<Integer>[] adjList = new ArrayList[N + 1]; // arrayList 배열 생성
        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        // 연결된 간선 저장
        for (int i = 0 ; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adjList[A].add(B);
            inDegree[B]++;
        } // 입력 완료

        // 진입 차수가 0인 정점 queue에 저장
        for (int i = 1; i <= N; i++) {
             if (inDegree[i] == 0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int curr = queue.poll(); // 이제 queue에서 하나씩 빼면서!
            sb.append(curr).append(" ");
            // curr -> i 연결 : inDegree[i] 진입차수 -1
            for (int next : adjList[curr]) {
                inDegree[next]--; // 진입차수 - 1
                // 진입차수가 0이 된다면 queue에 넣기
                if (inDegree[next] == 0) queue.offer(next);
             }
        }
        System.out.println(sb);

    }
}
