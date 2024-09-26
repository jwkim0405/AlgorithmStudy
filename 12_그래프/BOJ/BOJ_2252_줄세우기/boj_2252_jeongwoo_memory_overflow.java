import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 학생 수
        int M = sc.nextInt(); // M명
        int[][] adjArr = new int[N+1][N+1]; // 인접행렬
        int[] degree = new int[N+1]; // 진입차수
        Queue<Integer> queue = new LinkedList<>(); // 진입 차수 0 담을 queue

        // 연결된 간선 저장
        for (int i = 0 ; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adjArr[A][B] = 1;
            degree[B]++;
        } // 입력 완료

        // 진입 차수가 0인 정점 queue에 저장
        for (int i = 1; i <= N; i++) {
             if (degree[i] == 0) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int curr = queue.poll(); // 이제 queue에서 하나씩 빼면서!
            sb.append(curr).append(" ");
            // curr -> i 연결 : degree[i] 진입차수 -1
            for (int i = 1; i <= N; i++) {
                if (adjArr[curr][i] == 1) {
                    degree[i]--; // 진입차수 - 1
                    // 진입차수가 0이 된다면 queue에 넣기
                    if (degree[i] == 0) queue.offer(i);
                }
            }
        }
        System.out.println(sb);
    }
}

