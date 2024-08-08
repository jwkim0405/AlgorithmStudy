import java.util.Scanner;

public class boj_3985_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt(); // 롤케이크 길이
        int N = sc.nextInt(); // 방청객 수
        
        int[] arr = new int[L + 1];
        for (int i = 0; i <= L; i++) {
            arr[i] = 1;
        } // 케이크 번호를 모두 1로 채우고
        
        int max1 = 0, max2 = 0;
        int max1_i = 0, max2_i = 0;
        
        // 방청객 번호 순으로
        for (int i = 1; i <= N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            // 1. 원한 개수가 가장 큰 값
            if (max1 < (end - start + 1)) {
                max1 = (end - start + 1);
                max1_i = i;
            }
            
            // 2. 실제 i번 방청객이 받은 개수
            // start부터 end까지 1로 채워진 값을 더한다.
            int cnt = 0;
            for (int j = start; j <= end; j++) {
                if (arr[j] == 1) {
                    cnt++;
                }
            }
            
            // 최대 받은 개수 갱신
            if (max2 < cnt) {
                max2 = cnt;
                max2_i = i;
            }
            
            // 가져간 만큼 개수를 0으로 처리
            for (int j = start; j <= end; j++) {
                arr[j] = 0;
            }
        }
        
        // 결과 출력
        System.out.println(max1_i);
        System.out.println(max2_i);
    }
}

