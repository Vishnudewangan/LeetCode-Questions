class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int pr = findPotentialRow(matrix,target);

        if(pr == -1) return false;

        int lo = 0;// starting column of pr
        int hi = matrix[0].length - 1; // last column of pr

        while(lo<=hi){
            int mid = lo + (hi - lo)/2;

            if(matrix[pr][mid]==target)return true;
            else if(matrix[pr][mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;

    }
    private int findPotentialRow(int[][] matrix,int target){
       
       int lo = 0;// row 0
       int hi = matrix.length - 1; // last row

        while(lo <= hi){

            int mid = lo + (hi - lo)/2;

            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
                return mid;
            }
            else if(matrix[mid][0]>target ){
                hi = mid -1;
            }
            else{
               lo = mid + 1;
            }
        }
        return -1;// default row; if target is not available
    }
}