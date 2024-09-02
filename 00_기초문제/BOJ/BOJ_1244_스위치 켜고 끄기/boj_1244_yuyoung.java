import java.util.Scanner;

public class boj_1244_yuyoung {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 스위치 갯수
        int[] arr = new int[N + 1]; // 스위치 상태 배열 (1번 인덱스부터 사용)
        
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt(); // 스위치 상태 입력
        }
        
        int sum = sc.nextInt(); // 총 학생 수
        
        for (int i = 0; i < sum; i++) {
            int S = sc.nextInt(); // 여학생인지 남학생인지 입력
            if (S == 1) { // 만약 남학생일 경우
                int M = sc.nextInt(); // 남학생이 받은 수 입력
                for (int j = M; j <= N; j += M) { // 스위치 끝까지 반복
                    arr[j] = (arr[j] == 1) ? 0 : 1; // 스위치 상태 변경
                }
            } else if (S == 2) { // 만약 여학생일 경우
                int G = sc.nextInt(); // 여학생이 받은 수 입력
                arr[G] = (arr[G] == 1) ? 0 : 1; // 본인 스위치 상태 변경
                for (int j = 1; G - j >= 1 && G + j <= N; j++) {
                    if (arr[G - j] == arr[G + j]) { // 받은 수 양 옆 값이 대칭이라면
                        arr[G - j] = (arr[G - j] == 1) ? 0 : 1; // 좌측 스위치 상태 변경
                        arr[G + j] = (arr[G + j] == 1) ? 0 : 1; // 우측 스위치 상태 변경
                    } else {
                        break; // 좌우 대칭이 없으면 중단
                    }
                }
            }
        }
        
        // 최종 스위치 상태 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
