import java.util.Scanner;

public class boj_2527_jeongwoo {
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new int[4];
        b = new int[4];
        for (int t = 0; t < 4; t++) {
            for (int i = 0; i < 4; i++)
                a[i] = sc.nextInt();

            for (int i = 0; i < 4; i++)
                b[i] = sc.nextInt();

            if (isD()) System.out.println("d");
            else if (isC()) System.out.println("c");
            else if (isB()) System.out.println("b");
            else System.out.println("a");
        }
    }

    static boolean isD() {
        // 오른쪽 왼쪽
        if (a[2] < b[0] || a[0] > b[2])
            return true;
        // 위쪽 아래쪽
        else if ((a[1] > b[3]) || (b[1] > a[3]))
            return true;
        return false;
    }

    static boolean isC() {
        if ((a[2] == b[0] && a[3] == b[1]) || (a[0] == b[2] && a[1] == b[3]))
            return true;
        else if ((a[0] == b[2] && a[3] == b[1]) || (a[2] == b[0] && a[1] == b[3]))
            return true;
        return false;
    }

    static boolean isB() {
        // 가로 선분
        if ((a[3] == b[1] && (b[0] < a[2] && b[2] > a[0])) || (b[3] == a[1] && (b[2] > a[0] && b[0] < a[2])))
            return true;
        // 세로 선분
        else if ((a[2] == b[0] && a[3] > b[1] && a[1] < b[3]) || (a[0] == b[2] && a[1] < b[3]) && a[3] > b[1])
            return true;
        return false;
    }
}