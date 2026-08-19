class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1, k, n, new ArrayList<>() , ans);
        return ans;
    }
    private void findCombination(int i , int k , int n , List<Integer> ds , List<List<Integer>> ans){
        if(n==0 && k==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(i>9) return;
        if(k<0 || n<0) return;

        List<Integer> temp = new ArrayList<>(ds);
        temp.add(i);
        findCombination(i+1 , k-1 , n-i , temp ,ans );
        findCombination(i+1 , k , n , ds , ans);

    }
}