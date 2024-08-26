import java.util.ArrayList;
import java.util.Scanner;

public class boj_24479_huiju {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//정점의 수
		int m = sc.nextInt();	//간선의 수
		int r = sc.nextInt();	//시작 정점
		
		visited = new boolean[n+1];
		order = new int[n+1];
		cnt = 1;	//미리 초기화..땡스투유영언니
		list = new ArrayList<>();
		
		//리스트 내부리스트 초기화
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		//간선 연결
		for(int i=0; i<m; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			list.get(num1).add(num2);
			list.get(num2).add(num1);
		}
		
		//내부리스트 정렬
		for(int i=0; i<list.size(); i++) {
			list.get(i).sort(null);
		}
		
		dfs(r);
		
		for(int i=1; i<order.length; i++) {
			System.out.println(order[i]);
		}
		
		
	}
	
	static boolean[] visited;	//방문 여부를 저장할 배열
	static int[] order;	//방문 순서를 저장할 배열
	static int cnt;	//방문 순서를 업데이트할 변수
	static ArrayList<ArrayList<Integer>> list;	//인접 노드를 저장할 리스트
	
	static void dfs(int root) {
		//visited를 true로 바꿈
		visited[root] = true;
		order[root] = cnt;
		//현재 노드의 인접 노드 탐색
		for(int i=0; i<list.get(root).size(); i++) {
			//첫 번째 노드를 새로 저장
			int pop = list.get(root).get(i);
			//해당 노드의 visited가 false일 경우 
			if(visited[pop] == false) {
				visited[pop] = true;
				++cnt;
				dfs(pop);
			}
			
		}
		
	}
}
