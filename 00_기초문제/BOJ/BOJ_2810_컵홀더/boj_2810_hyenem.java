import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int sNum = 0;
        int lNum = 0;
        for (int i = 0; i<N; i++){
            if(str.charAt(i)=='S') sNum++;
            else lNum++;
        }
        
        System.out.println(Math.min(sNum+(lNum/2)+1,N));
    }
}
