import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); // 요세푸스 순열을 만들어줄 SB
        sb.append("<");
        Queue<Integer> queue = new LinkedList<>(); // 원형 사람을 저장할 queue

        int N = sc.nextInt();
        int K = sc.nextInt();

        // 순서대로, 원형으로 사람 세우기
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // N번 반복해서 모든 사람 빼기
        // k번째 사람 요세푸스 순열에 넣고 나머지는 다시 원래 순서대로(원형 기준)
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                if(j < K-1) { // k-2까지는 다시 원래 순서대로
                    queue.offer(queue.poll());
                } else {
                    if(i < N-1) { // 요세푸스 순열이 끝나기 전에 양식 맞춰주기
                        sb.append(queue.poll());
                        sb.append(", ");
                    } else { // 마지막 사람
                        sb.append(queue.poll());
                        sb.append(">");
                    }

                }
            }
        }

        String result = sb.toString();
        System.out.println(result);

    }
}