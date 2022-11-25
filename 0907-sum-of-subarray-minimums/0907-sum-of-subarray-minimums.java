class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
       
        
        int[]pre_smaller = new int[n];
        int[] next_smaller = new int[n];
        
        for(int i=0;i<n;i++)
        {
            pre_smaller[i] = i;
             next_smaller[i]= n-i-1;
        }
        
        for(int i=0;i<n;i++)
        {
            while(st.empty()==false && arr[st.peek()]>arr[i])
            {
                next_smaller[st.peek()] = i-st.peek()-1;
                st.pop();
            }
            st.push(i);
        }
        
        st =new Stack<>();
        
        for(int i=n-1;i>=0 ;i--)
        {
            while(st.empty() ==  false && arr[st.peek()]>=arr[i])
            {
                pre_smaller[st.peek()] = st.peek()- i-1;
                st.pop();
            }
            st.push(i);
        }
        
        long ans = 0;
        int mod = (int)1e9+7;
        
        for(int i=0;i<n;i++)
        {
            ans+= (arr[i]*(long)(pre_smaller[i]+1)*(next_smaller[i]+1))%mod;
            ans%=mod;
        }
        
        return (int)ans%mod;
    }
}