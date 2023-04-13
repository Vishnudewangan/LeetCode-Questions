class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        int j=0;
        
        int matchCount=0;
        int n =pushed.length;
        
        Stack<Integer> st =new Stack<>();
        st.push(pushed[i]);
        
        while(j< n)
        {
            if(st.size()>0 && st.peek()== popped[j])
            {
                  st.pop();
                  j++;
                  matchCount++;
            }
            else if(i<n)
            {
                st.push(pushed[i]);
                i++;
            }
            else return false;
            
        }
        
        return n==matchCount;
            
    }
}