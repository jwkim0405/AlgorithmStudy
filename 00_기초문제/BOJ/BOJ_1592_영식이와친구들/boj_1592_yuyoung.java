import java.util.Scanner;

public class boj_1592_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 원형 탁자에 앉는 사람 수
        int M = sc.nextInt(); // 한 사람이 최대로 받을 수 있는 공 갯수
        int L = sc.nextInt(); // 공을 받고 시계/반시계 방향으로 몇 번째 사람

        int[] arr = new int[N]; // 각 사람이 공을 받은 횟수를 저장하는 배열
        int cnt = 0; // 공을 던진 총 횟수
        int currentIndex = 0; // 현재 공을 가진 사람의 인덱스

        arr[currentIndex] = 1; // 첫번째 사람이 제일 먼저 공을 받음

        while (true) {
            if (arr[currentIndex] == M) {
                System.out.println(cnt); // 여태까지 공을 던진 횟수 출력
                break;
            }

            if (arr[currentIndex] % 2 != 0) { // 공을 받은 횟수가 홀수라면
                currentIndex = (currentIndex + L) % N; // 시계방향으로 L번째 사람
            } else { // 짝수라면
                currentIndex = (currentIndex - L + N) % N; // 반시계방향
            }

            arr[currentIndex] += 1; // 다음 사람이 공을 받음
            cnt++; // 공을 던진 횟수 증가
        }

    }
}
