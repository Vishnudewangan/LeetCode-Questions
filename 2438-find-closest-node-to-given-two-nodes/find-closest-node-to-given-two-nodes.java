class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        
        int[] dist1=new int[n];
        int[] dist2= new int[n];
        
        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);
        
        dist1[node1] = 0;
        dist2[node2] = 0;
        
        int i = node1;
        int dist= 0;
        
        
        // dfs in this way -> because only one out degree is possible
        while(true)
        {
            dist1[i] = dist++;
            
            i = edges[i];
            
            if(i== -1 || dist1[i]!= -1) break;
        }
        
        
        i = node2;
        dist = 0;
        
        while(true)
        {
            dist2[i]  = dist++;
            
            i = edges[i];
            
            if(i==-1 || dist2[i]!=-1) break;
        }
        
        // for(int j=0;j<n;j++)
        // {
        //     System.out.println(dist1[j]+"  " + dist2[j]);
        // }
        
        int ans = -1;
        int min = Integer.MAX_VALUE;
       
        
        for(i=0;i<n;i++)
        {
            if(dist1[i]==-1 || dist2[i]==-1) continue;
             int max = Math.max(dist1[i], dist2[i]);
            if(min > max )
            { 
                
                ans = i;
                min = max;
            }
        }
        
        return ans;
    }
}