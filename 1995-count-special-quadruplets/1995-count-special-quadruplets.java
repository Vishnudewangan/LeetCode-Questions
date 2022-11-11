class Solution {
    public int countQuadruplets(int[] arr) {
         int n= arr.length;
        
        int count=0;
        for(int i=0;i<n;i++)
        {
           for(int j=i+1;j<n;j++)
           {
               for(int k=j+1;k<n;k++)
               {
                  for(int l=k+1;l<n;l++)
                  {
                      if(arr[i]+arr[j]+arr[k] == arr[l])
                      {
                          count++;
                      }
                  }
               }
           }
        }
        
        return count;
    }
}