class Solution {
    static class Pair implements Comparable<Pair>{
        int enqTime;
        int prcTime;
        int idx;
        
        Pair(int i,int p, int id)
        {
            enqTime = i;
            prcTime = p;
            idx = id;
        }
        
        public int compareTo(Pair o)
        {
            if(this.prcTime == o.prcTime)
            {
                return this. idx - o.idx;
            }
            else
            {
                return this.prcTime - o.prcTime;
            }
        }
    }
    public int[] getOrder(int[][] tasks) {
        
      
        
        int n= tasks.length;
        
        Pair[] input = new Pair[n];
        for(int i=0;i<n;i++)
        {
            input[i] = new Pair(tasks[i][0],tasks[i][1],i);
        }
          Arrays.sort(input,(a,b)->{
            return a.enqTime - b.enqTime;
        });
        
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        
        int[] res = new int[n];
        
        int ri = 0; // result index;
        int ini= 0; // input index;
        int time=0;
        
        while(ri < n)
        {
            while(ini < n  && input[ini].enqTime<=time)
            {
                pq.add(input[ini++]);
            }
            
            if(pq.size()==0)
            {
                time = input[ini].enqTime;
                continue;
            }
            
            res[ri++] = pq.peek().idx;
            time +=pq.peek().prcTime;
            pq.remove();
            
            
        }
        
        return res;
        
    }
}