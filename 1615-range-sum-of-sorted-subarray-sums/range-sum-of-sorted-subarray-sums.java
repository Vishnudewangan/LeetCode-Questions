class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size = (n*(n+1))/2;
         int mod = (int)(1e9+7);
        int[] subArrSum = new int[size];
        int idx=0;
        for(int i=0;i<n;i++)
        {  
            int sum=nums[i]%mod;
            subArrSum[idx++]=sum;
            for(int j=i+1;j<n;j++)
            {   
                sum+=nums[j];
                sum%=mod;
                subArrSum[idx++] = sum;
            }
        }

        Arrays.sort(subArrSum);
        int ans =0;       
        for(int i=left-1;i<right;i++)
        {
            ans+=subArrSum[i];
            ans%=mod;
        }
        return ans;
    }
}