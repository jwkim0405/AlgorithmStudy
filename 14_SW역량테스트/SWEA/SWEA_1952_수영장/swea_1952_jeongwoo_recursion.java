package PT_0903;

import java.util.Scanner;

public class swea_1952_수영장 {
    static int d, m, q, y; // d: day권, m: month 권, q: quarter권, y: year권
    static int[] pool; // 월별 수영장 이용 횟수 * 일일권 가격
    static int min; // 1년 이용 가격 최소값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            // 이용권 가격 설정
            d = sc.nextInt();
            m = sc.nextInt();
            q = sc.nextInt();
            y = sc.nextInt();

            min = Integer.MAX_VALUE;
            pool = new int[13]; // 1 ~ 12월 이용 횟수

            // 월별 이용 횟수 입력받고 월별 이용횟수와 곱해주기
            for (int i = 1; i <= 12; i++) {
                pool[i] = sc.nextInt() * d; // 일일권 가격 * 월별 이용 횟수
            }

            find_min(0, 0);
            min = Math.min(min, y); // 1년권과 최소값 비교

            System.out.println("#" + t + " " + min);
        }
    }

    static void find_min(int month, int sum) {
        // 기저 조건 1
        // 최소값보다 크다면, 중간에 return해라.
        if (sum > min || month > 12)
            return;

        // 12월까지 다 봤다면, return
        if (month == 12) {
            if (min > sum) min = sum;
            return;
        }

        // 재귀 부분
        // find_min(1, sum + pool[1]) : 1월까지 이용한 합
        // day
        find_min(month+1, sum + pool[month+1]);

        // month
        find_min(month+1, sum + m); // 1달권 더하기

        // quarter
        find_min(month+3, sum + q); // 3달권 더하기

        // year는 main method 내에서 마지막에 1번 비교
    }
}
