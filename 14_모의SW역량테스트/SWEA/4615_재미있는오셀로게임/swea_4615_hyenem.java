import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
     
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<T+1; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[][] arr = new int[N][N];
            arr[N/2][N/2-1]=1;
            arr[N/2-1][N/2]=1;
            arr[N/2-1][N/2-1]=2;
            arr[N/2][N/2]=2;
             
            for(int i = 0; i<M; i++) {
                int y = sc.nextInt()-1;
                int x = sc.nextInt()-1;
                int color = sc.nextInt();
                arr[y][x]=color;
                end: for (int j = 0; j<8; j++) {
                    int nowX = x+dx[j];
                    int nowY = y+dy[j];
                    int count = 0;
                    while(nowX<N && nowY<N&& nowX>-1 && nowY>-1) {
                        if(arr[nowY][nowX]==color) {
                            nowX=x;
                            nowY=y;
                            for(int k = 0; k<count; k++) {
                                nowX+=dx[j];
                                nowY+=dy[j];
                                if(arr[nowY][nowX]==3-color) arr[nowY][nowX]=color;
                            }
                            continue end;
                        } else if(arr[nowY][nowX]==0){
                            continue end;
                        } else {
                            nowX+=dx[j];
                            nowY+=dy[j];
                            count++;
                        }
                    }
                }
            }
             
            int blacknum=0;
            int whitenum=0;
            for(int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    if(arr[i][j]==1) blacknum++;
                    else if(arr[i][j]==2) whitenum++;
                }
            }
            System.out.println("#"+test_case+" "+blacknum+" "+whitenum);
        }
    }
}
