class Solution {
    public int cherryPickup(int[][] grid) {
        int c = grid[0].length;
        int r = grid.length;
        int [][][] dp = new int[r][c][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

         return maxPick(0 , 0 , c-1 , grid, dp);
         

    }
    public int maxPick(int i , int j1 , int j2 , int[][]grid , int[][][]dp){
        int c = grid[0].length;
        int r = grid.length;
        if(j1 < 0 || j2 < 0 || j1>=c|| j2 >= c){
            return -100000000;
        }

        if(i== r-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int max =0;
        for(int dj1 = -1 ; dj1 <= +1 ; dj1++){
            for(int dj2 = -1 ; dj2 <= +1 ; dj2++){
                int value  = 0;
                if(j1 == j2) {
                    value = grid[i][j1];
                }
                else{
                    value = grid[i][j1] + grid[i][j2];
                }
                value += maxPick(i+1 , j1+dj1 , j2+dj2 , grid, dp);

                max = Math.max(max , value);
            }
        }
        return dp[i][j1][j2] = max;

    }
}