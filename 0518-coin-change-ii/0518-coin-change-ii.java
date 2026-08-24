class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        for(int i=0 ; i<n ; i++){
            Arrays.fill(dp[i] ,0);
        }
        for(int T = 0 ; T<= amount ; T++){
            dp[0][T] = T%coins[0] == 0 ? 1 : 0;
        }
        for(int i=1 ; i<n ; i++){
            for(int T= 0 ; T <= amount ; T++){
                int notTake = dp[i-1][T];
                int take = 0;
                if(coins[i] <= T){
                take = dp[i][T - coins[i]];
                } 
                dp[i][T] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }
}