class Solution {
    public int[] findnse(int[] arr){
        int []nse = new int[arr.length];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=arr.length-1; i>=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            nse[i] = s.isEmpty() ? arr.length : s.peek();

            s.push(i);
        }
        return nse;
    }
    public int[] findpsee(int[] arr){
        int []psee = new int[arr.length];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<arr.length ; i++){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }
            psee[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }
        return psee;
    }
    public int sumSubarrayMins(int[] arr) {
        int []nse = findnse(arr);
        int []pse = findpsee(arr);

        long total = 0;
        int mod = (int)(1e9+7);
        for(int i=0 ; i<arr.length ; i++){
            int left = i-pse[i];
            int right = nse[i] - i;

            total = (total + (left * right * 1L * arr[i])%mod)%mod;
        }
        return (int)total;
    }
}