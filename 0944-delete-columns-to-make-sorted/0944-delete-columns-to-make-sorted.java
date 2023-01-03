class Solution {
    public int minDeletionSize(String[] strs) {
        
        int unsorted=0;
        
        for(int col= 0; col<strs[0].length();col++)
        {
            for(int row=1;row<strs.length;row++)
            {
                if(strs[row].charAt(col) < strs[row-1].charAt(col))
                {
                    unsorted++;
                    break;
                }
            }
        }
        
        return unsorted;
    }
}