import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarf = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
            sum += dwarf[i];
        }

        Arrays.sort(dwarf);

        // 가짜 난쟁이 2명 찾기
        OUT: for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                // 전체 키 합에서 2명의 값 빼면서 찾기
                if (sum - dwarf[i] - dwarf[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        else
                            System.out.println(dwarf[k]);
                    }
                    break OUT;
                }
            }
        }
    }
}

