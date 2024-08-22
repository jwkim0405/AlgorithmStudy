package BOJ_11403_경로찾기_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N; // 행과 열 길이
    static int[][] map; // 첫 노드 간 정보
    static boolean[] visited; // 방문 여부. dfs 시작 정점에 따라 초기화 필요
    static ArrayList<Integer>[] vector;
    static int[][] result; // 결과값 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 각 배열 생성
        map = new int[N][N];
        vector = new ArrayList[N]; // 각 정점에 연결된 정점들 저장
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            vector[i] = new ArrayList<Integer>();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = sc.nextInt();
                if (value == 1) {
                    map[i][j] = 1; // map에 값 할당
                    vector[i].add(j); // 값이 1이면 => vector에 저장
                }
            }
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            for(int j = 0; j < vector[i].size(); j++)
                dfs(i, vector[i].get(j));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            } System.out.println();
        }
    }

    static void dfs(int root, int item) {
        result[root][item] = 1;
        visited[item] = true;
        int size = vector[item].size();
        for (int i = 0; i < size; i++) {
            int next_item = vector[item].get(i);
            if (!visited[next_item]) // 방문 안 한 노드라면
                dfs(root, next_item); // dfs로 탐색
        }
    }
}

