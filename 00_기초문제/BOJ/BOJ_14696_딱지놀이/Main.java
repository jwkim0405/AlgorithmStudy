import java.util.Scanner;

public class Main {
    static int[] a_data; // a 딱지 종류별 개수
    static int[] b_data; // b 딱지 종류별 개수
    static final int SIZE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int t = 1; t <= N; t++)
        {
            // a 딱지 개수, 각각의 종류들 입력받기
            int a = sc.nextInt();
            a_data = new int[SIZE];
            for (int i = 1; i <= a; i++)
                a_data[sc.nextInt()]++; // b_data 배열을 만들지 않고, --로 해서 양수음수 판정해도 되구나!

            // a 딱지 개수, 각각의 종류들 입력받기
            int b = sc.nextInt();
            b_data = new int[SIZE];
            for (int i = 1; i <= b; i++)
                b_data[sc.nextInt()]++;

            char result = ddakji();
            System.out.println(result);
        }
    }

    static char ddakji() {
        for (int i = 4; i >= 1; i--) {
            if (a_data[i] > b_data[i]) return 'A';
            else if (a_data[i] < b_data[i]) return 'B';
        }
        return 'D';
    }
}

