class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int n = security.length;
        int[] left = new int[n];// will keep count of non-increasing ele
        int[] right = new int[n]; // will keep count of non-decreasing ele
        
        
        left[0] = 1;
        
        for(int i=1;i<n;i++)
        {
            if(security[i]<=security[i-1]) left[i] =left[i-1]+1;
            else left[i] = 1;
            
        }
        
        right[n-1] = 1;
        
        for(int i=n-2;i>=0;i--)
        {
            if(security[i]<=security[i+1])right[i] = right[i+1]+1;
            else right[i] = 1;
        }
        
        List<Integer> ans =new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(left[i]-1 >=time && right[i]-1>=time) ans.add(i);
        }
        
        return ans;
        
    }
}