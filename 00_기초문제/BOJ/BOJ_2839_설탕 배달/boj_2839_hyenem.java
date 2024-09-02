import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        while (N%5!=0){
            if(N<0){
                System.out.println(-1);
                return;
            }
            N-=3;
            count++;
        }
        count += N/5;
        System.out.println(count);
    }
}
