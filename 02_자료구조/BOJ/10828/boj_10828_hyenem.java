import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack{
	int[] arr = new int[0];
	
	void push(int n) {
		arr = Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=n;
	}
	
	int pop() {
		if (arr.length!=0) {
			int n = arr[arr.length-1];
			arr = Arrays.copyOf(arr, arr.length-1);
			return n;
		}
		return -1;
	}
	
	int size() {
		return arr.length;
	}
	
	int isEmpty() {
		if(arr.length==0) {
			return 1;
		}
		return 0;
	}
	
	int top() {
		if(arr.length!=0) {
			return arr[arr.length-1];
		}
		return -1;
	}
	
}


public class Boj_10828_hyenem {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack stack = new Stack();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String doWhat = st.nextToken();
			if (doWhat.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if(doWhat.equals("pop")) {
				sb.append(stack.pop()+"\n");
			} else if (doWhat.equals("size")) {
				sb.append(stack.size()+"\n");
			} else if (doWhat.equals("empty")) {
				sb.append(stack.isEmpty()+"\n");
			} else if (doWhat.equals("top")) {
				sb.append(stack.top()+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}

