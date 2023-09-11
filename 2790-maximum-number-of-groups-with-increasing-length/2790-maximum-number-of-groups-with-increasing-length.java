class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        
        long k=0, total=0;
        
        for(int i=0;i<usageLimits.size();i++)
        {
            total += usageLimits.get(i);
            
            if(total >= ((k+1)*(k+2))/2)
            {
                k++;
            }
        }
        
        return (int)k;
    }
}