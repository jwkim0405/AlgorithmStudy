import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드의 갯수
        int M = sc.nextInt(); // 3장의 카드의 합이 가장 가까워야 하는 수
        int[] arr = new int[N]; // 카드에 들어갈 숫자 배열
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt(); // 카드에 들어갈 숫자 입력
        }
        
        int closestSum = 0; // 가장 가까운 합을 저장할 변수
        
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k]; // N장 중 3장의 카드에 적힌 수의 합
                    if(sum <= M && (M - sum < M - closestSum)) { // M보다 작거나 같고 가장 가까운 합을 찾기
                        closestSum = sum; // 가장 가까운 합을 업데이트
                    }
                }
            }
        }
        
        System.out.println(closestSum);       
    }
}
