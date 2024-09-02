import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
 
public class swea_1218_huiju {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        for(int t=0; t<10; t++) {    //테케 개수만큼 반복
 
            int len = sc.nextInt(); //테케 길이
            String str = sc.next(); //테케
             
            for(int i=0; i<len; i++) {   //테케 길이만큼 반복
                 
                char input = str.charAt(i);
                //str.charAt(i)가 여는 괄호일 경우
                if(bracket.containsValue(input))    
                    {stack.push(str.charAt(i)); //스택에 push  
                    }
                 
                else {  //닫는 괄호일 경우
                    if(stack.isEmpty()) {   //스택이 비어있을 경우
                         
                        System.out.printf("#%d 닫는괄호 들어갈 때 스택이 비어있는 경우 %d\n" ,t+1, 0);   //유효하지 않음
                        break;  //해당 테케 종료
                         
                    }else { //스택이 비지 않았을 경우
                         
                        findMatch(input);
                         
                    }
                }
            }
            System.out.printf("#%d ", t+1);
            if(stack.isEmpty())
                System.out.println(1);
            else
                System.out.println(0);
             
             
            stack.clear();
        }
         
    }
    static Stack<Character> stack = new Stack<>();  //원본 스택
    static Stack<Character> tmp = new Stack<>();    //임시로 값을 집어넣을 스택 생성
    static Map<Character, Character> bracket = new HashMap<>(4);    //괄호쌍 연결
    static {
        bracket.put(')', '(');
        bracket.put('}', '{');
        bracket.put(']', '[');
        bracket.put('>', '<');
    }
     
    //스택이 비지 않았을 경우 닫는 괄호의 짝을 찾는 메서드
    static void findMatch(char input) {
         
        for(int j=0; j<stack.size(); j++) {
             
            if(stack.peek() == bracket.get(input)) {    //top이 input(입력된 닫는 괄호)의 value와 같을 경우
                stack.pop();    //스택에서 제거
                int size = tmp.size();
                for(int i=0; i<size; i++) {  //임시 스택에 넣어놨던 다른 괄호들을 다시 원본스택에 넣어주기
                    stack.push(tmp.pop());
                }
                return; //메서드 종료
            }
            //짝이 맞지 않을 경우
            tmp.push(stack.pop());  //tmp에 맞지 않는 값을 저장해두기
        }
    }
 
}