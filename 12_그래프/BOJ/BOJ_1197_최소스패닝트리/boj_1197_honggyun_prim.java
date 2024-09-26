import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    
    static class Edge implements Comparable<Edge> {
        int nodeA; // 나
        int nodeB; // 너
        int weight; // 가중치

        public Edge(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }

        // 가중치를 기준으로 정렬하기 위해
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    // 공백을 건너 뛰고 유효한 줄만 읽기
    static String validateLine(BufferedReader br) throws IOException {
        String line;
        while((line = br.readLine()) != null) {
            line = line.trim();
            if(!line.isEmpty()) {
                return line;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = validateLine(br);
        StringTokenizer st = new StringTokenizer(line, " ");

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        visited = new boolean[V+1]; // 방문 배열 초기화
        
        // 인접 리스트로 관리
        List<Edge>[] adjList = new ArrayList[V+1]; // 1번 노드부터 시작

        for(int i = 0; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++) {
            line = validateLine(br);
            StringTokenizer stTmp = new StringTokenizer(line, " ");

            // 신장 그래프는 무방향 그래프임!
            int nodeA = Integer.parseInt(stTmp.nextToken()); // A 노드
            int nodeB = Integer.parseInt(stTmp.nextToken()); // B 노드
            int weight = Integer.parseInt(stTmp.nextToken()); // 가중치


            // 인접 리스트에 정보 저장(나, 너, 가중치)
            Edge edgeA = new Edge(nodeA, nodeB, weight);
            Edge edgeB = new Edge(nodeB, nodeA, weight);
            adjList[nodeA].add(edgeA);
            adjList[nodeB].add(edgeB);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 뽑은 간선의 가중치를 저장할 우선순위 큐
        visited[1] = true;
        int ans = 0; // 정답 기록
        int pick = 1; // 뽑은 노드 개수

        pq.addAll(adjList[1]); // 1번 노드의 인접 노드를 전부 우선순위 큐에 넣음(가중치 기준 우선순위)
        while(pick != V) { // V개의 노드를 전부 보면 끝
            Edge e = pq.poll(); // 나(A)를 기준으로 가장 작은 가중치를 가진 간선 뽑아서 인접 노드(B) 확인하기
            if(visited[e.nodeB]) continue; // 도착지가 이미 방문했던 노드라면 패스

            // 방문한 적 없는 노드라면
            ans += e.weight; // 스패닝 트리에 거리 추가 (Greedy 알고리즘이라 최소값만 뽑아도 됨)
            visited[e.nodeB] = true; // B노드 방문 처리
            pick++; // 뽑았다!

            // 뽑은 노드의 인접 노드를 넣음(A의 남은 인접 노드들과 B의 인접 노드들 중 가중치 기준 우선순위 결정)
            pq.addAll(adjList[e.nodeB]);
        }

        System.out.println(ans);

        br.close();
    } // main
}
