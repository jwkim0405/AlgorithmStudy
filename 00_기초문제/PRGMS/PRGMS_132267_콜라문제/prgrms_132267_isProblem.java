class Solution {
    public int solution(int a, int b, int n) {
        return calculateTotalCola(a, b, n, 0);
    }

    private int calculateTotalCola(int a, int b, int n, int total) {
        if (n < a) return total; // 교환 불가 시 총 콜라 수 반환
        int exchanged = (n / a) * b; // 교환으로 받은 콜라 수
        int remain = n % a; // 남은 빈 병 수
        return calculateTotalCola(a, b, exchanged + remain, total + exchanged); // 재귀 호출
    }
}
