import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 정점 리스트
	static ArrayList<ArrayList<Integer>> V;
	// 정점 리스트의 인덱스와 노드 번호를 연결 해줄 map
	static Map<Integer, Integer> map = new HashMap<>(); 
	// 방문 리스트
	static boolean[] visited;
	// 방문 순서
	static int cnt;
	

	// BFS 메소드
	static void bfs(ArrayList<ArrayList<Integer>> V, int[] cntArr, int R) {
		// 방문 순서 queue 생성 
		Queue<Integer> queue = new LinkedList<>();
		// R queue에 넣기
		queue.offer(R);
		visited[R] = true;		
		
		// 반복문으로 queue가 빌 때까지
		while(!queue.isEmpty()) {
			// queue의 맨 앞 값 뽑기
			int cur = queue.poll();
			
			// 맨 앞 값과 관계가 있는 모든 접점 오름차순 정렬
			Collections.sort(V.get(map.get(cur)));
			// 방문하지 않았으면 queue에 넣기
			for(int node : V.get(map.get(cur))) {
				if(visited[node] == false) {					
					queue.offer(node);
					// 방문 체크
					visited[node] = true;
					cnt++;
					cntArr[node] = cnt; // cntArr의 idx == node 번호
				}
			}
		}

		
		
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		/*
		 * 너비 우선 탐색
		 * BFS
		 * N개 정점
		 * M개 간선
		 * 무방향 그래프
		 * 간선 가중치 1
		 * 정점 R에서 시작
		 * 오름차순 방문
		 */
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
								
		// 정점 리스트 초기화
		V = new ArrayList<>();
		
		// 간선을 받으면서 정점 리스트에 넣어주기
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// map에 a에 해당하는 노드의 번호와 그 노드가 가지는 arraylist에서의 인덱스를 저장
			// 만약 a가 이미 있다면, 그 arraylist로 들어가서 값을 추가
			if(!map.containsKey(a)) {
				map.put(a, V.size()); // a -> 노드 번호, V.size -> a가 할당된 list 인덱스				
				V.add(new ArrayList<>());
			} 						
			
			V.get(map.get(a)).add(b); // map.get(a) -> a를 key로 가지는 value=list 인덱스에 b 추가
			
			// 양방향 간선
			if(!map.containsKey(b)) {
				map.put(b, V.size());
				V.add(new ArrayList<>());
			}
			
			V.get(map.get(b)).add(a);
		}
				
		// 방문 순서 배열 만들기
		visited = new boolean[N+1];
		int[] cntArr = new int[N+1];
		
		cnt++;
		cntArr[R] = cnt;
		bfs(V, cntArr, R);
		
		for(int i = 1; i <= N; i++) {
			sb.append(cntArr[i]+"\n");
		}
		
		String result = sb.toString();
		System.out.println(result);
	}

}
