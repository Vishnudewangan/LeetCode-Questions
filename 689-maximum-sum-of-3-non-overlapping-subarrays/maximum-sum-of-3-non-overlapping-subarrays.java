class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int[] psum =new int[nums.length];
        
        psum[0]=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            psum[i]=psum[i-1]+nums[i];
        }
        
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        
        int sum=0;
        
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        
        left[k-1] = sum;
        
        for(int i=k;i<n;i++)
        {
            sum=sum+nums[i]-nums[i-k];
            left[i] =Math.max(sum,left[i-1]);
        }
        
        sum=0;
        
        for(int i=n-1;i>=n-k;i--)
        {
            sum+=nums[i];
        }
        right[n-k] =sum;
        
        for(int i=n-k-1;i>=0;i--)
        {
            sum=sum+nums[i]-nums[i+k];
            right[i] =Math.max(sum,right[i+1]);
        }
        
        int ans =0;
        int lsum=0;
        int rsum=0;
        int spma =-1;
        
        // starting point of middle subarray varries from k to n-2*k
        
        for(int i=k;i<=n-2*k;i++)
        {
            
            if(left[i-1]+psum[i+k-1]-psum[i-1] + right[i+k] > ans)
            {
                lsum = left[i-1];
                rsum = right[i+k];
                ans=left[i-1]+psum[i+k-1]-psum[i-1]+right[i+k];
                spma=i;
            }
        }
        
        int spla=-1,spra=-1;
        
        for(int i=k-1;i<n;i++)
        {
            if(left[i]==lsum)
            {
                spla=i-k+1;
                break;
            }
        }
        
        for(int i=spma+k;i<n;i++)
        {
            if(psum[i+k-1]-psum[i-1]==rsum)
            {
                spra=i;
                break;
            }
        }
        
        
        return new int[]{spla,spma,spra};
        
        
        
        
        
    }
}