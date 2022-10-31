class Solution {
    public int[] replaceElements(int[] arr) {
          
        int n = arr.length;
        int[] ans= new int[arr.length];
        
        ans[n-1] = -1;
        
        for(int i=n-2;i>=0;i--)
        {
            ans[i] = Math.max(arr[i+1],ans[i+1]);
        }
        
        return ans;
    }
}