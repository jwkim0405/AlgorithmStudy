import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt(); // 너비
        int h = sc.nextInt(); // 높이

        int x = sc.nextInt(); // 초기 x 좌표
        int y= sc.nextInt();  // 초기 y 좌표

        int t = sc.nextInt(); // 움직일 시간

        x = (x+t) % (2*w);
        y = (y+t) % (2*h);
        StringBuilder sb = new StringBuilder();

        if (x <= w)
            sb.append(x).append(" ");
        else
            sb.append(w- (x%w)).append(" ");

        if (y <= h)
            sb.append(y).append(" ");
        else
            sb.append(h-(y%h));

        System.out.print(sb);


    }
}

