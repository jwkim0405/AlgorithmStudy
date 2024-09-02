import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	// 방문 집합 static
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();	
	static int cnt;
	
	static void dfs(int[] cntArr, ArrayList<ArrayList<Integer>> V, int R) {
		// 1. 방문 표시, 방문한 순서 저장
		visited[R] = true;
		cnt++;		
		cntArr[R] = cnt;
		
		// 2. 반복문으로 R과 관련된 모든 정점을 탐색한다(오름차순)
		Collections.sort(V.get(R));	
		
		for(int vertex : V.get(R)) {
			// 3. 그 중에서 방문하지 않은 곳을 재귀로 방문한다
			if(visited[vertex] == false) dfs(cntArr, V, vertex);
		}		
	}
	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		Scanner sc = new Scanner(System.in);
		/*
		 * N개의 정점
		 * M개의 간선(양방향)
		 * 무방향 그래프
		 * 간선 가중치 1
		 * 정점 R
		 * 오름차순 DFS 
		 */
		
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int R = sc.nextInt(); // 시작 정점
		
		// 정점 집합 V 
		ArrayList<ArrayList<Integer>> V = new ArrayList<>(); 
		// 정점 집합 초기화
		for(int i = 0; i <= N; i++) { // 1부터 시작, N까지 채워야됨
			V.add(new ArrayList<Integer>());
		}
		
		// 방문 집합 초기화
		visited = new boolean[N+1];
		
		// 간선에 따른 관계 저장
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			V.get(a).add(b); // get한 정점에 add 정점의 관계 생성
			V.get(b).add(a); // 양방향 관계
		}
		
		int[] cntArr = new int[N+1];
		dfs(cntArr, V, R);
		
		
		
		// visited 중 false가 있다면 그 노드 번호 찾기
		for(int i = 1; i <= N; i++) {
			if(visited[i] == false) cntArr[i] = 0;
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(cntArr[i] + "\n");
		}
		
		String result = sb.toString();
		System.out.println(result);
	}

}
