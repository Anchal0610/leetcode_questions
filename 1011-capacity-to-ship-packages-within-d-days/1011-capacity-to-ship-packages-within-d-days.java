class Solution {
    public int days(int []weights , int cap){
        int days = 1;
        int load = 0;
        for(int weight : weights){
            if(load + weight > cap){
                days = days + 1;
                load = weight;
            }
            else{
                load += weight;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int totalweight = 0;
        for(int weight : weights){
            totalweight += weight;
        }
        int high = totalweight;
        while(low <= high){
            int mid = low + (high - low)/2;
            int totalDays = days(weights , mid);
            if(totalDays <= days){
                high = mid -1;
            }
            else{
                low = mid +1;
            }           
        }
        return low;
    }
}