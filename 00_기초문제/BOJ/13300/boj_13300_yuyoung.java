import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 학생 수
        int K = sc.nextInt(); // 한 방에 들어갈 수 있는 최대 인원

        int[][] students = new int[2][7]; // 성별(2) x 학년(1~6)

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt(); // 성별 남:1, 여:0
            int Y = sc.nextInt(); // 학년 (1~6)
            students[S][Y]++; // 특정 학년과 성별에 해당하는 학생 수
        }

        int room = 0;

        for (int gender = 0; gender < 2; gender++) {
            for (int grade = 1; grade <= 6; grade++) {
                if (students[gender][grade] > 0) { // 해당하는 학생이 있다면
                    room += (students[gender][grade] + K - 1) / K; // 각 그룹의 학생수를 K로 나누고 올림 계산
                }   // 필요한 방의 수
            }
        }

        System.out.println(room);

    }
}

