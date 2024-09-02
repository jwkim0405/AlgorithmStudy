import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 좌석의 수
        sc.nextLine(); // 버퍼 비우기
        String seats = sc.nextLine(); // 좌석 정보를 입력 (하나의 문자열로 입력 받기)
        
        int lCount = 0; // 'L'의 총 갯수
        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == 'L') { // 좌석에 존재하는 'L'의 갯수
                lCount++;
            }
        }
        
        // 'L'의 개수는 커플석을 의미하므로, 커플석은 L의 개수 / 2
        // 커플석의 개수만큼을 계산해서 컵홀더를 사용할 수 있는 사람의 수를 계산
        // 기본적으로 좌석의 수 + 1만큼 컵홀더가 존재
        int Cupholders = N + 1 - (lCount / 2);

        // 최대 컵홀더 수는 좌석 수와 같거나 그보다 많음
        int result = Math.min(Cupholders, N);
        
        System.out.println(result);
        
    }
}
