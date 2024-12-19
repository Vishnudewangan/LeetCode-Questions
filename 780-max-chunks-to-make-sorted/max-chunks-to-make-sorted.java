class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int maxR=0;
        int chuncks=0;
        
        for(int i=0;i<arr.length;i++)
        {
            maxR = Math.max(maxR, arr[i]);
            
            if(maxR==i)
            {
                chuncks++;
            }
        }
        
        return chuncks;
    }
}