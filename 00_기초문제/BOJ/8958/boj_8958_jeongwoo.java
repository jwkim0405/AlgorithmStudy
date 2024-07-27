import java.util.Scanner;

public class boj_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // test case의 개수

        for(int i = 0; i < T; i++) {
            String OX = sc.next();
            int cnt = 0; int sum = 0;

            for (int j = 0; j < OX.length(); j++) {
                if (OX.charAt(j) == 'O') sum += ++cnt;
                else cnt = 0;
            }
            System.out.println(sum);
        }
    }
}
