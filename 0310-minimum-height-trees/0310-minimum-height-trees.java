class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
         List<Integer> res =new ArrayList<>();
         if(n<=0) return res;
         
        if(n<=1)
        {
            res.add(0);
            return res;
        }
        
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
         int[] degree = new int[n];
        
        for(int i=0;i<n;i++)
        {
            degree[i] = graph.get(i).size();
        }
        
        Queue<Integer> leaves=new ArrayDeque<>();
        
        for(int i=0;i<n;i++)
        {
            if(degree[i]==1)
            {
                leaves.add(i);
            }
        }
        int count=n;
        while(count > 2)
        {     int size = leaves.size();
         
             count = count - size;
            for(int i=0;i<size;i++)
            {
                int leaf = leaves.remove();

                for(int nbr : graph.get(leaf))
                {
                    degree[nbr]--;

                    if(degree[nbr]==1) leaves.add(nbr);
                }
            }
        }
        
        return new ArrayList<>(leaves);
    }
}