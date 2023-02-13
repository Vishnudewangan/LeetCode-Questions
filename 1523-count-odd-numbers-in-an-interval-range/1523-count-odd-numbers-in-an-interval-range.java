class Solution {
    public int countOdds(int low, int high) {
        
        
         if(low%2==1&& high%2==1)
         {
              int n= (int)Math.ceil((high-1-low-1)/2)+2;
             
             return n;
             
         }
         else if(low%2==1)
         {
             int n = (int)Math.ceil((high - low-1)/2)+1;
             return n;
         }
        else if(high%2==1)
        {
            int n = (int)Math.ceil((high-1-low)/2)+1;
            return n;
        }    
        else 
        {
            int n =(int)Math.ceil((high-low)/2);
            return n;
        }
        
       
    }
}