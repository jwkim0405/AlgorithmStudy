import java.util.Scanner;
import java.util.Stack;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = "";
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='<'){
                while(!stack.isEmpty()) ans+=stack.pop();
                while(str.charAt(i)!='>'){
                    ans+=str.charAt(i);
                    i++;
                }
                ans+=str.charAt(i);
            } else if(str.charAt(i)==' '){
                while(!stack.isEmpty()) ans+=stack.pop();
                ans+=' ';
            } else {
                stack.push(str.charAt(i));
            }
        }
        while(!stack.isEmpty()) ans+=stack.pop();
        System.out.println(ans);
    }
}
