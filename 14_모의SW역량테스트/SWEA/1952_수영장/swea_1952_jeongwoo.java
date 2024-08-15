// 2시간 30분 소요
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int[] swim;
    static int d; // day price
    static int m; // month price
    static int q; // quarter(3-months) price
    static int y; // year price

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // number of testCase
        for (int t = 1; t <= T; t++) {
            d = sc.nextInt(); // day price
            m = sc.nextInt(); // month price
            q = sc.nextInt(); // quarter(3-months) price
            y = sc.nextInt(); // year price

            swim = new int[13]; // 1~12 index를 각 월로 사용

            // 월별 수영장 이용 횟수
            for (int i = 1; i <= 12; i++)
                swim[i] = sc.nextInt();

            min = Integer.MAX_VALUE;
            find_min(1, 0, 'd');
            find_min(1, 0, 'm');
            find_min(1, 0, 'q');

            // 3. 마지막, 1년권과 비교하기
            if (y < min) min = y;

            System.out.println("#" + t + " " + min);
        }
    }


    static void find_min(int now_month, int sum, char payment) {
        if (now_month == 12) {
            if (payment == 'd') sum += swim[12] * d;
            else if (payment == 'm')  sum += m;

            if (min > sum) min = sum;
            return;
        } else if (now_month == 10 && payment == 'q') {
            sum += q;
            if (min > sum)
                min = sum;
            return;
        }
        if (payment == 'd') {
            find_min(now_month+1, sum + swim[now_month]*d, 'd');
            find_min(now_month+1, sum + swim[now_month]*d, 'm');
            if (now_month <= 9)
                find_min(now_month+1, sum + swim[now_month]*d, 'q');
        }
        else if (payment == 'm') {
            find_min(now_month+1, sum + m, 'd');
            find_min(now_month+1, sum + m, 'm');
            if (now_month <= 9)
                find_min(now_month+1, sum + m, 'q');
        }
        else if (payment == 'q') {
            if (now_month + 3 <= 12) {
                find_min(now_month + 3, sum + q, 'd');
                find_min(now_month + 3, sum + q, 'm');
            }
            if (now_month + 3 <= 10)
                find_min(now_month+3, sum + q, 'q');
        }
    }
}
