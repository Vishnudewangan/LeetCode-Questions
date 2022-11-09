class Solution {
    public int climbStairs(int n) {
     
        int prev=1;
        int next= 2;
        int count=2;
        
        while(count<=n)
        {
            int sum =prev+next;
            prev = next;
            next =sum;
            count++;
        }
        
        return prev;
    }
}