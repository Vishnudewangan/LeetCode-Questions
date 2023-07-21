class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        
        st.push(directions.charAt(0));
        int collisions=0;
        
        for(int i=1;i<directions.length();i++)
        {
            char curr  = directions.charAt(i);
            
            
            if(st.peek() == 'R' && curr=='L')
            {
                
                collisions+=2;
                st.pop();
                
                curr='S';
            }
            else if(st.peek()=='S' && curr=='L')
            {
                collisions+=1;
                st.pop();
                curr='S';
            }
            
            while(st.size()>0 && ( st.peek()=='R' && curr == 'S'))
            {
                collisions+=1;
                st.pop();
            }
            
            st.push(curr);
        }
        
        return collisions;
  }
}