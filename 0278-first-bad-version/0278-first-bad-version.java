/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int ans=1;
        int left =1, right=n;
        
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            
            if(isBadVersion(mid)==true) 
            {
                ans= mid;
                right =mid-1;
            }
            else
            {
                left= mid+1;
            }
           
        }
        
        return ans;
    }
}