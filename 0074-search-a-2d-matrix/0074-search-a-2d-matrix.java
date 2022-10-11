class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
          
       
        int pr = fpr(matrix,target);// potentialRow
        if(pr==-1) return false;
        
        
        int low=0, hi = matrix[0].length-1;
        
        while(low<=hi)
        {
            int mid= low + (hi-low)/2;
            
            if(matrix[pr][mid] == target)
            {
                return true;
            }
            else if(matrix[pr][mid]> target)
            {
                hi=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        
        return false;
    }
    
    int fpr(int[][] matrix,int target){
        
         int low =0;
        int hi = matrix.length-1;
        
        while(low<=hi){
         
            int mid= low + (hi-low)/2;
            
            
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1] >=target)
            {
                return mid;
            }
            else if(matrix[mid][0]>target)
            {
                hi=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        
        return -1;
    }
   
}