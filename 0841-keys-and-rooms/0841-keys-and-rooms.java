class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] vis=new boolean[rooms.size()];
        
        dfs(0,rooms,vis);
        
        for(boolean val :vis)
        {
            if(val==false)
            {
                return false;
            }
        }
        
        return true;
        
    }
    
    void dfs(int src, List<List<Integer>> rooms,boolean[] vis)
    {
        vis[src]=true;
        
        for(int nbr : rooms.get(src))
        {
            if(vis[nbr]==false)
            {
                dfs(nbr,rooms,vis);
            }
        }
    }
}