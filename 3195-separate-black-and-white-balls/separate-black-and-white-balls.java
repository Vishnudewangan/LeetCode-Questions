class Solution {
    public long minimumSteps(String s) {
      int cnt=0;

      long ans= 0l;

      for(int i=s.length()-1;i>=0;i--)
      {
         if(s.charAt(i)=='0')
         {
            cnt++;
         }
         else
         {
            ans+=cnt;
           
         }
      }
      return ans;
    }
}