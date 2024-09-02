import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int result = alphabetSum(str);
        System.out.print(result);
    }

    static int alphabetSum(String str) {
        int i = 0;
        int sum = 0;
        int len = str.length(); // str의 길이
        while (i < len) {
            // 마지막 인덱스 하나 남은 경우
            if (i == len - 1)
                return ++sum; // 무조건 단일 알파벳

            int c1 = str.charAt(i);
            int c2 = str.charAt(i + 1);

            if (i +2 <= len - 1 && c1 == 'd' && c2 == 'z' && str.charAt(i+2) == '=') // 1. dz=
              i += 3;
             else if ((c1 == 'c' || c1 == 's' || c1 == 'z') && c2 == '=') // 2. c=, s=, z=
                i+=2;
            else if ((c1 == 'c' || c1 == 'd') && c2 == '-') // 3. c-, d-
                i+=2;
            else if ((c1 == 'l' || c1 == 'n') && c2 == 'j') // 4. lj, nj
                i+=2;
            else
                i++;
            sum++; // if~else문을 돌면서 idx를 증가시켜준 후, 알파벳 개수 +1개
        }
    return sum;
    }
}

