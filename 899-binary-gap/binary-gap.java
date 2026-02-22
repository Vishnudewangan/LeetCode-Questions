class Solution {
    public int binaryGap(int n) {
        int prevOneDgtPos = -1;
        int pos = 0;
        int count = 0;
        while(n > 0)
        {   pos++;
            int rem = n%2;
            n /= 2;
            if(rem == 1 &&  prevOneDgtPos!=-1){
                count = Math.max(count,pos - prevOneDgtPos);
                prevOneDgtPos = pos;
            }
            else if(rem == 1){
                prevOneDgtPos = pos;
            }
        }

        return count;
    }
}