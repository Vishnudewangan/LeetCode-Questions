class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int optClosingTime = 0;
        int minPenalty = n+1;
        
        
        int[][] preComputation = new int[n][2];
        
        // preComputation[i][0] ->  'Y' ( no. of 'Y' from 0 to i)
        // preComputation[i][1] -> 'N' ( no. of 'N' from 0 to i)
        
        for(int i=0;i<n;i++)
        {
            char ch = customers.charAt(i);
            
            if(ch == 'Y')
            {
                preComputation[i][0] = i==0? 1: preComputation[i-1][0] +1;
                preComputation[i][1] = i==0? 0 : preComputation[i-1][1];
            }
            else
            {
                preComputation[i][1] = i==0 ? 1 : preComputation[i-1][1] +1;
                preComputation[i][0] = i==0 ? 0 : preComputation[i-1][0];
            }
        }
        
        // System.out.println(preComputation[n-1][0]+"+"+preComputation[n-1][1]);
        
       for(int i=0;i<=n;i++)
       {
          
           int penalty = 0;
           
           if(i==0)
           {
               penalty = preComputation[n-1][0];
           }
           else if(i==n)
           {
               penalty = preComputation[n-1][1];
           }
           else
           { 
               // Left Part
               penalty +=preComputation[i-1][1];
               
               // Right Part
               penalty +=(preComputation[n-1][0]-preComputation[i-1][0]);
           }
          
           if(minPenalty > penalty)
           {
                minPenalty = penalty;
               optClosingTime = i;
           }
           
          

       }
        
        return optClosingTime;
    }
}