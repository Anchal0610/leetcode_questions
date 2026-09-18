class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer , Integer> map = new HashMap<>();
       for(int i=0; i<nums.length ; i++){
        map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        ArrayList<Map.Entry<Integer , Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) ->{
            if(a.getValue() != b.getValue()){
                return Integer.compare(b.getValue() , a.getValue());
            }
            return Integer.compare(b.getKey() , a.getKey());
        });
        int []ans = new int[k];
        for(int i= 0 ; i<k && i<list.size() ; i++){
            ans[i] = list.get(i).getKey();
        }
       
       return ans; 
    }
}