package BOJ_3079_입국심사;

import java.util.*;

public class Main {
	static class table implements Comparable<table>{
		long time, acc;
		table(long time, long acc){
			this.time = time;
			this.acc = acc;
		}
		
		public int compareTo(table t) {
			return Long.compare(this.acc, t.acc);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		int[] arr = new int[N];
		PriorityQueue<table> tables = new PriorityQueue<>();
		
		Long max = 0l;
		for(int i = 0; i<N; i++) {
			long tmp = sc.nextLong();
			tables.offer(new table(tmp, tmp));
		}
		
		for(long m = 0; m<M; m++) {
			table tmp = tables.poll();
			max = tmp.acc;
			tmp.acc += tmp.time;
			tables.offer(tmp);
		}
		
		System.out.println(max);
	}
}

