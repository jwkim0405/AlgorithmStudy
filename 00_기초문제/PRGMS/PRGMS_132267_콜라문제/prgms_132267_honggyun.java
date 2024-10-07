class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;


        // n이 a를 넘지 않는 선에서 계속해서 나누어가는 문제
        while(n >= a) {
            // a개의 빈 병을 가져다 주면 b개를 줄 때 한 번에 받을 수 있는 최대
            answer += b * (n / a);
            n = (b * (n / a)) + (n % a);

        } // while문 종료 시 받을 수 있는 빈 병 다 받음

        return answer;
    }
}