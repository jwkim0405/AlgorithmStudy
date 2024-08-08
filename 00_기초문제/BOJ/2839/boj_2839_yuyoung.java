import java.util.Scanner;

public class boj_2839_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 설탕 N kg
        int fiveNum = N / 5; // 5kg 봉지의 개수
        int restNum;
        int threeNum;
        int finalNum = -1; // 계산이 안될 경우 -1 출력
        
        while (fiveNum >= 0) {
            restNum = N - (5 * fiveNum); // 5kg 봉지에 넣고 남은 양
            if (restNum % 3 == 0) { // 남은 양이 3kg 봉지로 나누어 떨어지는 경우
                threeNum = restNum / 3;
                finalNum = fiveNum + threeNum; // 총 봉지 수
                break;
            }
            fiveNum--; // 5kg 봉지 개수를 줄여서 다시 시도
        }
        
        System.out.println(finalNum); // 결과 출력
    }
}
