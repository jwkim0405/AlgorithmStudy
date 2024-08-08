import java.util.Scanner;

public class boj_2941_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        
        // 단어의 길이
        int num = word.length();
        
        // 단어의 각 문자를 검사한다.
        for (int i = 0; i < word.length(); i++) {
            char alpha = word.charAt(i);
            
            // '=' 또는 '-' 또는 'j'가 포함된 경우
            if (alpha == '=' || alpha == '-' || (alpha == 'j' && i > 0 && (word.charAt(i-1) == 'l' || word.charAt(i-1) == 'n'))) {
                num--; // 단어의 길이에서 1을 뺀다.
            }
            
            // 'dz='가 포함된 경우
            if (alpha == '=' && i > 1 && word.charAt(i-1) == 'z' && word.charAt(i-2) == 'd') {
                num--; // 추가로 1을 더 뺀다.
            }
        }
        
        // 결과 출력
        System.out.println(num);
    }
}

