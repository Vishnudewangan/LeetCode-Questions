class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        List<Integer> topoSortRow = topoSort(rowConditions,k);
        if(topoSortRow.size()!=k) return new int[][]{};
        List<Integer> topoSortCol = topoSort(colConditions,k);
        if(topoSortCol.size()!=k) return new int[][]{};

        Collections.reverse(topoSortRow);// we need compilation order, so reversing 
        Collections.reverse(topoSortCol);// 
        
        Map<Integer, int[]> map = new HashMap<>();// val v/s [rowPosOfVal,colPosOfVal]
        
        for(int i=1;i<=k;i++){
            map.put(i,new int[2]);
        }
       for(int i=0;i<topoSortRow.size();i++)
       {
          map.get(topoSortRow.get(i))[0] = i;
       }
       for(int i=0;i<topoSortCol.size();i++)
       {
        map.get(topoSortCol.get(i))[1]=i;
       }

       int[][] ans= new int[k][k];

       for(int i=1;i<=k;i++)
       {
         ans[map.get(i)[0]][map.get(i)[1]] = i;
       }
      
      return ans;

    }
    List<Integer> topoSort(int[][] grid, int k)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=k;i++)
        {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[k+1];
        for(int[] edge : grid)
        {   graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> que = new ArrayDeque<>();
        for(int i=1;i<=k;i++)
        {
            if(indegree[i]==0)
            {
             que.add(i);
            }
        }
        List<Integer> topoSort = new ArrayList<>();
        while(que.size()>0)
        {
            int size=que.size();
            for(int i=0;i<size;i++)
            {
               int rem = que.remove();
               topoSort.add(rem);
               for(int child=0; child<graph.get(rem).size();child++)
               {  int nbr = graph.get(rem).get(child);
                  indegree[nbr]--;
                  if(indegree[nbr]==0)
                  {
                    que.add(nbr);
                  }
               }
            }
        }
        return topoSort;
    }
}

