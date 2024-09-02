import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        for (int i =1; i<=N;i++){
            ans += N/i;
        }
        
        System.out.println((ans+(int)Math.sqrt(N))/2);
    }
}
