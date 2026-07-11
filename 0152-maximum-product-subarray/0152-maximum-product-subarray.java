class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
       int prefix =0;
       int maxPro = Integer.MIN_VALUE;
       int suffix = 0;
       for(int i=0 ; i<n ; i++){
        if(prefix == 0){
            prefix = 1;
        }
        if(suffix == 0){
            suffix = 1;
        }
        prefix *= nums[i];

        suffix *= nums[n-i-1];

        maxPro = Math.max(maxPro , Math.max(prefix , suffix));

       }
       return maxPro;
    }
}