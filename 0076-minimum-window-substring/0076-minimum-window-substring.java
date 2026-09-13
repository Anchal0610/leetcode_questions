class Solution {
    public String minWindow(String s, String t) {

        int l = 0;
        int r = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int cnt = 0;
        int minlen = Integer.MAX_VALUE;
        int S_index = -1;

        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i),
                    map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while(r < s.length()){

            char str = s.charAt(r);

            if(map.containsKey(str)){

                if(map.get(str) > 0){
                    cnt++;
                }

                map.put(str, map.get(str) - 1);
            }

            while(cnt == t.length()){

                if((r-l+1) < minlen){
                    minlen = r-l+1;
                    S_index = l;
                }

                char str1 = s.charAt(l);

                if(map.containsKey(str1)){

                    map.put(str1, map.get(str1) + 1);

                    if(map.get(str1) > 0){
                        cnt--;
                    }
                }

                l++;
            }

            r++;
        }

        return S_index == -1 ? "" : s.substring(S_index, S_index + minlen);
    }
}