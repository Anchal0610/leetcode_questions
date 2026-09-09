class Solution {
    public int totalFruit(int[] fruits) {
       int l =0;
       int r =0;
       int maxlen = 0;
       HashMap<Integer , Integer> map = new HashMap<>();
       while(r < fruits.length){
        map.put(fruits[r] , map.getOrDefault(fruits[r] , 0)+1);

        if(map.size() > 2){
            int fruit = fruits[l];
            map.put(fruit , map.get(fruit)-1);
            if(map.get(fruit) == 0){
                map.remove(fruit);
            }
            l++;
        }
        if(map.size() <= 2){
            maxlen = Math.max(maxlen , r-l+1);
        }
        r++;
       }
       return maxlen; 
    }
}