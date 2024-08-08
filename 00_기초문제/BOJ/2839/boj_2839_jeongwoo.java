import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = sugar(N); 
        System.out.print(result);
    }

    static int sugar(int n) { // 배달 횟수
        int five = n / 5; // 5개씩 배달하는 횟수
        int three = 0; // 3개씩 배달하는 횟수
        int remainder;  // 5개씩 배달하고 남은 개수
        while(true) {
            remainder = n - 5 * five;
            if (remainder % 3 == 0) {
                three = remainder / 3;
                break;
            } five--; // 3으로 나누어떨어지지 않으면 5의 개수 -1
        }
        if (five >= 0 && three >= 0)  return five+three; // 5의 개수와 3의 개수 모두 0개 이상으로 구성할 수 있으면 출력
        else return -1; // 하나라도 음수 개수가 나오면 -1
    }
}

