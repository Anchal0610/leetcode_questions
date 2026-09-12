class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums , k) - atmost(nums, k-1);
    }
    public int atmost(int[] nums , int k){
        if(k<0){
            return 0;
        }
       int l = 0;
       int r = 0; 
       int cnt = 0;
       HashMap<Integer , Integer> map = new HashMap<>();
       while(r < nums.length){
        map.put(nums[r] , map.getOrDefault(nums[r] , 0)+1);
        while(map.size() > k){
            int num = nums[l];
            map.put(num , map.get(num)-1);
            if(map.get(num) == 0){
                map.remove(num);
            }
            l++;
        }
        cnt = cnt + (r-l+1);
        r++;
       }
       return cnt;
    }
}