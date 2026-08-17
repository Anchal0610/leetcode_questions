class Solution {
    public int LargestHist(int []height){
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int maxarea =0;
        for(int i=0 ; i<height.length ; i++){
            while(!s.isEmpty() && height[s.peek()] >= height[i]){
                int ele = s.pop();
                int nse = i;
                int pse = s.isEmpty() ? -1 : s.peek();
                maxarea = Math.max(maxarea , height[ele]*(nse-pse-1));
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int ele = s.pop();
            int nse = height.length;
            int pse = s.isEmpty() ? -1 : s.peek();
            maxarea = Math.max(maxarea , height[ele]*(nse-pse-1));
        }
        return maxarea;

    }
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        if(matrix.length == 0) {
            return 0;
        }
       int []height = new int [c];
       int res =0;
       for(int i=0 ; i<r; i++){
        for(int j =0; j<c ; j++){
            if(matrix[i][j] == '1'){
                height[j]++;
            }
            else{
                height[j] = 0;
            }
        }
        res = Math.max(res, LargestHist(height));
       }
       return res;
    }
}