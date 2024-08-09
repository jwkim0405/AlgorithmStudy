import java.util.Scanner;
 
public class Solution {
    static final int SIZE = 100;
    static String[] str; // 100x100 알파벳 => 100행의 String으로 선언
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int t = 1; t <= 10; t++) {
            int testCase = sc.nextInt();
            str = new String[SIZE];
             
            for(int i = 0; i < SIZE; i++)
                str[i] = sc.next(); // 배열에 값 할당
 
            boolean result; // 회문 검사 결과 저장
            // 길이 100짜리 회문부터 2짜리 회문까지 검사            
       OUT: for (int len = 100; len >= 1; len--) {
                for (int i = 0; i < SIZE; i++) { // 0~99행 탐색
                    for (int j = 0; j <= 100 - len; j++) { // 시작 열은 0 ~ (100 - len)까지 가능
                        if (isRowPalindrome(i, j, len)) { // 가로 탐색: 회문인지 검사 (시작 인덱스(i, j) ~ (i, j + len-1))
                            System.out.println("#" + testCase + " " + len);
                            break OUT;
                        }
                        // 세로 탐색
                        if (isColPalindrome(j, i, len)) { // 세로 탐색: 회문인지 검사 (시작 인덱스(i, j) ~ (i, j + len-1))
                            System.out.println("#" + testCase + " " + len);
                            break OUT;
                        }
                    }
                }
            }       
        }
    }
     
    // 가로 회문인지 검사하는 메서드
    static boolean isRowPalindrome(int i, int j, int len) { // i, j => 시작 인덱스의 행, 열
        for (int p = 0; p < len / 2; p++) 
        {
            if (str[i].charAt(j + p) != str[i].charAt(j + (len -1 - p))) // (처음, 끝)부터 비교하여 다르면 false 반환
                    return false;
        } 
        return true;
    }
     
    // 세로 회문인지 검사하는 메서드
    static boolean isColPalindrome(int i, int j, int len) { // i, j => 시작 인덱스의 행, 열
        for (int p = 0; p < len / 2; p++) 
        {
            if (str[i + p].charAt(j) != str[i + (len -1 - p)].charAt(j)) // (처음, 끝)부터 비교하여 다르면 false 반환
                    return false;
        } 
        return true;
    }
}
