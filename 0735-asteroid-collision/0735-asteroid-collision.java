class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st =new Stack<>();
        
        for(int val : asteroids)
        {
            if(val > 0 ) 
            {
                 st.push(val);
            }
            else
            {
                while(st.size()>0 && st.peek()> 0 && st.peek() < -val ) st.pop();
                
                if(st.size()> 0 && st.peek()==-val ) st.pop();
                else if(st.size() > 0 && st.peek() > -val) {
                    // we don't have to do anything   
                }
                else{
                    // val -> -ve
                    st.push(val);
                }
                
            }
        }
        
        int[] ans = new int[st.size()];
        
        int idx = ans.length-1;
        
        while(idx>=0)
        {
            ans[idx--] = st.pop();
        }
        
        return ans;
    }
}