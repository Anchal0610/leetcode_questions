class Solution {
    static final int CHAR = 256;
    public int firstUniqChar(String s) {
       int []FI = new int[CHAR];
       Arrays.fill(FI, -1);
       for(int i=0 ; i<s.length() ; i++){
           if(FI[s.charAt(i)] == -1){
            FI[s.charAt(i)] = i;
           }
           else{
            FI[s.charAt(i)] = -2;
           }
       }
       int res = Integer.MAX_VALUE;
       for(int i=0 ; i<CHAR ; i++){
        if(FI[i] >= 0){
            res = Math.min(res , FI[i]);
        }
       }
       return (res == Integer.MAX_VALUE)? -1 : res;
    }
}