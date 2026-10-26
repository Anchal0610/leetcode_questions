import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
     int n = nums.length;
     int min = nums[0];
     int max = nums[0];
     
     for(int num : nums){
        min = Math.min(min , num);
        max = Math.max(max , num);
     }
     boolean []present = new boolean[max+1];
     for(int num : nums){
        present[num] = true;
     }
     List<Integer> res = new ArrayList<>();
     for(int i = min ; i<= max ; i++){
        if(!present[i]){
            res.add(i);
        }
     }
     return res;
    }
}