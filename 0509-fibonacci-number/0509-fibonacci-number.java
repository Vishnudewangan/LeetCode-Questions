class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int prev=0;
        int next=1;
        int count=2;
        
        while(count<=n)
        {
            int sum =prev+next;
            prev=next;
            next=sum;
            count++;
        }
        
        return next;
        
    }
}