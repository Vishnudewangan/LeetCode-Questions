class Solution {
    public int fillCups(int[] amt) {
        int res=0;
        while(Math.max(amt[0],Math.max(amt[1],amt[2]))>0)
        {
            Arrays.sort(amt);
            
            amt[2]--;
            amt[1]--;
            res++;
        }
        return res;
    }
}