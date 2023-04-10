class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st=new Stack<>();
        
        
        for(int i=0;i<s.length() ;i++)
        {
            char ch=s.charAt(i);
            
            if(ch=='(' || ch=='{' || ch=='[')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                boolean val=handleclosing(st,'(');
                if(val==false)
                return val;
            }
             else if(ch==']')
            {
                boolean val=handleclosing(st,'[');
                if(val==false)
                return val;
            }
             else if(ch=='}')
            {
                boolean val=handleclosing(st,'{');
                if(val==false)
                return val;
            }
        }
        /// opening bracket handeling 
        
        if(st.size()==0)
        {
            
        
            return true;
        }
        else
        {  
            return false;
        }
        
    }
    /// closing bracket handeling and mismatch bracket handeling
    
    public boolean handleclosing(Stack<Character> st, char coch)
    {
        if(st.size()==0)
        {
            return false;
        }
        else if(st.peek()!=coch)
        {
            return false;
        }
        else 
        {    st.pop();
          return true;
         
        }  
    
    }
}