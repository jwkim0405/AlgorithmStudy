import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // Number of test cases
        
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();  // Number of weights
            int[] weights = new int[N];  // Array to store weights
            
            // Input the weights
            for (int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
            }
            
            // Calculate valid ways and print the result
            int result = countValidWays(N, weights);
            System.out.println("#" + test_case + " " + result);  // Output result for each test case
        }
    }
    
    // Function to start the backtracking process
    public static int countValidWays(int N, int[] weights) {
        return backtrack(0, 0, 0, N, weights, new boolean[N]);  // Backtracking with initial sums and unused weights
    }
    
    // Backtracking function to explore possible ways to place weights
    public static int backtrack(int index, int leftSum, int rightSum, int N, int[] weights, boolean[] used) {
        if (index == N) {
            return 1;  // If all weights are placed, count this as a valid configuration
        }
        
        int count = 0;
        
        // Try to place each unused weight
        for (int i = 0; i < N; i++) {
            if (!used[i]) {  // Check if the weight is not yet placed
                used[i] = true;  // Mark the weight as used
                
                // Place the current weight on the left
                count += backtrack(index + 1, leftSum + weights[i], rightSum, N, weights, used);
                
                // Place on the right only if it doesn't exceed left sum
                if (rightSum + weights[i] <= leftSum) {
                    count += backtrack(index + 1, leftSum, rightSum + weights[i], N, weights, used);
                }
                
                used[i] = false;  // Backtrack (unmark the weight)
            }
        }
        
        return count;  // Return the total count of valid configurations
    }
}