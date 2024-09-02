import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String seats = sc.next();
        int l_cnt = 0;
        for (int i = 0; i < N; i++)
            if (seats.charAt(i) == 'L')
                l_cnt++;

        if (l_cnt == 0)
            System.out.print(N);
        else
            System.out.print(N + 1 - (l_cnt / 2));

    }
}

