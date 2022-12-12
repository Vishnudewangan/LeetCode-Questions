class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int next = 2;
        int steps=2;
        
        while(steps<=n)
        {
            int sum = prev+next;
            prev = next;
            next = sum;
            steps++;
            
        }
        return prev;
    }
}