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
     public int[] findnge(int[] arr){
        int []nge = new int[arr.length];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=arr.length-1; i>=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            nge[i] = s.isEmpty() ? arr.length : s.peek();

            s.push(i);
        }
        return nge;
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
    public int[] findpgee(int[] arr){
        int []pgee = new int[arr.length];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<arr.length ; i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                s.pop();
            }
            pgee[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }
        return pgee;
    }
    public long sumSubarrayMins(int[] arr) {
        int []nse = findnse(arr);
        int []pse = findpsee(arr);

        long total = 0;
        for(int i=0 ; i<arr.length ; i++){
            long left = i-pse[i];
            long right = nse[i] - i;

            total = total + (left * right *  arr[i]);
        }
        return total;
    }
     public long sumSubarrayMax(int[] arr) {
        int []nge = findnge(arr);
        int []pge = findpgee(arr);

        long total = 0;
        for(int i=0 ; i<arr.length ; i++){
            long left = i-pge[i];
            long right = nge[i] - i;

            total = total + (left * right *  arr[i]);
        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
}