import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] paper = new int[7]; // 한 변의 길이가 1~6인 배열(인덱스 == 한 변의 길이)

        for (int i = 1; i <= 6; i++)
            paper[i] = sc.nextInt(); // 한 변의 길이가 i인 색종이의 개수

        int sum = 0; // 필요한 색종이의 총 개수
        sum += (paper[6] + paper[5] + paper[4]); // 1) 6x6, 5x5, 4x4 기본 count
        paper[1] -= 11 * paper[5]; // 2) 5 x 5 빈 칸 count (1x1밖에 못 들어옴)

        if (paper[1] < 0) paper[1] = 0;

        // 3) 4 x 4 빈 칸 count
        paper[2] -= paper[4] * 5;  // 4x4를 채우고 남은 칸에 2x2 5개를 채울 수 있다.
        if (paper[2] <= 0 && paper[1] > 0)  // 만약 2x2를 채우고 칸이 남았다면 해당 칸에 1x1 채움
            paper[1] -= Math.abs(paper[2]) * 4;

        if (paper[1] < 0) paper[1] = 0;
        if (paper[2] < 0) paper[2] = 0;

        // 4) 3 x 3 count
        sum += paper[3] / 4 + 1;    // 다 채워지지 않는 한 칸도 포함시킴!
        if (paper[3] % 4 == 0)
            sum -= 1;    // 3x3이 4의 배수 개로 있어서 새로운 덜 채워진 칸이 없는 경우 -1
        else if (paper[3] % 4 == 1) { // 3x3을 새로운 칸에 1개 넣어야 할 때
            if (paper[2] >= 5) {
                paper[2] -= 5;
                paper[1] -= 7;
            } else {

                paper[1] -= ((5 - paper[2]) * 4 + 7);
                paper[2] = 0;
            }
        } else if(paper[3] % 4 == 2) { // 3x3을 새로운 칸에 2개 넣어야 할 때
            if (paper[2] >= 3) {
                paper[2] -= 3;
                paper[1] -= 6;
            } else {
                paper[1] -= ((3 - paper[2]) * 4 + 6);
                paper[2] = 0;
            }
        } else if (paper[3] % 4 == 3) { // 3x3을 새로운 칸에 3개 넣어야 할 때
            if (paper[2] > 0) {
                paper[2]--;
                paper[1] -= 5;
            } else
                paper[1] -= 9;
        }

        if (paper[1] < 0) paper[1] = 0;
        if (paper[2] < 0) paper[2] = 0;

        // 5) 2 x 2 count
        if (paper[2] > 0) {
            sum += paper[2] / 9 + 1;
            if (paper[2] % 9 == 0)
                sum -= 1;
            else
                paper[1] -= (36 - 4 * (paper[2] % 9));
        }

        if (paper[1] < 0) paper[1] = 0;
        if (paper[2] < 0) paper[2] = 0;

        // 6) 1 x 1 count
        if (paper[1] > 0) {
            sum += paper[1] / 36 + 1;
            if (paper[1] % 36 == 0)
                sum--;
        }
        System.out.print(sum); // 결과 출력
    }
}

