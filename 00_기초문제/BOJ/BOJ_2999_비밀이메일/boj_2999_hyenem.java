import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int R = str.length();
        int C = 1;
        for (int i = (int)Math.sqrt(str.length()); i>=1; i--){
            if(str.length()%i==0){
                R = i;
                C = str.length()/i;
                break;
            }
        }
        for (int i = 0; i<R; i++){
            for (int j = 0; j<C; j++){
                System.out.print(str.charAt(i+j*R));
            }
        }
    }
}
