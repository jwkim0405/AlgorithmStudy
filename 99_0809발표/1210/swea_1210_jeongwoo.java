import java.util.Scanner;
class Solution
{
    public static int left_traversal(int[][] data, int i, int j) {
        // 왼쪽이 0이 될 때까지 계속 왼쪽으로 가기
        if (j-1 >= 0 && data[i][j-1] == 1)
            return left_traversal(data, i, j-1);
        else
            return j;
    }
 
    public static int right_traversal(int[][] data, int i, int j) {
        // 오른쪽이 0이 될 때까지 계속 왼쪽으로 가기
        if (j+1 <= 99 && data[i][j+1] == 1)
            return right_traversal(data, i, j+1);
        else
            return j;
    }
 
    public static int traversal(int[][] data, int i, int j) {
        while (true) {
            // 마지막 행까지 내려간 경우 배열에 해당 값 반환(1 또는 2)
            if (i == 99) {
                return data[i][j];
            }
 
            // 왼쪽이 1일 경우
            if (j - 1 >= 0 && data[i][j - 1] == 1)
                j = left_traversal(data, i, j);
                // 오른쪽이 1일 경우
            else if (j + 1 <= 99 && data[i][j + 1] == 1)
                j = right_traversal(data, i, j);
 
            i += 1;
        }
    }
 
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                // test case 번호 입력
                int t = sc.nextInt();
 
                // 사다리 100 x 100 선언
                int[][] data = new int[100][100];
 
                // 사다리 100 x 100 초기화
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 100; k++) {
                        data[j][k] = sc.nextInt();
                    }
                }
 
                for (int n = 0; n < 100; n++) {
                    int m = 0;
                    int start_n = n;
 
                    int result = 0;
                    // data[m][0] == 1이면 탐색하기 시작 (아래로 내려감)
                    if (data[m][n] == 1)
                        result = traversal(data, m, n); // traversal을 통해 아래 끝까지 탐색함
 
                    if (result == 2) {
                        System.out.println("#" + t + " " + start_n);
                        break;
                    }
                }
 
            }
        }
 
}
