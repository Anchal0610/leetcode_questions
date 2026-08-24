class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0 , cookie =0;
        while(child < m &&  cookie < n){
            if(g[child] <= s[cookie]){
               child++;
                cookie++;
            }
            else{
                cookie++;
            }
        }
        return child;
    }
}