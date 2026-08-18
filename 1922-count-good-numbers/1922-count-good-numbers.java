class Solution {
    static final int mod = 1000000007;
    public int findPow(long x , long n){
        if(n==0){
            return 1;
        }
        int half = findPow(x , n/2);
        if(n%2==0){
            return (int)(((long) half * half)%mod);
        }
        return (int)(((long) half * half * x)%mod);
    }
    public int countGoodNumbers(long n) {
        return (int)(((long) findPow(5 , (n+1)/2) * findPow(4 , n/2))%mod);
        
    }
}