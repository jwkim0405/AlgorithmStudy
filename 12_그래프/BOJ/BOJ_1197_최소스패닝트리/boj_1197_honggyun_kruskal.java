import java.io.*;
import java.util.*;

public class Kruskal {
    static int[] p; // 서로소 집합의 대표자를 저장할 배열

    static class Edge implements Comparable<Edge>{
        int A;
        int B;
        int W;

        public Edge(int A, int B, int W) {
            this.A = A;
            this.B = B;
            this.W = W;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.W, o.W);
        }
    } // class Edge
    
    // br을 이용할 때 중간에 공백 줄을 제외하고 유효한 input 줄만 받기
    static String validateLine(BufferedReader br) throws IOException {
        String line;

        while((line = br.readLine()) != null) {
            line.trim();
            if(!line.isEmpty()) {
                return line;
            }
        }

        return null;
    } // validateLine

    // 크루스칼로 풀어봅시다
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = validateLine(br);
        StringTokenizer st = new StringTokenizer(line, " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        p = new int[V+1]; // 1번 노드부터 시작
        for(int i = 1; i <= V; i++) {
            p[i] = i; // makeSet(i)
        }

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            line = validateLine(br);
            StringTokenizer stTmp = new StringTokenizer(line, " ");
            int A = Integer.parseInt(stTmp.nextToken());
            int B = Integer.parseInt(stTmp.nextToken());
            int W = Integer.parseInt(stTmp.nextToken());

            Edge e = new Edge(A, B, W);
            edges.add(e);
        } // 간선 저장 끝

        // 크루스칼 알고리즘
        int ans = 0;
        int pick = 0;

        // 1. 모든 간선을 가중치에 따라 오름차순으로 정렬
        Collections.sort(edges);
        // 2. 가중치가 가장 낮은 간선부터 확인하면서 트리 확장
        for(Edge edge : edges) {
            int x = edge.A;
            int y = edge.B;
            int w = edge.W;
                        
            int px = findSet(x);
            int py = findSet(y);
            if(px != py) { // a. 사이클이 존재하지 않으면 선택 -> 존재하면 그 다음 최소 간선 확인 => Find-Set 연산으로 사이클 여부 확인
                union(px, py);
                ans += w;
                pick++;
            }

            // 3. N-1개의 간선이 선택될 때까지 반복
            if(pick == V-1) break;
        }

        System.out.println(ans);


    } // main

    // findSet
    static int findSet(int x) {
        if(x != p[x]) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    // union
    static void union(int x, int y) {
        if(x == findSet(x) && y == findSet(y)) {
            p[y] = x;
        }
    }

}