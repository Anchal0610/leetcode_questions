class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
       Map<Character , Integer> map = new HashMap<>();
       for(char ch : s.toCharArray()){
        if(map.containsKey(ch)){
            map.put(ch , map.get(ch)+1);
        }
        else{
            map.put(ch , 1);
        }
       }
       List<Map.Entry<Character , Integer>> list = new ArrayList<>(map.entrySet());

       Collections.sort(list , (a,b) -> b.getValue() - a.getValue());

       for(Map.Entry<Character , Integer> entry : list){
        char ch = entry.getKey();
        int freq = entry.getValue();

        while(freq > 0){
            ans.append(ch);
            freq--;
        }
       }
       return ans.toString();


    }
}