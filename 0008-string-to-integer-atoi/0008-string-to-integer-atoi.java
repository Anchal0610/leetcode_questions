class Solution {
    public int myAtoi(String s) {
        int i =0;
        long num = 0;
        int sign = 1;

        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i<s.length() && s.charAt(i) == '-'){
                sign = -1;
                i++;
        }
        else if(i<s.length() && s.charAt(i) == '+'){
                i++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;

            if(sign == 1 && num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(sign == -1 && -num < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign * num);
    }
}