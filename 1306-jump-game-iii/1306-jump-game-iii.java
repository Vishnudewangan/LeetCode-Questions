class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if(start>=0 && start < arr.length && arr[start] <arr.length)
        {
        
            int jump = arr[start];
            
           arr[start]+=arr.length;
            
            if(jump==0 || canReach(arr,start+jump) || canReach(arr,start - jump)) return true;
        }
        
        return false;
    }
}