import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_24444_huiju {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//정점 수
		int m = sc.nextInt();	//간선 수
		int r = sc.nextInt();	//시작 정점
		
		visited = new boolean[n+1];	//인덱스0은 비워둠
		order = new int[n+1];
		list = new ArrayList<>();
		queue = new LinkedList<>();
		
		//리스트 안 리스트의 객체 생성
		for(int i=0; i<=n; i++) {	
			list.add(new ArrayList<>());
		}
		
		//간선 연결
		for(int i=0; i<m; i++) {	//주어진 간선의 개수만큼 반복
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			list.get(num1).add(num2);
			list.get(num2).add(num1);
			
		}
		
		//리스트 안 리스트의 요소들을 정렬
		for(int i=0; i<list.size(); i++) {	
			list.get(i).sort(null);
		}
		
		bfs(r);
		
		for(int i=1; i<order.length; i++) {
			System.out.println(order[i]);
		}
		
		
	}

	static boolean[] visited; 	//정점 수만큼 방문여부를 표시할 배열 
	static int[] order;	//순서를 저장할 배열
	static int cnt;	//순서를 업데이트할 변수
	static Queue<Integer> queue;
	static ArrayList<ArrayList<Integer>> list;	//각 요소의 객체로 ArrayList를 갖는 리스트
	
	static void bfs(int root) {
		//1번째 노드
		//방문했으니 true로 바꿈
		visited[root] = true;
		//순서 업데이트 후 배열에 저장
		order[root] = ++cnt;
		//큐에 저장
		queue.offer(root);
		
		//2번째~ 노드
		//큐가 빌 때까지 반복
		while(!queue.isEmpty()) {
			//큐에서 요소를 꺼냄
			int pop = queue.poll();	//그냥 pop이 더 알아보기 쉬워서,,
			for(int num : list.get(pop)) {
				//아직 방문하지 않은 노드를 찾은 경우
				if(!visited[num]) {
					//true
					visited[num] = true;
					//++cnt
					order[num] = ++cnt;
					//큐에 저장
					queue.offer(num);
					
				}
			}
		}
		
		
	}
}














