import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Stack{
   	List<Character> stack = new ArrayList<Character>();
    int top = -1;
    
    void push(char c){
        stack.add(c);
        top++;
    }
    
    char pop(){
        char result = stack.get(top);
        stack.remove(top--);
        return result;
    }
    
    char peek() {
    	if(!this.isEmpty()) {
	    	char result = stack.get(top);
	    	return result;
    	}
    	return 'X';
    }
    
    boolean isEmpty() {
    	return top==-1;
    }
}

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		end: for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
            String str = sc.next();
            
            Stack stack = new Stack();
            for (int i = 0; i<N; i++){
                if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='<'){
                    stack.push(str.charAt(i));
                } else if(stack.isEmpty()){
                	System.out.println("#"+test_case+" "+0);
                	continue end;
                } else {
                    if(str.charAt(i)-stack.peek()==1||str.charAt(i)-stack.peek()==2) {
                    	stack.pop();
                    } else {
                    	System.out.println("#"+test_case+" "+0);
                    	continue end;
                    }
                }
            }
            if (stack.isEmpty()) {
            	System.out.println("#"+test_case+" "+1);
            } else {
            	System.out.println("#"+test_case+"x "+0);
            }
		}
	}
}
