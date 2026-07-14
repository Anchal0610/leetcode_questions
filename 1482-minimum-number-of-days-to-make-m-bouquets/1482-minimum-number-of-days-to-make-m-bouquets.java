class Solution {
    private int possible(int []bloomDay , int days , int k){
        int count = 0;
        int bouquets = 0;
        for(int bloom : bloomDay){
            if(bloom <= days){
                count++;
            }
            else{
                bouquets += (count / k);
                count = 0;
                
            }
        }
        bouquets += count/k;
        return bouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n){
            return -1;
        }
        int minbloomD = Arrays.stream(bloomDay).min().getAsInt();
        int maxbloomD = Arrays.stream(bloomDay).max().getAsInt();
        int low = minbloomD;
        int high= maxbloomD;
        int ans = maxbloomD;

        while(low <= high){
            int mid = low + (high-low)/2;
            int possible = possible(bloomDay , mid , k);
                if(possible >= m){
                    ans = mid;
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }

            return ans;
        }
    }
