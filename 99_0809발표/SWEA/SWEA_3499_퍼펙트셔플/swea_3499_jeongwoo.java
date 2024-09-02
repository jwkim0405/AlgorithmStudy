import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] cards;
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            Queue front_queue = new Queue(); // 앞의 절반을 받을 queue
            Queue rear_queue = new Queue();  // 뒤의 절반을 받을 queue

            for (int i = 0; i < (N+1)/2; i++)
                front_queue.enQueue(sc.next()); // 앞쪽 절반의 카드 담은 큐

            for(int i = (N+1) / 2; i < N; i++)
                rear_queue.enQueue(sc.next());  // 뒤쪽 절반의 카드 담은 큐

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            for (int i = 0; i < N; i++) {
                if (isEven(i)) // 짝수라면
                    sb.append(front_queue.deQueue()).append(" ");
                else
                    sb.append(rear_queue.deQueue()).append(" ");
            }
            System.out.println(sb);
        }
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    static class Queue {
        List<String> queue = new ArrayList<>();
        int front = -1;
        int rear = -1;

        public Queue() {}

        void enQueue(String card) {
            rear++;
            queue.add(card);
        }

        String deQueue() {
            return queue.get(++front);
        }

        boolean isEmpty() {
            return front == rear;
        }

        int size() {
            return rear - front;
        }

    }
}

