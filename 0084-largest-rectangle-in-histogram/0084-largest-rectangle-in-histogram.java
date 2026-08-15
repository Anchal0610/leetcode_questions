class Solution {
    public int largestRectangleArea(int[] heights) {
       ArrayDeque<Integer> s= new ArrayDeque<>();
       int maxArea = 0;
       for(int i=0 ; i<heights.length ; i++){
        while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
            int ele = s.peek();
            s.pop();
            int nse = i;
            int pse = s.isEmpty() ? -1 : s.peek();

            maxArea = Math.max(heights[ele] * (nse - pse -1) , maxArea);
        }
        s.push(i);
       }

        while(!s.isEmpty()){
            int nse = heights.length ;
            int ele = s.peek();
            s.pop();
            int pse = s.isEmpty() ? -1 : s.peek();
            maxArea = Math.max(heights[ele] * (nse - pse -1) , maxArea);
        }
       
        return maxArea;
    }
}
