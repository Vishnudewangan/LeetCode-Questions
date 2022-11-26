class Solution {
    static class Pair implements Comparable<Pair>{
        int strt;
        int end;
        int profit;
        
        Pair(int strt, int end,int profit)
        {
            this.strt=strt;
            this.end =end;
            this.profit = profit;
        }
        public int compareTo(Pair o)
        {
         
            return this.end - o.end;
            
        }
        
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        
      Pair[] arr=new Pair[profit.length];
        
        for(int i=0;i<profit.length;i++)
        {
            arr[i]= new Pair(startTime[i],endTime[i],profit[i]);
            
            
        }
        Arrays.sort(arr);
        
        return maxProfit(arr);
        
    }
    
    public int maxProfit(Pair[] arr)
    {
        int n = arr.length;
        int[]dp =new int[arr.length];
        
        dp[0] = arr[0].profit;
        
        for(int i=1;i<n;i++)
        {
            
            
            int currentProfit= arr[i].profit;
            int idx=findNon(arr,i);
            if(idx!=-1)
                currentProfit+=dp[idx];
            
            if(dp[i-1]< currentProfit) dp[i]=currentProfit;
            else dp[i] =dp[i-1];
        }
        
        return dp[n-1];
    }
    
//     int findNon(Pair[] arr,int idx)
//     {
        
//         for(int i=idx-1;i>=0;i--)
//         {
//             if(arr[i].end<=arr[idx].strt)
//             {
//                 return i;
//             }
//         }
//         return -1;
//     }
    
    int findNon(Pair[] arr,int idx)
    {
        int low=0;
        int hi= idx;
        
        while(low<=hi)
        {
            
            int mid=low+(hi-low)/2;
            
            if(arr[mid].end<=arr[idx].strt)
            {
                if(arr[mid+1].end<=arr[idx].strt)
                {
                    low=mid+1;
                }
                else
                {
                    return mid;
                }
            }
            else
            {
                hi=mid-1;
            }
        }
        return -1;
    }
    
    
}