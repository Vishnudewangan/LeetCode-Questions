class Solution {
    public int[] finalPrices(int[] prices) {
        int[] nse = nseR(prices);
        
        for(int i=0;i<prices.length;i++)
        {
            if(nse[i]!=-1)
            {
                prices[i]=prices[i]-nse[i];
            }
        }
        return prices;
    }
    
    int[] nseR(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        
        int[] nse=new int[arr.length];
        nse[arr.length-1] = -1;
        
        for(int i=arr.length-2;i>=0;i--)
        {
            while(st.size()>0 && st.peek()> arr[i])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                nse[i]=-1;
            }
            else
            {
                nse[i]=st.peek();
            }
            st.push(arr[i]);
        }
        
        return nse;
    }
}