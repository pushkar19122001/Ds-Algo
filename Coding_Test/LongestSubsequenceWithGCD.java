import java.util.*;

public class LongestSubsequenceWithGCD {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(7, 6, 4, 6, 8, 12, 15, 18);
        int N = A.size();
        int maxLength = findLongestSubsequenceLength(N, A);
        System.out.println("Length of longest subsequence with GCD > 1: " + maxLength);
    }

    public static int findLongestSubsequenceLength(int N, List<Integer> A) {
        if (N == 0) {
            return 0;
        }

        // Create a DP array where dp[i] represents the length of the longest subsequence ending at A[i]
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // Initialize all values to 1 since minimum length is 1

        int maxLength = 1; // Initialize maxLength to 1 (minimum possible length)

        // Iterate through each element in the list
        for (int i = 0; i < N; i++) {
            int num = A.get(i);

            // Find all factors (other than 1) of num
            List<Integer> factors = findFactors(num);

            // Update dp[i] based on previously computed values
            for (int factor : factors) {
                // Find index of factor in A
                int factorIndex = A.indexOf(factor);

                // Check if factorIndex is valid and less than i
                if (factorIndex != -1 && factorIndex < i) {
                    dp[i] = Math.max(dp[i], dp[factorIndex] + 1);
                }
            }

            // Update maxLength
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    // Helper function to find all factors of a number greater than 1
    public static List<Integer> findFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                if (i != num / i) {
                    factors.add(num / i);
                }
            }
        }
        return factors;
    }
}
