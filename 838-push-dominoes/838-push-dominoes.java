class Solution {
    public String pushDominoes(String dominoes) {
       
        String str= 'L' + dominoes + 'R';
        
        StringBuilder sb =new StringBuilder(str);
        
        int i=0;
        
        while(i < str.length()-1)
        {
            
            int j=i+1;
            
            
            while(j< str.length() && str.charAt(j)=='.')
            {
                j++;
            }
            
            solve(sb,i,j);
            
            i=j;
        }
        
        
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    void solve(StringBuilder sb, int i , int j)
    {
        
        if(sb.charAt(i)=='L' && sb.charAt(j)=='L')
        {
            for(int k=i+1;k<=j-1;k++)
            {
                sb.setCharAt(k,'L');
            }
        }
        else if(sb.charAt(i)=='L' && sb.charAt(j)=='R')
        {
          
        }
        else if(sb.charAt(i)=='R' && sb.charAt(j)=='L')
        {
            int m = i;
            int n = j;
            
            while(m < n)
            {
                sb.setCharAt(m, 'R');
                sb.setCharAt(n, 'L');
                m++;
                n--;
            }
        }
        else
        {
        // R  R 
            
            for(int k=i+1;k<=j-1;k++)
            {
                sb.setCharAt(k, 'R');
            }
        }
    }
}