import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int V) {
        // BFS
        /*
        깊이 우선 탐색
        전위 순회 VLR
        Queue 사용
        1. 루트 노드 방문 후 큐에 삽입
        2. 반복문을 통해 전체 탐색
            3. 탐색 대상 꺼내기
            4. 탐색 대상에서 작업 수행
            5. 탐색 대상과 관계를 맺고 있는 대상들 큐에 삽입
         */
        Queue<Integer> queue = new LinkedList<>();
        visit[V] = true;
        queue.offer(V); // 탐색 순서표에 루트 노드 삽입

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur + " "); // Vertex

            if(nodes[cur].size() > 0) {
                // 값이 작은 노드부터 방문
                Collections.sort(nodes[cur]); // ArrayList도 List지..
                for(int node : nodes[cur]) {
                    if(!visit[node]) {
                        visit[node] = true;
                        queue.offer(node); // visit이 false면 queue에 offer
                    }
                }
            }
        }
    }

    static void dfsPreorder(int V) {
        // DFS
        /*
        너비 우선 탐색
        전위 순회 VLR
        재귀 사용
        1. 루트 노드 방문
        2. 작업 수행
        3. 탐색 대상과 관계를 맺고 있는 대상들에 1~2 수행
        4. 기저조건이 만족될 시 재귀 중단
            - 리프 노드에 다다라서 더 탐색할 수 없을 때
         */
            int cur = V;
            visit[V] = true;
            sb.append(cur + " "); // Vertex

            if(nodes[cur].size() > 0) { // 기저조건: 관계 노드가 없을 때
                // 값이 작은 노드부터 방문
                Collections.sort(nodes[cur]); // ArrayList도 List지..
                for(int node : nodes[cur]) {
                    if(!visit[node]) {
                        visit[node] = true;
                        dfsPreorder(node);
                    }
                }
            }        

    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 정점의 번호(루트 노드)

        // node는 어차피 index == value
        // 그럼 해당 index에 int[]로 간선 관계에 있는 노드들을 넣는다면?
        // 2중 ArrayList?
        nodes = new ArrayList[N+1]; // graph 만들기
        visit = new boolean[N+1]; // visit 만들기

        for(int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>(); // 해당 index를 value로 가지는 노드와 관계를 가지는 노드들을 모을 예정
        }

        // 간선 관계 넣기
        for(int i = 0; i < M; i++) {
            int node = sc.nextInt();
            int link = sc.nextInt();
            // 양방향 연결
            nodes[node].add(link);
            nodes[link].add(node);
        }

        // DFS
        dfsPreorder(V);

        sb.deleteCharAt(sb.length()-1);
        sb.append("\n");

        // visit 초기화
        Arrays.fill(visit, false);

        // BFS
        bfs(V);
        sb.deleteCharAt(sb.length()-1);

        String result = sb.toString();
        System.out.println(result);

    }
}
