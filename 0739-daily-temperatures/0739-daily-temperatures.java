class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        return nextGreatestElementOnRight(temperatures);
    }
    
    int[] nextGreatestElementOnRight(int[] arr)
    {
        int[] nger = new int[arr.length];
        
        Stack<Integer> st=new Stack<>();
        
        nger[arr.length-1] = 0;
        st.push(arr.length-1);
        
        for(int i=arr.length-2;i>=0 ;i--)
        {
            while(st.size()>0 && arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                nger[i] = 0;
            }
            else
            {
                nger[i] = st.peek()-i;
            }
            
            st.push(i);
        }
        
        return nger;
    }
        
}