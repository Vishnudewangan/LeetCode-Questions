class Solution {
    public boolean canJump(int[] nums) {
       
        
        boolean  ans=cj_mem(nums);
            return ans;
//             if(ans>0)
//             {
//                 return true;
//             }
//             else
//             {
//                 return false;
//             }
    
        
    }
    
    public static boolean cj_mem(int[] jumps)
    {
        
       boolean[] dp=new boolean[jumps.length];
        
        dp[jumps.length-1]=true;
        
        for(int j=jumps.length-2;j>=0;j--)
        {
            for(int k=1;k<=jumps[j] && j+k<dp.length;k++)
            {
                if(dp[j+k])
                dp[j]=true;
                
            }
            // System.out.println(dp[j]);
        }
        
        return dp[0];
    }
}