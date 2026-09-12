class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

       return atmost(nums , k) - atmost(nums , k-1);
    }
    public int atmost(int[]nums , int k){
        int l =0;
        int r =0;
        int odd = 0;
        int cnt =0;
        while(r < nums.length){
        if(nums[r]%2 !=0){
            odd++;
        }
        while(odd > k){
            if(nums[l]%2 !=0){
                odd--;
            } 
            l++;
        }
        cnt = cnt + (r-l+1);
        r++;
        }
       return cnt;
    }
}