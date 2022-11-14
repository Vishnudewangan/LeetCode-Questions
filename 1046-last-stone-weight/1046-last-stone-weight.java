class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
         return b-a;
        });
        
        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }
        
        while(pq.size()>1)
        {
            int y=pq.remove();
            int x=pq.remove();
            
            if(y==x)
            {
                
            }
            else
            {
                if(y-x>0)pq.add(y-x);
            }
          }
        
        return pq.size()>0? pq.peek(): 0;
            
           
        }
    }
            