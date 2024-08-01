import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> len = new ArrayList<>();
        int K = sc.nextInt();   // 단위면적 당 자라는 참외 수

        int width_sum = 0, height_sum = 0;
        int h_idx = 0;
        int w_idx = 0;
        for (int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            len.add(sc.nextInt());
            if (i % 2 == 0)
                width_sum += len.get(i);
            else
                height_sum += len.get(i);
        }

        int height_max = height_sum / 2;
        int width_max = width_sum / 2;

        for (int i = 0; i < 3; i++) {
            if (len.get(2 * i) == width_max)
                w_idx = 2 * i;
            if (len.get(2 * i + 1) == height_max)
                h_idx = 2 * i + 1;
        }

        int remove_square;
        
        if (w_idx - h_idx == 1 || w_idx - h_idx == -5)   // 세로 최대 -> 가로 최대 순서로 나오는 경우
            remove_square = len.get((w_idx + 2) % 6) * len.get((h_idx +4) % 6);
        else // 가로 최대 -> 세로 최대 순서로 나오는 경우
            remove_square = len.get((h_idx + 2) % 6) * len.get((w_idx +4) % 6);

        int full_area = height_max * width_max;
        int area = full_area - remove_square;

        System.out.print(area * K);
    }
}

