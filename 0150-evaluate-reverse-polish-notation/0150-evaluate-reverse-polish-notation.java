class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> valst =new Stack<>();
        Stack<String> opst = new Stack<>();
        
        for(String str: tokens)
        {
            if(str.equals("+") || str.equals("-")|| str.equals("*") || str.equals("/"))
            {
                int v2=valst.pop();
                int v1 = valst.pop();
                
               
                
                int val = 0;
                if(str.equals("+")==true)
                {
                    val = v1 + v2;
                }
                else if(str.equals("-")==true)
                {
                    val = v1 - v2;
                }
                else if(str.equals("/")==true)
                {
                    val = v1/v2;
                }
                else if(str.equals("*"))
                {
                    val = v1*v2;
                }
                
                valst.push(val);
            }
            else
            {
                valst.push(Integer.parseInt(str));
            }
        }
        
        return valst.pop();
        
        
    }
}