class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int[] dp =new int[s.length()+1];
        Arrays.fill(dp, -1);
       int ans = rec(0,s,dp);

       return ans != (int)1e9 ? ans : -1;
    }
    private static int rec(int i, String s,int[] dp){
        // prunning
        //base case
        if(i == s.length()) return 0;
        // cache check
          if(dp[i] != -1) return dp[i];
        // compute

        int ans = (int) 1e9;
        for(int j = i; j < s.length(); j++)
        {
            if(checkBeautiful(s.substring(i,j+1)) == true)
            {
                ans = Math.min(ans, 1 + rec(j+1,s,dp)) ;
            }
        }
        // save and return
        return dp[i] = ans;
    }
    private static boolean checkBeautiful(String str){

        if(str.charAt(0) == '0') return false;
            int num = 0;

            int pow = 1;

            for(int i=str.length() -1 ; i>=0; i--)
            {
                num += (str.charAt(i)-'0')*pow;
                pow *=2;
            }

            while(num > 1 && num % 5 == 0){
                num/=5;
            }

            return num == 1 ;
    }
}