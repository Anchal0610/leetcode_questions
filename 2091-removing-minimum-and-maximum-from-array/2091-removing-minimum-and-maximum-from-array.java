class Solution {
    public int minimumDeletions(int[] nums) {
       int maxIdx = 0,
        minIdx = 0,
        largest = nums[0],
        smallest = nums[0];
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] > largest){
                largest = nums[i];
                maxIdx = i;
            }
        }
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] < smallest){
                smallest = nums[i];
                minIdx = i;
            }
        }
        int left = Math.min(minIdx , maxIdx);
        int right = Math.max(maxIdx , minIdx);
        int front = right + 1;
        int back = nums.length-left;
        int both = (left+1) + (nums.length - right);

        return Math.min(front , Math.min(back , both));
    }
}