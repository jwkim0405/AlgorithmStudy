import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int before =0;
        int now =0;
        for (int i =0; i<10; i++){
            before = now;
            now+=sc.nextInt();
            if(now>100) break;
        }
        if(100-before<now-100)
            System.out.println(before);
        else
            System.out.println(now);
    }
}
