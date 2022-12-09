class Solution {
    private HashMap<Integer,Integer> indexMap;
    private HashMap<Integer,Integer> memo;
    public int lenLongestFibSubseq(int[] arr) {
        
        if(arr.length<=2) return arr.length;
        
         indexMap =new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            indexMap.put(arr[i],i);
        }
        
        int ans=0;
        for(int i=0;i<arr.length-2;i++)
        {
            for(int j=i+1;j<arr.length-1;j++)
            {
                
                ans= Math.max(ans,solve(arr,i,j));
                
            }
        }
        
        return ans>=1? ans+2: 0;
    }
    
    int solve(int[] arr, int i,int j)
    {
        if(indexMap.containsKey(arr[i]+arr[j])==false) return 0;
        
        return 1+ solve(arr,j,indexMap.get(arr[i]+arr[j]));
    }
}