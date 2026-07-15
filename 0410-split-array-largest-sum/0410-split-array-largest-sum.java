class Solution {
    public boolean split(int[] nums , long maxSum , int k){
        int cntarray = 1;
        long sum = 0;
        int n = nums.length;
        for(int i=0 ; i<n ; i++){
            if(nums[i] > maxSum){
                return false;
            }
            if(sum + nums[i] > maxSum){
                cntarray++;
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        if(cntarray > k){
            return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
      long low = Arrays.stream(nums).min().getAsInt();
      long sum =0;
      for(int num : nums){
        sum += num;
      }  
      long high = sum;

      while(low <= high){
        long mid = low  + (high - low )/2;
        if(split(nums , mid , k) == true){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
      }
      return (int)low;
    }
}