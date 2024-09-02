import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_2309_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9]; // 난쟁이 9명의 키 배열
        
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt(); // 난쟁이 9명의 키 배열 입력
        }
        
        int sum = 0;
        // 난쟁이 9명의 키를 모두 더한 값 계산
        for (int i = 0; i < 9; i++) {
            sum += arr[i];
        }

        // 난쟁이 9명의 키 배열에서 7명의 키 합이 100이 되는 조합을 찾음
        out:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                // 2명의 키를 뺀 값이 100이라면
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0; // 제거할 키를 0으로 설정
                    arr[j] = 0; // 제거할 키를 0으로 설정
                    break out; // 두 값을 찾았으므로 루프 종료
                }
            }
        }

        // 결과 배열을 오름차순으로 출력
        Arrays.sort(arr); // -1, -1, 난쟁이 7명의 키
        for (int i = 2; i < 9; i++) { // 처음 두 값은 -1로 설정되었으므로 제외
            System.out.println(arr[i]);
        }
       
    }
}
