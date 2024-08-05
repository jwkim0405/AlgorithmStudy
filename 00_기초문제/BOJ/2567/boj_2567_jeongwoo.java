import java.util.Scanner;

public class Main {
    static int SIZE = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 색종이 개수
        int[][] paper = new int[SIZE][SIZE]; // 가로 세로 100 크기의 정사각형

        // 색종이가 덮고있는 칸을 paper 배열에 넣어줌
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 10 x 10 크기의 색종이에 i번째 색종이 값 넣어주기
            for (int p = 0; p < 10; p++)
                for (int q = 0; q < 10; q++)
                    paper[x+p][y+q] = i;
        }

        // 상, 하, 좌, 우 델타탐색
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int sum = 0; // 총 둘레

        // (0,0)부터 (99,99)까지 순회하면서 색종이가 있는 각 칸의 상하좌우를 탐색하고, 비어있다면 둘레 + 1
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (paper[i][j] == 0) // 색종이가 덮어져있지 않다면, continue
                    continue;
                else { // 색종이가 덮여있다면, 상하좌우 델타탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        // 인덱스를 벗어나지 않게 조건 설정
                        if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && paper[nx][ny] == 0)
                            sum++;
                        // 100 x 100의 가장 가장자리는 따로 합해줌
                        // 델타탐색을 할 때, index가 -1또는 100이 되므로 위 if문에서 탐색 불가
                        if (nx == -1 || nx == SIZE || ny == -1 || ny == SIZE)
                            sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

