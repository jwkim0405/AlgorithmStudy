import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[100][100];
        int ans = 0;
        for (int i = 0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int k1 = 0; k1<10; k1++){
                for (int k2 = 0; k2<10; k2++){
                    if(arr[x+k1][y+k2]==0) {
                        arr[x+k1][y+k2]=1;
                        ans++;
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}
