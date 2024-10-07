class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;
        while(n>=a){
            int repeat = n/a;
            ans+=b*repeat;
            n %= a;
            n += b*repeat;
        }
        
        return ans;
    }
}
