class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> st=new Stack<>();
        
        int max= 0;
        int left= -1;
        
        for(int j=0;j<s.length();j++)
        {
            char ch = s.charAt(j);
            
            if(ch=='(')
            {
                st.push(j);
            }
            else
            {
                if(st.size()==0) left = j;
                
                else{  
                    
                    st.pop();
                
                    if(st.size()==0 ) max=Math.max(max, j-left);
                    else max =Math.max(max, j-st.peek());
                }
            }
        }
        
        return max;
    }
}