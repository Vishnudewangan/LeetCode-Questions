class Solution {
    public String decodeString(String s) {
        Stack<Integer> count =new Stack<>();
        Stack<StringBuilder> strStack= new Stack<>();
        
        StringBuilder res =new StringBuilder();
        
        int k=0;
        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch)==true)
            {
                k = k*10 + ch -'0';
            }
            else if(ch=='[')
            {
                count.push(k);
                strStack.push(res);
                
                res  =new StringBuilder();
                
                k=0;
            }
            else if(ch==']'){
                
                StringBuilder curr= res;
                res = strStack.pop();
                
                int repeat = count.pop();
                
                for(int i=repeat; i> 0 ;i--)
                {
                    res.append(curr);
                }
            }
            else
            {
                res.append(ch);
            }
        }
        
        return res.toString();
    }
}