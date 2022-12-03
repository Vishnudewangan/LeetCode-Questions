class Solution {
    public int edgeScore(int[] edges) {
     
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i]).add(i);
        }
        
        long cnt = Long.MIN_VALUE;
        int ans=-1;
        
        for(int i=0;i<adj.size();i++)
        {  
            long temp = 0;
           for(int nbr : adj.get(i))
           {
               temp +=nbr;
           }
            
            if(temp > cnt)
            {
                ans=i;
                cnt= temp;
            }
            else if(temp == cnt && i<ans)
            {
                ans=i;
            }
        }
        
        return ans;
        
    }
}