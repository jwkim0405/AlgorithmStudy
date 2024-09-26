import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class Edge {
        int A, B, W;

        public Edge(int a, int b, int w) {
            W = w;
            B = b;
            A = a;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "A=" + A +
                    ", B=" + B +
                    ", W=" + W +
                    '}';
        }
    }
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 시작 정점
            int B = sc.nextInt(); // 도착 정점
            int W = sc.nextInt(); // 가중치
            edges[i] = new Edge(A, B, W);
        } // 입력 완료

//        for (Edge e: edges) {
//            System.out.println(e);
//        }

        // 크루스칼 1: 가중치 순으로 오름차순 정렬하기
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.W - o2.W;
            }});
//        for (Edge e: edges) {
//            System.out.println(e);
//        }

        // 크루스칼 2: 사이클이 발생하지 않게 N-1개의 간선 뽑기
        p = new int[V+1];
        for (int i = 1; i <= V; i++) {
            makeSet(i);
        }

        int ans = 0;
        int pick = 0; // 내가 뽑은 간선의 개수

        for (int i = 0; i < E; i++) {
            int x = edges[i].A;
            int y = edges[i].B;

            if (findSet(x) != findSet(y)) {
                union(x, y);
                ans += edges[i].W;
                pick++;
            }

            if (pick == V-1) break;
        }
        System.out.println(ans);

    }
    static void makeSet(int x) {
        p[x] = x;
    }

    static int findSet(int x) {
        if (x == p[x]) return x;
        else {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }
}

