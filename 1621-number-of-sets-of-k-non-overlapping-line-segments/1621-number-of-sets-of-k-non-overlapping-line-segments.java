class Solution {
    static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {

        int[][] dp = new int[n + k][2 * k + 1];

        // C(i, 0) = 1
        for (int i = 0; i < n + k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + k; i++) {
            for (int j = 1; j <= 2 * k && j <= i; j++) {

                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return dp[n + k - 1][2 * k];
    }
}