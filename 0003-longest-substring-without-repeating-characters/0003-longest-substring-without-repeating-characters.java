class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0 , l = 0 , r =0;
        int HashLen = 256;

        int []hash = new int[HashLen];
        Arrays.fill(hash , -1);
        int n = s.length();
        while( r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)]+1;
                }
            }
            int len = r-l+1;
            maxlen= Math.max(len , maxlen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}