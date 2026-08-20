class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character , String> map = new HashMap<>();
        map.put('2' , "abc");
        map.put('3' , "def");
        map.put('4' , "ghi");
        map.put('5' , "jkl");
        map.put('6' , "mno");
        map.put('7' , "pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");

        StringBuilder temp = new StringBuilder();

        Solve(0 , digits , temp , map , res);
        return res;
    }
    private void Solve(int idx , String s , StringBuilder temp , HashMap<Character , String> map , List<String> res){
        if(idx >= s.length()){
            res.add(temp.toString());
            return ;
        }
        char ch = s.charAt(idx);
        String str = map.get(ch);
        for(int i=0 ; i<str.length() ; i++){
            temp.append(str.charAt(i));
            Solve(idx+1 , s , temp, map , res);
            temp.deleteCharAt(temp.length()-1);
        }    
    }
}