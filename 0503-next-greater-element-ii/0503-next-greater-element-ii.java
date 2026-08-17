class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int []nge = new int[nums.length];
       ArrayDeque<Integer> s = new ArrayDeque<>();
       int n = nums.length;
       for(int i = 2*n-1 ; i>=0 ; i--){
        while(!s.isEmpty() && s.peek() <= nums[i%n]){
            s.pop();
        }
        if(i<n){
            nge[i] = s.isEmpty() ? -1 : s.peek();
        }
        s.push(nums[i%n]);
       }   
       return nge;
    }
}