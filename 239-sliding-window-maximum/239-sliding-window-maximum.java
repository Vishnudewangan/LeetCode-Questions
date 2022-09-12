class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] ngr =nextGreatestElement(nums);
        
        //i - > window start
        // j -> jump within window
        
       
        
        
        int[] ans=new int[nums.length-k+1];
        int j=0;
        
        for(int i=0;i<=nums.length-k;i++)
        {
            if(j<i)
            {
                j=i;
            }
            
            while(ngr[j] < i+k)
            {
                j= ngr[j];
            }
            
            ans[i] = nums[j];
        }
        
        return ans;
        
        
        
    }
    
    int[] nextGreatestElement(int[] nums)
    {  
        int n = nums.length;
        Stack<Integer> st=new Stack<>();
        
        st.push(n-1);
        
        int[] ngr=new int[nums.length];
        
        ngr[n-1]= n;
        
        for(int i=n-2;i>=0;i--)
        {
            while(st.size() > 0 && nums[st.peek()]<=nums[i])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                ngr[i] = n;
            }
            else
            {
                ngr[i] = st.peek();
            }
            st.push(i);
        }
        
        return ngr;
    }
}