import java.util.Scanner;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int N = sc.nextInt();
            String str = sc.next();
            System.out.println("#"+test_case+" "+evaluate(str));
		}
	}
    static Map<Character, Integer> map = new HashMap<>();
    static{
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('(',0);
    }
    static String postfix(String str){
        Stack<Character> stack = new Stack();
        String result = "";
        for (int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c>='0' && c<='9') result+=c;
            else if(c=='(') stack.push(c);
            else if(c==')'){
                char popItem = stack.pop();
                while(popItem!='('){
                    result+=popItem;
                    popItem = stack.pop();
                }
            } else{
                while(!stack.isEmpty() && map.get(stack.peek())>=map.get(c)){
                    char popItem = stack.pop();
                    if(popItem=='(') break;
                    result+=popItem;
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
    
    static int evaluate(String str){
        String postfix = postfix(str);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<postfix.length(); i++){
            char c = postfix.charAt(i);
            if(c<='9' && c>='0'){
                stack.push(c-'0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(c=='+') stack.push(num1+num2);
                else if (c=='-') stack.push(num2-num1);
                else if (c=='*') stack.push(num1*num2);
                else stack.push(num2/num1);
            }
        }
        return stack.pop();
    }
}
