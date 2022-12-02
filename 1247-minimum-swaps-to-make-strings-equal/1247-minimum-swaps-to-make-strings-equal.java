class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int countXS1=0;
        int countYS1=0;
        
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!= s2.charAt(i))
            {
                if(s1.charAt(i)=='x')
                {
                    countXS1++;
                }
                else 
                {
                    countYS1++;
                }
            }
        }
        
        if(countXS1%2==0 && countYS1%2==0)
        {
          return (countXS1+countYS1)/2;
        }
        else  if(countXS1%2==1  && countYS1%2==1)
        {
          return (countXS1+countYS1)/2 +1;
        }
        return -1;
    }
}