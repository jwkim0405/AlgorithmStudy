import java.util.Scanner;

public class swea_1215_huiju {

    public static void main(String[] args) {
 
        // 한 줄에 제시된 문자 갯수만큼의 char를 문자열로 저장
        Scanner sc = new Scanner(System.in);
        String str = "";
        int count = 0;
        String[][] arr = new String[8][8];
         
        for(int tc=0; tc<10; tc++) { //테스트케이스 갯수만큼 반복
            int len = sc.nextInt();
            System.out.printf("#%d ",tc+1);
            for(int i=0; i<8; i++){
                arr[i] = sc.next().split("");
            }
 
            for(int i=0; i<8; i++){   //가로
                for(int j=0; j<8-len+1; j++){   //첫번째 글자가 움직일 범위 설정
                    str = "";
                    for(int k=j; k<len+j; k++){  //str에 arr 안 문자를 len만큼 집어넣음
                        str += arr[i][k];
                    }
                    String rev = "";
                    for (int h = str.length() - 1; h >= 0; h--) {   //str 안 글자를 하나씩 빼서 역순으로 rev에 저장
                        rev += str.charAt(h);
                    }
                    if (str.equals(rev)) 
                        ++count;
                }
            }
            for(int i=0; i<8; i++){   //세로
                for(int j=0; j<8-len+1; j++){   //첫번째 글자가 움직일 범위 설정
                    str = "";
                    for(int k=j; k<len+j; k++){//여기가 문제?   //str에 arr 안 문자를 len만큼 집어넣음
                        str += arr[k][i];
                    }
                    String rev = "";
                    for (int h = str.length() - 1; h >= 0; h--) {   //str 안 글자를 하나씩 빼서 역순으로 rev에 저장
                        rev += str.charAt(h);//여기가 문제?
                    }
                    if (str.equals(rev)) 
                        ++count;
                }
            }
            System.out.println(count);
            count=0;
 
        }
    }
}