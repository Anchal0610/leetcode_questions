class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return (atmost(nums , goal) - atmost(nums , goal-1));
    }

    private int atmost(int[]nums , int goal){
         if(goal < 0){
            return 0;
        }
        int left=0 ,right =0;  int sum = 0 , cnt =0;
        while(right < nums.length){
            sum += nums[right];
            while(sum > goal){
                sum = sum - nums[left];
                left = left+1;
            }
            cnt = cnt + (right - left +1);
            right = right+1;
        }
        return cnt;
    }
    
}