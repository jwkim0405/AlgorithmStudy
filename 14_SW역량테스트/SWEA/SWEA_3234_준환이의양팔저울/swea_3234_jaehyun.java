import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수
        
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();  // 무게추의 개수
            int[] weights = new int[N];  // 무게추 배열
            
            // 무게추 입력
            for (int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
            }
            
            // 경우의 수 계산
            int result = countValidWays(N, weights);
            
            // 결과 출력
            System.out.println("#" + test_case + " " + result);
        }
    }
    
    // 재귀적인 백트래킹 방식으로 경우의 수를 구하는 함수
    public static int countValidWays(int N, int[] weights) {
        return backtrack(0, 0, 0, N, weights);
    }
    
    // 백트래킹 함수: index는 현재 무게추를 가리키고, leftSum과 rightSum은 현재 왼쪽, 오른쪽에 놓인 무게 합
    public static int backtrack(int index, int leftSum, int rightSum, int N, int[] weights) {
        if (index == N) {
            // 모든 무게추를 놓았으면 경우의 수 1 증가
            return 1;
        }
        
        int count = 0;
        
        // 현재 무게추를 왼쪽에 놓기
        count += backtrack(index + 1, leftSum + weights[index], rightSum, N, weights);
        
        // 현재 무게추를 오른쪽에 놓을 수 있는 경우에만 놓기 (오른쪽의 무게 합이 왼쪽을 넘지 않도록)
        if (rightSum + weights[index] <= leftSum) {
            count += backtrack(index + 1, leftSum, rightSum + weights[index], N, weights);
        }
        
        return count;
    }
}
