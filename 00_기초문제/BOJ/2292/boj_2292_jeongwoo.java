package boj;

import java.util.Scanner;

public class boj_2292_jeongwoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res;
        int i = 0;
        int last_room = 1;
        while(true) {
            last_room += 6 * i;     // 첫 번째 둘레는 1, 두 번째 둘레는 2 ~ 7( = 1 + 6 *1 )
            if (N <= last_room) {
                System.out.print(i+1);  // i는 통과하는 방의 수이므로 시작하는 1번 방을 더해줘야 함!
                break;
            }
            else
                i++;
        }
    }
}
