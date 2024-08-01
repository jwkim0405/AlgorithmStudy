import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] score = new int[10]; // 점수 배열
        for (int i = 0; i < 10; i++) {
            score[i] = sc.nextInt(); // 점수 입력
        }
        
        int sum = 0; // 점수의 합을 저장할 변수
        
        for (int i = 0; i < 10; i++) {
            sum += score[i]; // 인덱스 0부터 점수의 합을 저장
            
            if (sum > 100) { // 합을 저장하다가 100을 넘어가면
                int difference1 = sum - 100; // 100을 넘었을 때 값과 100과의 차이
                int difference2 = 100 - (sum - score[i]); // 100을 넘기기 직전의 합과 100과의 차이
                
                if (difference1 == difference2) { // 두 개의 차이가 같다면
                    System.out.println(sum); // 더 큰 값인 sum 출력
                } else if (difference1 < difference2) {
                    System.out.println(sum);
                } else {
                    System.out.println(sum - score[i]);
                }
                return; // 결과를 출력하고 프로그램 종료
            }
        }
        
        // 반복문이 끝나도 합이 100을 넘지 않으면 최종 합 출력
        System.out.println(sum);
    }
}
