import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int time; // 총 지나간 시간 체크
    static long[] portpass; // 입국 심사대 Tk 배열
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 심사대 개수
        M = sc.nextInt(); // 친구 명수

        portpass = new long[N];

        for(int i = 0; i < N; i++) {
            portpass[i] = sc.nextInt();
        } // Tk

        Arrays.sort(portpass); // 정렬

        long left = 1L; // 최소 시간 1
        long right = portpass[N-1] * M; // 최대 시간 가장 오래 걸리는 심사대에서 모든 사람 심사

        long ans = binarySearch(left, right);

        System.out.println(ans);

    } // main

    public static long binarySearch(long left, long right) {
        while(left <= right) { // 이진 검색
            long mid = (left + right) / 2; // 걸리는 시간의 중간값

            long sum = 0L;
            for(int i = 0; i < N; i++) { // 심사대에 사람 분배
                sum += (mid / portpass[i]); // 각 심사대에서 해당 시간 안에 최대한 심사할 수 있는 인원 수
                if(sum >= M) { // 처리 가능하면
                    right = mid-1;
                    break; // for문 중단, 더 작은 값 찾아서 검색
                }
            }

            // 처리 불가능하면
            if(sum < M) left = mid+1; // 처리 가능한 최소값 찾아서 더 큰 쪽 검색
        } // while문 (이진검색) 종료
        return left;
    }
}
