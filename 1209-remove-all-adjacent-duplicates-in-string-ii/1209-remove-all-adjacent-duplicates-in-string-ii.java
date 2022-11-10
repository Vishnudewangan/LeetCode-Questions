class Solution {
    public String removeDuplicates(String s, int k) {
       Stack<Pair> st =new Stack<>();
        
        for(char ch : s.toCharArray())
        {  
             
            if(st.size()==0)
            {
                st.push(new Pair(ch,1));
            }
            else if(st.peek().c==ch && st.peek().cnt<k)
            {
               st.peek().cnt=st.peek().cnt +1;
            }
            else
            {
                if(st.peek().cnt==k) st.pop();
                
                if(st.size()>0 && st.peek().c==ch)
                {
                    st.peek().cnt = st.peek().cnt+1;
                }
                else
                {
                    st.push(new Pair(ch,1));
                }
               
                
            }
        }
        
        if(st.peek().cnt == k) st.pop();
        
        StringBuilder sb =new StringBuilder();
        
        
        while(st.size()>0)
        {
           Pair rem = st.pop();
            
            for(int i=1;i<=rem.cnt ;i++)
            {
                sb.append(rem.c);
            }
        }
        
        return sb.reverse().toString();
    }
    
    static class Pair
    {
        char c;
        int cnt;
        
        Pair(char c, int cnt)
        {
            this.c=c;
            this.cnt = cnt;
        }
    }
}