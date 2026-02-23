class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int r = 0;// row
        int c = matrix[0].length - 1; // column 

        // matrix[r][c] -> will represent greates element from row r and smallest element from column c

        // if matrix[r][c] > target -> smallest element is greater than target in this column we won't find target so c--;
        // if matrix[r][c] < target -> greates element from row r is smaller than target means in that row target is not there so r++;

        while(r < matrix.length && c >= 0){

            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) r++;
            else c-- ;// matrix[r][c] > target
        }
    return false;
    }
}