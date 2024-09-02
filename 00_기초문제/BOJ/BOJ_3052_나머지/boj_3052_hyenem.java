import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int count = 0;
        end: for (int i = 0 ; i < 10; i++){
            arr[i]=sc.nextInt()%42;
            for (int j = 0; j<i; j++){
                if (arr[j]==arr[i]) continue end;
            }
            count++;
        }
        System.out.println(count);
    }
}
