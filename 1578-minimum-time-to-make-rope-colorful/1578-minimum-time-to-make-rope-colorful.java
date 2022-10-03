class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int minTime=0;
        
        char[] ch=colors.toCharArray();
        
        int longerTime = neededTime[0];
        
        for(int i=1;i< ch.length;i++)
        {
            if(ch[i]==ch[i-1])
            {
                minTime+= Math.min(longerTime, neededTime[i]);
                longerTime = Math.max(longerTime, neededTime[i]);
                
                
                
            }
            else{
            longerTime = neededTime[i];
           }
                                   
        }
        
        return minTime;
    }
}