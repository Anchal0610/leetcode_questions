class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
         if(n == 1) {
            return nums[0];
        }

        // Case 1: exclude first house
        int case1 = robLinear(nums, 1, n - 1);

        // Case 2: exclude last house
        int case2 = robLinear(nums, 0, n - 2);

        return Math.max(case1, case2);

        
    }
    public int robLinear(int[] nums , int start , int end) {
        int n = nums.length;
        int []dp = new int[n];
        for(int i=0 ; i<n ; i++){
            Arrays.fill(dp , 0);
        }
        int prev = 0;
        int prev2 = 0;
        for(int i=start ; i<=end ; i++){
            int take = nums[i]+ prev2;
            int notTake = prev;

            int curr = Math.max(take , notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}