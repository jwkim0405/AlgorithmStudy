import java.util.Scanner;

public class swea_1954_huiju {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt(); //케이스 개수 입력받음
        int caseNumCount = 1;   //케이스 반복횟수 카운트
 
        for(int i=0; i<caseNum; i++) {   //케이스 개수만큼 반복
            System.out.println("#"+caseNumCount);
            int n = sc.nextInt();   //N 입력받음
            if(n==1) {System.out.println(n);}
            else {
                int[][] arr = new int[n][n];    //N*N 2차원 배열 생성
                int a=0,b=0;    //arr[a][b]
                int addNum = 1;
                int count = 0;
 
                for(b=0; b<n; b++) { //1번 사이클 : 맨 윗줄(N개 채우기)
                    arr[a][b] = addNum++;
                }
                count++;
                b=b-1;
 
                for(;;) {   //무한반복
                    for(a=a+1; a<n+1-count; a++) {   //2-1번 사이클(ㄴ) : N-count만큼의 칸 채우기
                        arr[a][b] = addNum++;
                    }
                    a=a-1;  
                    //a가 for문의 조건을 충족하지 못했기 때문에(a가 n+1-count와 같아졌기 떄문에) 빠져나온 것, 
                    //  따라서 1을 빼줘야 addNum을 대입한 자리에서 바로 이어나갈 수 있음. 
                    for(b=b-1; b>count-2; b--) { //2-2번 사이클(ㄴ) : N-count만큼의 칸 채우기
                        arr[a][b] = addNum++;
                    }
                    b=b+1;
                    if(arr[a-1][b]!=0)  break; //다음 칸의 값이 0이 아닌 경우 break
 
                    for(a=a-1; a>count-1; a--) { //3-1번 사이클(ㄱ) :
                        arr[a][b] = addNum++;
                    }
                    a=a+1;
                    for(b=b+1; b<n-count; b++) { //3-2번 사이클(ㄱ) : 
                        arr[a][b] = addNum++;
                    }
                    b=b-1;
                    if(arr[a+1][b]!=0)  break; //다음 칸의 값이 0이 아닌 경우 break
                    count++;
                }
 
                for(int k=0; k<n; k++) { //달팽이 출력
                    for(int j=0; j<n; j++) {
                        System.out.print(arr[k][j]+" ");
                    }
                    System.out.println();
                }
            }
            caseNumCount++;
        }
    }
}