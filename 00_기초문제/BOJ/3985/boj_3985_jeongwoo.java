import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt(); // 롤케이크 길이(배열의 크기)
        int[] rollcake = new int[L+1]; // 1~L까지를 인덱스로 사용

        int N = sc.nextInt(); // 방청객의 수
        int[] audience = new int[N+1]; // 1 ~ N까지 배열 인덱스로 사용

        int imagine_max = 0;
        int imagine_max_idx = 0;

        for (int i = 1; i <= N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (imagine_max < end - start) {
                imagine_max = end - start;
                imagine_max_idx = i;
            }
            
            for (int j = start; j <= end; j++)
                if (rollcake[j] == 0) {
                    rollcake[j] = i;
                    audience[i]++;
                }
            }

        int max = 0;
        int max_idx = 0;

        // 실제 최대 개수를 가지는 값과 인덱스 찾기
        for (int i = 1; i <= N; i++) {
            if (max < audience[i]) {
                max = audience[i];
                max_idx = i;
            }
        }
        // 가장 많이 받을 것으로 예상되는 사람의 인덱스 출력
        System.out.println(imagine_max_idx);

        // 실제로 가장 많이 받는 사람의 인덱스 출력
        System.out.println(max_idx);
    }
}

