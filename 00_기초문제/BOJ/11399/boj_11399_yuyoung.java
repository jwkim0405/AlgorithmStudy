import java.util.Scanner;
import java.util.Arrays;

public class boj_11399_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 줄서있는 사람 수
        int[] arr = new int[N];
        
        // 각 사람이 돈을 인출하는데 필요한 시간 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 오름차순으로 정렬
        Arrays.sort(arr);
        
        int totalTime = 0;
        int waitTime = 0;
        
        // 각 사람이 기다린 시간의 총합 계산
        for (int i = 0; i < N; i++) {
            waitTime += arr[i]; // 현재 사람이 기다린 시간
            totalTime += waitTime; // 누적 대기 시간
        }

        System.out.println(totalTime);

    }
}
