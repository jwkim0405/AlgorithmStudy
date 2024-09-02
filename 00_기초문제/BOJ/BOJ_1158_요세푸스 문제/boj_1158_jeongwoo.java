import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt(); // 사람 수
        int K = sc.nextInt();  // 주기

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N];

        // queue에 숫자의 개수만큼 순서대로 입력
        for (int i = 1; i <= N; i++)
            queue.offer(i);

        // K번째 수 poll
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                queue.offer(queue.poll());
            } result[i] = queue.poll();
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < N-1; i++)
            sb.append(result[i]).append(", ");
        sb.append(result[N-1]).append('>');
        System.out.println(sb);
    }
}

