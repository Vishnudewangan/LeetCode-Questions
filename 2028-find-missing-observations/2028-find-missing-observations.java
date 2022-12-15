class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int sum = 0;
        for(int val : rolls)
        {
            sum+= val;
        }
        
        int missingnum = mean * (m+n) - sum; // missingnum to be devided into n size array;
        
        
        
        if(missingnum < n || missingnum > 6*n) return new int[]{};
        
        
        int part = missingnum/n;
        int rem = missingnum%n;
        
        int[] ans= new int[n];
        Arrays.fill(ans,part);
        
        for(int i=0;i<rem;i++)
        {
            ans[i]++;
        }
        
        return ans;
        
         
    }
}