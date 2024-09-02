import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();
        int txy = t % (w*h); // w*h시간 주기로 원래 방향을 바라보는 원위치로 돌아옴

        // t 시간 후의 x 좌표 구하기
        int tx = -1;
//        if(((txy+(p-1))/w) % 2 == 0) tx = (txy - (w - p)) % w == 0 ? w : (txy - (w - p)) % w;
        if(((txy+(p-1))/w) % 2 == 0) tx = (p+txy) % w == 0 ? w : (p+txy) % w;
        else {
            int minusIdx = ((txy-(w-p)) % w) == 0 ? w : ((txy-(w-p)) % w);
            tx = w - minusIdx;
        }

        // t 시간 후의 y 좌표 구하기
        int ty = -1;
//        if(((txy+(q-1))/h) % 2 == 0) ty = (txy - (h - q)) % h == 0 ? h : (txy - (h - q)) % h;
        if(((txy+(q-1))/h) % 2 == 0) ty = (q+txy) % h == 0 ? h : (q+txy) % h;
        else {
            int minusIdx = ((txy-(h-q)) % h) == 0 ? h : ((txy-(h-q)) % h);
            ty = h - minusIdx;
        }

        System.out.printf("%d %d\n", tx, ty);

    }
}