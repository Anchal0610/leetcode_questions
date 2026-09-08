class Solution {
    
    public int eraseOverlapIntervals(int[][] intervals) { 
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[1] , b[1]));
        int cnt = 1;
        int lastending = intervals[0][1];
        for(int i=1 ; i<intervals.length ; i++){
            if(intervals[i][0] >= lastending){
                cnt = cnt+1;
                lastending = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}