class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       
       int totalCost = 0;
       int totalGas = 0;
        
        for(int i=0;i<gas.length;i++)
        {
            totalCost+=cost[i];
            totalGas+=gas[i];
        }
        if(totalGas < totalCost)
        {
            return -1;
        }
        
        int remainingGas =0;
        int start =0;
        
        for(int i=0;i<gas.length;i++)
        {
             remainingGas = remainingGas + (gas[i]- cost[i]);
            
            if(remainingGas < 0)
            {
                start=i+1;
                remainingGas = 0;
            }
        }
        
        
        return start;
    }
}