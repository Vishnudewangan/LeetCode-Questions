class Solution {
    public double myPow(double x, int n) {
        
        if(n<0)
        {
            return 1/x*myPow(1/x,-(n+1));
        }
        
        if(n==0) return 1;
        
        
        double xpnb2=myPow(x,n/2);
        
        double xpn=1;
        
        if(n%2==0)
        {
            xpn=xpnb2 * xpnb2;
        }
        else
        {
          xpn = x* xpnb2* xpnb2;
        }
        
        return xpn;
    }
}