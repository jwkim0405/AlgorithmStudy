import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = -100;
        int[] nums = new int[10]; // 10개 숫자 배열 선언

        for (int i = 0; i < 10; i++)
            nums[i] = sc.nextInt(); // 배열에 값 할당

        for (int i = 0; i < 10; i++) {
            if (Math.abs(sum) < Math.abs(sum + nums[i]))
                break;
            else if (Math.abs(sum) == Math.abs(sum + nums[i])) {
                sum += nums[i];
                break;
            } else
                sum += nums[i];
        }
        System.out.print(sum+100);
    }
}

