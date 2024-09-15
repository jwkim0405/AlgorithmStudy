import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for(int i = 0; i<N; i++){
            arr[i]=sc.nextLong();
        }
        
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i<N; i++){
            int left = 0;
            int right = N-1;
            if(i==N-1) right--;
            else if(i==0) left++;
            while(left<right){
                if(arr[left]+arr[right]==arr[i]) {
                    ans++;
                    break;
                }
                else if(arr[left]+arr[right]<arr[i]) {
                    left++;
                    if(left==i) left++;
                }
                else {
                    right--;
                    if(right==i) right--;
                }
            }
        }
        
        System.out.println(ans);
    }
}
