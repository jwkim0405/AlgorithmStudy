import java.util.Scanner;

class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = str.length();
        for (int i = 0; i <str.length();i++){
            if(str.charAt(i)>'z'||str.charAt(i)<'a') {
                ans--;
                if(i>1 && str.charAt(i)=='='&& str.charAt(i-1)=='z'&& str.charAt(i-2)=='d'){
                    ans--;
                }
            }
            else if(i!=0 && str.charAt(i)=='j'){
                if(str.charAt(i-1)=='l'||str.charAt(i-1)=='n'){
                    ans--;
                }
            }
        }
        System.out.println(ans);
    }
}
