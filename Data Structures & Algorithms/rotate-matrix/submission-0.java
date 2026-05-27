class Solution {
    public void rotate(int[][] matrix) {
        // first transpose and swap the columns
        int n = matrix.length;
        
        for (int r = 0 ;  r < n; r++){
            for(int c = 0; c < r; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        for(int c = 0; c < n/2; c++){
            for(int r = 0; r < n; r++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n - c - 1];
                matrix[r][n - c - 1] = temp;
            }
        }
    }
}