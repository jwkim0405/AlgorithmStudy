package 의석이의_세로로_말해요;

import java.io.IOException;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        /*
         * 영어 대문자 'A'~'Z'
         * 영어 소문자 'a'~'z'
         * 숫자 '0'~'9'
         * 수평으로 일렬로 붙여서 단어를 만듬
         * 5개(5줄)
         * 한 단어에 들어있는 글자 개수는 가변
         * 
         * => 단어를 세로로 읽음
         * 자리에 글자가 없는 경우 건너뛰고 그 다음 칸의 글자를 읽음
         * 이 세로로 읽은 글자를 공백 없이 출력
         * 
         * 첫 줄에 테케 개수 T
         * 각 테케 5줄 
         * 각 줄에 1~15 문자열(공백 없음)
         * 출력 #t 세로읽은문자열
         */
         
        /*
         * 1. 테케 개수 받고 그 만큼 반복
         * 2. 5개의 String 받고 그 중 최대 길이 도출
         * 3. 최대 길이 N으로 NxN 2차원 배열 생성
         * 4. 그 속에 charAt()으로 하나씩 넣다가 str.length < N일때 나머지를 '*'로 채우기
         * 5. 2중 for문으로 arr[j][i] 읽어서 행 우선 순회로 값 출력, 그 값이 '*'이면 continue
         * 6. 값들을 result String에 더해서 출력
         */
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int test_case = 1; test_case<= T; test_case++) {
            String[] lines = new String[5]; // 각 줄(단어)을 저장할 배열
            int maxLength = 0; // 각 단어의 길이 중 최댓값
             
            for(int i = 0; i < 5; i++) {
                lines[i] = sc.next();
                if(maxLength < lines[i].length()) maxLength = lines[i].length();
            }
             
            // 글자판 만들기
            char[][] wordboard = new char[maxLength][maxLength]; 
             
            for(int i = 0; i < 5; i++) {
                String line = lines[i];
                for(int j = 0; j < maxLength; j++) {
                    if(j >= line.length()) { // 글자 크기보다 더 큰 배열에는 *로 채워넣기
                        wordboard[i][j] = '*';
                        continue;
                    }
                     
                    wordboard[i][j] = line.charAt(j);                   
                }               
            }
             
            String result = "";
            // 세로로 읽기
            for(int j = 0; j < maxLength; j++) {
                for(int i = 0; i < 5; i++) {
                    if(wordboard[i][j] == '*') continue;
                    else result += wordboard[i][j];
                }
            }
             
            System.out.printf("#%d %s\n", test_case, result);
 
        }
         
         
    }
     
     
}