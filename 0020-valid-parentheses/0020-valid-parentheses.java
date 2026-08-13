class Solution {
    public boolean matching(char a , char b){
        return ((a == '(' && b == ')') || (a == '{' && b == '}') ||
        (a == '[' && b == ']'));
    }
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0 ; i<s.length(); i++){
            char x = s.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
            }
            else{
                if(stack.isEmpty() == true){
                    return false;
                }
                else if(matching(stack.peek() , x) == false){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return (stack.isEmpty() == true);
    }
}