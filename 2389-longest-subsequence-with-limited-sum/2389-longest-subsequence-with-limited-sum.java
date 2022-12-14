class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums);
        
        int n = nums.length, m = queries.length;
        int[] ans=new int[m];
        
        for(int i=0;i<m;i++)
        {
           int count = 0;
            
           int query = queries[i];
            
            for(int j=0;j<n;j++)
            {
                if(query >= nums[j])
                {
                    query-=nums[j];
                    count++;
                }
                else
                    break;
            }
            ans[i] = count;
        }
        
        return ans;
    }
}