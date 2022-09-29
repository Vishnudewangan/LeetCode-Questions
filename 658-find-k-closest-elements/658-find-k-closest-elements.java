class Solution {
      static class Pair implements Comparable<Pair>
      {
          int gap ;
          int val;
          Pair(int gap, int val)
          {
              this.gap = gap;
              this.val = val;
          }
          
          public int compareTo(Pair o)
          {
              if(o.gap == this.gap)
              {
                  return  o.val-this.val;
              }
              else
              {
                  return o.gap-this.gap;
              }
          }
      }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++)
        {
            pq.add(new Pair(Math.abs(arr[i]-x), arr[i]));
            
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        
        List<Integer> ans =new ArrayList<>();
        
        while(pq.size()>0)
        {
            ans.add(pq.remove().val);
        }
        
        Collections.sort(ans);
        
        return ans;
        
        
        
        
        
    }
    
}