import java.util.Scanner;

public class swea_3234_yuyoung {
    static int count; // 경우의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 무게 추의 개수
            int[] weights = new int[N]; // 무게 추의 무게
            for(int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
            }

            count = 0;
            // 초기 인덱스 0, 왼쪽 저울의 초기 무게 0, 오른쪽 저울의 초기 무게 0
            backtracking(weights, N, 0, 0, 0);
            
            System.out.println("#" + tc + " " + count);
        }
        
    }

    // 주어진 무게 추들을 왼쪽 또는 오른쪽 저울에 배치하는 모든 경우를 탐색
    public static void backtracking(int[] weights, int N, int index, int lWeight, int rWeight) {
        // 모든 무게 추를 사용한 경우
        if(index == N) {
            count++; // 경우의 수 증가
            return;
        }

        // 왼쪽 저울에 추가
        backtracking(weights, N, index + 1, lWeight + weights[index], rWeight);

        // 오른쪽 저울이 왼쪽 저울보다 무거워지지 않는 경우에만 오른쪽에 추가
        if(rWeight + weights[index] <= lWeight) {
            backtracking(weights, N, index + 1, lWeight, rWeight + weights[index]);
        }
    }
}
