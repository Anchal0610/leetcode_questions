class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0 , candidates , target , ans , new ArrayList<>());
        return ans ;
    }
    private void findCombination(int index , int[] nums , int target , List<List<Integer>> ans , List<Integer> ds){
        if(index == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[index] <= target){
            ds.add(nums[index]);
            findCombination(index , nums , target - nums[index], ans , ds);
            ds.remove(ds.size() - 1);
        }
        findCombination(index+1 , nums , target , ans , ds);
    }
}