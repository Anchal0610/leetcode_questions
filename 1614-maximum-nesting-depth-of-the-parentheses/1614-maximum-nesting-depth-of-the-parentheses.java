class Solution {
    public int maxDepth(String s) {
        int currdepth = 0;
        int maxdepth = 0;
        StringBuilder result = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                currdepth++;

                maxdepth = Math.max(maxdepth , currdepth);
            }
            else if(ch == ')'){
                currdepth--;
            }
        }
        return maxdepth;
    }
}