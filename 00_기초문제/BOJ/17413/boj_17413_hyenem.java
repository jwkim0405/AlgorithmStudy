import java.util.Scanner;
import java.util.Stack;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder stringbuilder = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='<'){
                while(!stack.isEmpty()) stringbuilder.append(stack.pop());
                while(str.charAt(i)!='>'){
                    stringbuilder.append(str.charAt(i));
                    i++;
                }
                stringbuilder.append(str.charAt(i));
            } else if(str.charAt(i)==' '){
                while(!stack.isEmpty()) stringbuilder.append(stack.pop());
                stringbuilder.append(' ');
            } else {
                stack.push(str.charAt(i));
            }
        }
        while(!stack.isEmpty()) stringbuilder.append(stack.pop());
        System.out.println(stringbuilder);
    }
}