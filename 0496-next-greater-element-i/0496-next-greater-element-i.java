class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        HashMap<Integer ,Integer> map = new HashMap<>();
        s.push(nums2[nums2.length-1]);
        map.put(s.peek() , -1);
        for(int i= nums2.length-2 ; i>=0 ; i--){
            int nge = -1;
            while(!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            nge = s.isEmpty() ? -1 : s.peek();
            map.put(nums2[i] , nge);
            s.push(nums2[i]);
        }
        int []ans = new int[nums1.length];
        for(int i=0 ; i<nums1.length ; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans ;
    }
}