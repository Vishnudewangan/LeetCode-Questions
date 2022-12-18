class Solution {
    public String interpret(String command) {
        Stack<Character> st= new Stack<>();
        
        StringBuilder sb =new StringBuilder();
        
      for(char ch : command.toCharArray())
      {
          if(ch=='('){
               st.push(ch);
          }
          else if(ch==')')
          {
              if(st.peek()=='(')
              {
                  sb.append('o');
              }
              else
              {
                  StringBuilder temp =new StringBuilder();
                  while(st.size()>0 &&st.peek()!='(')
                  {
                      temp.append(st.pop());
                  }
                  sb.append(temp.reverse());
              }
              
              st.pop();
          }
          else
          {   if(ch=='G')
              sb.append(ch);
              else
                 st.push(ch);
          }
      }
        
        return sb.toString();
    }
}