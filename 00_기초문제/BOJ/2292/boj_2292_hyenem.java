import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int ans = 0;
        for (int i = 0; i<500000; i++){
            if(N<=3*(i*(i+1))+1){
                ans = i+1;
                break;
            }
        }
        System.out.println(ans);
    }
}
