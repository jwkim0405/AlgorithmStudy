import java.util.Scanner;

public class boj_10828_yuyoung {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();     // 주어지는 명령의 수
        int N = 1000;  // 배열 크기, 충분히 큰 값으로 설정
        int[] arr = new int[N];   // 배열 선언
        int size = 0;
        
        for (int i = 0; i < M; i++) { 
            String st = sc.next(); // 입력할 명령
            
            if (st.equals("push")) { // push를 입력 받았다면
                if (size < N) { // 스택이 가득 차지 않았다면
                    int num = sc.nextInt(); // 숫자 입력
                    arr[size] = num; // 숫자 삽입
                    size++; // size 크기 증가 및 다음에 push할 인덱스 증가
                } else {
                    break; // 스택이 가득 차면 숫자 삽입 불가
                }
            }
            
            if (st.equals("top")) { // top을 입력 받았다면
                if (size > 0) { // 스택이 비어있지 않으면
                    System.out.println(arr[size - 1]); // 스택의 최상단 값 출력
                } else {
                    System.out.println(-1); // 스택이 비어있으면 -1 출력
                }
            }
            
            if (st.equals("size")) { // size를 입력 받았다면
                System.out.println(size); // 스택의 크기 출력
            }
            
            if (st.equals("empty")) { // empty를 입력 받았다면
                if (size == 0) {
                    System.out.println(1); // 스택이 비어있으면 1 출력
                } else {
                    System.out.println(0); // 스택이 비어있지 않으면 0 출력
                }
            }
            
            if (st.equals("pop")) { // pop을 입력 받았다면
                if (size > 0) { // 스택이 비어있지 않으면
                    System.out.println(arr[size - 1]); // 스택의 최상단 값 출력
                    size--; // 스택 크기 감소
                } else {
                    System.out.println(-1); // 스택이 비어있으면 -1 출력
                }
            }
        }
    }
}
