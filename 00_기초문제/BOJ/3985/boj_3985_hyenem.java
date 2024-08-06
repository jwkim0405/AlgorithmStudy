import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] cake = new int[N];
        int K = sc.nextInt();
        int[] ans = new int[K];
        int ans1 = 0;
        int maxrange = 0;
        for (int i = 1; i<K+1; i++){
            int left = sc.nextInt()-1;
            int right = sc.nextInt()-1;
            if(maxrange<right-left) {
            	maxrange = right-left;
            	ans1 = i;
            }
            for (int j = left; j<right+1; j++){
                if(cake[j]==0){
                    cake[j]=i;
                    ans[i-1]++;
                }
            }
        }

        int max = K-1;
        for (int i = K-1; i>=0; i--){
            if(ans[i]>=ans[max]) max = i;
        }
        System.out.println(ans1);
        System.out.println(max+1);
    }
}
