class Solution {
    int[][] directions = {
    {-1, 0},  // up
    {1, 0},   // down
    {0, -1},  // left
    {0, 1}    // right
    };
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(board[i][j] == word.charAt(0) && find(0 , word , i , j , board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(int index , String word, int i , int j , char[][] board){
        if(index == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '$'){
            return false;
        }
        if( board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if(find(index+1 , word , new_i , new_j , board)){
                return true;
            }
        }
        board[i][j] = temp;

        return false;

    }
}