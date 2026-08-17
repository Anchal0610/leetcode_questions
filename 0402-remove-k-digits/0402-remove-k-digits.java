class Solution {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> s = new ArrayDeque<>();
        for(int i=0 ; i<num.length() ; i++){
            while(!s.isEmpty() && k > 0 && (s.peek() - '0') > num.charAt(i) -'0'){
                s.pop();
                k = k-1;
            }
            s.push(num.charAt(i));
        }
        while(k>0){
            s.pop();
            k--;
        }
        
        ArrayList<Character> res = new ArrayList<>();
        while(!s.isEmpty()){
            res.add(s.pop());  
        }
        Collections.reverse(res);
        while(res.size() > 1 && res.get(0) == '0'){
        res.remove(0);
        }

        if(res.isEmpty()){
            return "0";
        }
        StringBuilder ans = new StringBuilder();

        for(char ch : res) {
            ans.append(ch);
        }

        return ans.toString();
    }
}