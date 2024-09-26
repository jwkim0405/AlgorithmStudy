import java.util.*;

public class Main {
    static List<List<Integer>> ll = new ArrayList<>(); // 각 노드의 연결 정보를 저장할 리스트
    static StringBuffer sb = new StringBuffer();
    static int N; // 노드의 개수
    static int[] count; // 각 노드로 들어오는 간선의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 노드의 개수
        int M = sc.nextInt(); // 간선의 개수

        count = new int[N + 1];
        for (int i = 0; i <= N; i++)
            ll.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt(); // 출발 노드
            int B = sc.nextInt(); // 도착 노드

            ll.get(A).add(B); // A에서 B로의 간선 추가
            count[B]++; // B로 들어오는 간선의 개수 증가
        }

        // 위상 정렬
        topologicalSort();

        System.out.println(sb);
    }

    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드들을 큐에 추가
        for (int i = 1; i <= N; i++)
            if (count[i] == 0)
                q.offer(i);

        // 큐가 빌 때까지 위상 정렬 수행
        for (int i = 0; i < N; i++) {
            if (!q.isEmpty()) {
                int num = q.poll(); // 큐에서 노드를 꺼냄
                sb.append(num).append(" "); // 결과에 해당 노드를 추가

                // 해당 노드와 연결된 노드들의 진입 차수를 감소
                for (int j = 0; j < ll.get(num).size(); j++) {
                    count[ll.get(num).get(j)]--;

                    // 진입 차수가 0이 되면 큐에 추가
                    if (count[ll.get(num).get(j)] == 0)
                        q.offer(ll.get(num).get(j));
                }
            }
        }
    }
}
