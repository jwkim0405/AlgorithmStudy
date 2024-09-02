import java.util.Scanner;

public class boj_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] students = new int[7][2]; // 학년별 남녀 학생 수
        int cnt = 0;    // 방 개수

        // students 배열에 값 할당
        for (int i = 0; i < n; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            students[grade][gender]++;
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (students[i][j] % k == 0)
                    cnt += students[i][j] / k;
                else
                    cnt += (students[i][j] / k) + 1;
            }
        }
        System.out.print(cnt);
    }
}
