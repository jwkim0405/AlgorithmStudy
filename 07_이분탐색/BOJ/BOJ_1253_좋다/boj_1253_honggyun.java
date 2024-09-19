import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N];
        check = new boolean[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        } // arr 채우기

        Arrays.sort(arr);
        Arrays.fill(check, false);

        // 조합
        int sum;
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                sum = arr[i] + arr[j];
                binarySearch(0, N - 1, sum, i, j);
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(check[i]) cnt++;
        }

        System.out.println(cnt);
    }

    public static void binarySearch(int left, int right, int target, int a, int b) {
        if(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) binarySearch(left, mid-1, target, a, b);
            else if(arr[mid] == target) {
                for(int i = left; i <= right; i++) {
                    if(i != a && i != b && arr[i] == target) check[i] = true;
                }
            } else binarySearch(mid+1, right, target, a, b);
        }
    }
}
