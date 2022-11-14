class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        
        ArrayList<Integer>[] graph =new ArrayList[n];
        
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(manager[i]!=-1)
            {
                graph[manager[i]].add(i);
            }
        }
        
        Queue<int[]> que=new ArrayDeque<>();
        
        que.add(new int[]{headID,0});
        
        int ans=0;
        
        while(que.size()>0)
        {
            int[] rem=que.remove();
            
            int empId=rem[0];
            int infrmTime = rem[1];
            
             ans=Math.max(ans, infrmTime);
            
            for(int v : graph[empId])
            {
                que.add(new int[]{v, infrmTime+informTime[empId]});
            }
        }
        
        return ans;
    }
}