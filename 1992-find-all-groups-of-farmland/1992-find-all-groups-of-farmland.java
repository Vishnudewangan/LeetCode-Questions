class Solution {
    public int[][] findFarmland(int[][] land) {
        
        boolean[][] vis=new boolean[land.length][land[0].length];
        ArrayList<int[]> ans=new ArrayList<>();
        
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[0].length;j++)
            {
                if(land[i][j]==1 && vis[i][j] == false)
                {
                    int[] temp = new int[4];
                    temp[0] = i;
                    temp[1] =j;
                    
                    int[] fo=new int[2];
                    dfs(i,j,land,vis,fo);
                    
                    temp[2]= fo[0];
                    temp[3] = fo[1];
                    ans.add(temp);
                }
            }
        }
        
    return ans.toArray(new int[ans.size()][4]);
        
        
    }
    
    void dfs(int i, int j, int[][] land,boolean[][] vis,int[] fo)
    {
        if(i<0 || j<0 || i>=land.length || j>=land[0].length || vis[i][j] == true || land[i][j]==0)
        {
            return ;
        }
        
        vis[i][j] = true;
        fo[0] = Math.max(i,fo[0]);
        fo[1] = Math.max(j,fo[1]);
        
        dfs(i-1,j,land,vis,fo);
        dfs(i,j+1,land,vis,fo);
        dfs(i+1,j,land,vis,fo);
        dfs(i,j-1,land,vis,fo);
    }
}