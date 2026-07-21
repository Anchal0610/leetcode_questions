class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixOdd = 0;
        int ans = 0;

        for (int num : nums) {

            if (num % 2 != 0)
                prefixOdd++;

            if (map.containsKey(prefixOdd - k))
                ans += map.get(prefixOdd - k);

            map.put(prefixOdd, map.getOrDefault(prefixOdd, 0) + 1);
        }

        return ans; 
    }
}