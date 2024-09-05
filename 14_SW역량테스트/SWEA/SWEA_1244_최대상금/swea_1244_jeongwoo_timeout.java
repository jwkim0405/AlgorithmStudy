import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int score;
    static int num;
    static ArrayList<Integer> list;
    static int len;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            score = sc.nextInt(); // 초기 점수
            num = sc.nextInt(); // 교환 횟수
            max = Integer.MIN_VALUE;
            list = new ArrayList<>();
            // 각 자리 수를 int 배열로 변환
            while(score != 0) {
                int item = score % 10;
                list.add(item);
                score /= 10;
            }

            len = list.size(); // 숫자의 자리 수

            // 교환
            changeNum(0);
            System.out.println("#" + t + " "  + max);
        }
    } // main

    static void changeNum(int cnt) {
        // 기저 조건
        if (cnt == num) {
            int sum = 0;
            for (int i = len -1; i >= 0; i--) {
                sum = sum * 10 + list.get(i);
            }
            max = Math.max(max, sum);
            return;
        }

        // 재귀 부분
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                swap(i, j);
                changeNum(cnt+1);
                swap(i,j);
            }
        }
    }

    static void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
} // class

