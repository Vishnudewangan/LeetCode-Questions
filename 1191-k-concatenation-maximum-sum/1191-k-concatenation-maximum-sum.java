class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        if(k==1) return oneArrKedanes(arr);
        
        
        int sum=0;
        
        for(int val :arr)
        {
            sum+=val;
        }
        
        int res=twoArrKedanes(arr);
        
        int m=1000000007;
        
        if(sum>0)
        {
            long ans=res+(long)(k-2)*sum;
            return (int)(ans%m);
        }
        else 
        {
            return res;
        }
        
        
    }
    
    int twoArrKedanes(int[] arr)
    {
        int csum=arr[0];
        
        int msum=Math.max(csum, 0);
        
        for(int i=1;i<2*arr.length;i++)
        {
            int idx=i%arr.length;
            
            if(csum<0)
            {
                csum=arr[idx];
            }
            else 
            {
                csum+=arr[idx];
            }
            msum=Math.max(csum, msum);
        }
        
        return msum;
    }
    int oneArrKedanes(int[] arr)
    {
        int csum=arr[0];
        
        int msum=Math.max(csum, 0);
        
        for(int i=1;i<arr.length;i++)
        {
           
            
            if(csum<0)
            {
                csum=arr[i];
            }
            else 
            {
                csum+=arr[i];
            }
            msum=Math.max(csum, msum);
        }
        
        return msum;
    }
    
}