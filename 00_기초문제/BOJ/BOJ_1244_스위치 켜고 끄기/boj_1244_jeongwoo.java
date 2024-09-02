import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 스위치 개수 입력
        int n = sc.nextInt();

        // 스위치 상태(0또는 1) -> 배열 생성
        // index값과 학생 번호 같도록 n+1로 설정
        int[] switches = new int[n+1];

        // 스위치 초기값 입력
        for (int i = 1; i <= n; i++)
            switches[i] = sc.nextInt();

        // 학생 수 입력
        int students = sc.nextInt();

        for (int i = 0; i < students; i++) {
            int gender = sc.nextInt();  // 학생 성별
            int num = sc.nextInt();     // 학생이 받은 번호

            // 남학생인 경우
            if (gender == 1)
                for (int j = num; j <= n; j += num)
                    // 스위치가 1이면 0으로, 0이면 1로
                    switches[j] = switches[j] == 1 ? 0 : 1;

            // 여학생인 경우
            else if (gender == 2) {
                // 자신의 번호는 먼저 바꿈
                switches[num] = switches[num] == 1 ? 0 : 1;

                // 좌우 한칸씩 비교하며 바꾸기
                for (int j = 1; j < n; j++) {
                    if (num - j <= 0 || num + j >= n+1 || switches[num-j] != switches[num+j])
                        break;
                    else if (switches[num-j] == switches[num + j]) {
                        switches[num-j] = switches[num-j] == 1 ? 0 : 1;
                        switches[num+j] = switches[num-j];
                    }
                }
            }
        } // for i

        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0)
                System.out.println();
        }
    } // main
}  // done
