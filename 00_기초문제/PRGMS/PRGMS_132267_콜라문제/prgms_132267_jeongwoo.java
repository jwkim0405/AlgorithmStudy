class Solution {
    public int solution(int a, int b, int n) {
        int bottles = n; // 현재 남은 빈병
        int sum = 0; // 바꾼 병의 총 개수 카운트
        while(bottles >= a) {
            sum += (bottles / a)*b; // a개를 주고 바꾼 병의 개수
            bottles = (bottles/a)*b + (bottles%a); // 새로 받은 병 + 남은 빈 병
        }
        return sum;
    }
}
