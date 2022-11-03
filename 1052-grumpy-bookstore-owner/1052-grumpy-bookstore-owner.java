class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int x= minutes;
        int n= customers.length;
        int sc = 0; // satisfied customers
        
        for(int i=0;i<customers.length;i++)
        {
            if(grumpy[i]==0)
            {
                sc+=customers[i];
            }
        }
         int msc = sc;//max satisfied customer
        for(int i=0;i<n;i++)
        {
            if(i<x)
            {
                if(grumpy[i]==1)
                {
                    sc+=customers[i];
                    
                }
               
            }   
            else
            {
                
                if(grumpy[i-x]==1)
                {
                    sc-=customers[i-x];
                }
                
                if(grumpy[i]==1)
                {
                    sc+=customers[i];
                }
            }
            
             msc= Math.max(msc,sc);
            
        }
        
        return msc;
    }
}