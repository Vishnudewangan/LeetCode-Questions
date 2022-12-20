class Solution {
    public int hammingDistance(int x, int y) {
        
        int xor = x^y;
        
        int cnt =0;
        
        while(xor!=0)
        {
            int rsbm = (xor & -xor);
            xor = xor - rsbm;
            cnt++;
        }
        
        return cnt;
    }
}