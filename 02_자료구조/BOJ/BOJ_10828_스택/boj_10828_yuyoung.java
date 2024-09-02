import java.util.HashSet;
import java.util.Scanner;

public class boj_10828_yuyoung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정사각형 갯수
        HashSet<String> res = new HashSet<>(); // 고유한 직사각형을 저장할 집합

        for (int i = 1; i <= N; i++) { // 첫 번째 변
            for (int j = 1; j <= N; j++) { // 두 번째 변
                if (i * j <= N) { // 주어진 정사각형 갯수로 만들 수 있는 경우
                    int width = Math.min(i, j);
                    int height = Math.max(i, j);
                    res.add(width + "x" + height); // 집합에 직사각형 추가
                }
            }
        }
        
        System.out.println(res.size()); // 고유한 직사각형의 갯수 출력
    }
}
