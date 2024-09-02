import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        
        int gcd = N;
        for (int i = Math.min(N, L); i>0; i--){
            if (N%i==0 && L%i ==0){
                gcd = i;
                break;
            }
        }
        
        System.out.println((N/gcd)*(M-1));
    }
}
