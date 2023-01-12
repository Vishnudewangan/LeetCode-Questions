class Solution {
     int[] ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            
        }
        
       
        
         ans =new int[n];
        
       int[] freq= dfs(0,-1,graph,labels);
        
        
        return ans;
    }
    
   int[] dfs(int src,int parent ,ArrayList<ArrayList<Integer>> graph,String labels)
    {
        
        int[] count = new int[26];
         
        for(int nbr : graph.get(src))
        {
            if(nbr!=parent)
            {   
                
                 int[] nbrCount=dfs(nbr ,src,graph,labels);
               
                for(int i=0;i<26;i++)
                {
                    count[i]+=nbrCount[i];
                }
                 
            }
            
        }
        count[labels.charAt(src)-'a']++;
       
       ans[src] = count[labels.charAt(src)-'a'];
       return count;
    }
}