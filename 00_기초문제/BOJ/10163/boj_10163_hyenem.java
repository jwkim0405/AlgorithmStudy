import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr= new int[1001][1001];
        int[] ans = new int[N+1];
        for (int i = 1; i<N+1; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int width = sc.nextInt();
            int height = sc.nextInt();
            ans[i]=width*height;
            for (int j =x; j<x+width; j++){
                for (int k = y; k<y+height; k++){
                    if(arr[j][k]!=0){
                        ans[arr[j][k]]--;
                    }
                    arr[j][k]=i;
                }
            }
        }
        
        for(int i = 1; i<N+1; i++){
            System.out.println(ans[i]);
        }
    }
}
