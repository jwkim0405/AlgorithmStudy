import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] time = new int[N];
        for (int i = 0; i < N; i++)
            time[i] = sc.nextInt();

        Arrays.sort(time);

        int sum = time[0];
        for (int i = 1; i < N; i++) {
            time[i] += time[i - 1];
            sum += time[i];
        }
        System.out.println(sum);
    }
}

