import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0, res = 0;
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++)
            nums[i] = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            // 10번까지 탐색했는데도 100이 안 넘는 경우
            if (i == 9 && sum + nums[i] < 100)
                res = sum + nums[i];

            // 해당 idx의 숫자까지 더하면 100이 넘는 경우
            if (sum + nums[i] >= 100) {
                if (sum + nums[i] - 100 <= 100 - sum)
                    res = sum + nums[i];
                else
                    res = sum;
                break;
            }
            else    // 더해도 100보다 작은 경우, sum에 더해주기
                sum += nums[i];
        }
        System.out.print(res);
    }
}


