class Solution {
    public int findJudge(int n, int[][] trust) {
      
        int[] trustCount = new int[n+1];
        
        for(int i=0;i<trust.length;i++)
        {
             trustCount[trust[i][1]]++;
             trustCount[trust[i][0]]--;
        }
        
        for(int i=1;i<=n;i++)
        {
            if(trustCount[i]==n-1) return i;
        }
        
        return -1;
        
    }
}