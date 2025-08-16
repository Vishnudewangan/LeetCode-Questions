class Solution {
    public int maximum69Number (int num) {
        
        
        int numCopy = num;
        int firstidxOfSix =-1;
        int idx=0;
        
        while(numCopy>0)
        {
            if(numCopy%10==6)
            {
                firstidxOfSix=idx;
            }
            idx++;
            numCopy/=10;
        }
        
        return firstidxOfSix == -1 ? num : num+3*(int)Math.pow(10,firstidxOfSix);
    }
}