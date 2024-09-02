import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static boolean[] visited; // 방문 여부
    static int cnt = 0;
    static ArrayList<Integer>[] arr; // 노드와 간선 관계 담을 arraylist 2차원 배열
    static Queue<Integer> queue; // bfs 탐색 큐


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드 수
        int M = sc.nextInt(); // 간선 수
        int R = sc.nextInt(); // 탐색 시작 노드

        // 모든 static 배열 초기화
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        queue = new LinkedList<>();

        // arr[i] 배열에 각각 arraylist 객체 생성
        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();

        // 간선 연결 정보 arr 배열에 저장
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        // 각 배열 오름차순 정렬
        for (int i = 1; i <= N; i++)
            arr[i].sort(null);

        dfs(R);
        System.out.println();
        // visited 배열 모두 false로 변환
        for (int i = 1; i <= N; i++)
            visited[i] = false;
        bfs(R);


    }

    static void dfs(int root) {
        visited[root] = true;
        System.out.print(root + " ");
        for (int num: arr[root]) {
            if(!visited[num]) {
                dfs(num);
            }
        }
    }

    static void bfs(int root) {
        visited[root] = true;
        queue.offer(root);


        while(!queue.isEmpty()) {
            int item = queue.poll();
            System.out.print(item + " ");
            int size = arr[item].size();
            for (int i = 0; i < size; i++) {
                int temp = arr[item].get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
    }
}

