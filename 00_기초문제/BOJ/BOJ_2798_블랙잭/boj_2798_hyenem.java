import java.util.Scanner;

public class Main{

    static int N;
    static int M;
    static int ans = 0;
    static int[] card;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        card = new int[N];
        for (int i = 0; i<N; i++){
            card[i]=sc.nextInt();
        }
        
        DFS(0,0,0);
        System.out.println(ans);
        
    }
    
    public static void DFS(int start, int num, int sum){
        if (num==3){
            if(sum<=M && ans<sum){
                ans = sum;
            }
            return;
        } else if (start>=N){
            return;
        }
        DFS(start+1, num+1, sum+card[start]);
        DFS(start+1, num, sum);
    }
    
    
}
