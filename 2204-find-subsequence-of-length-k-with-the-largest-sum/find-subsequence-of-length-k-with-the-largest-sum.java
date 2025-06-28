class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
          return a[0] -b[0];
      });
        
        for(int i=0;i<nums.length;i++)
        {
            pq.add(new int[]{nums[i],i});
            
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        
        List<int[]> list = new ArrayList<>();
        
        while(k-->0)
        {
            list.add(pq.remove());
        }
        
        Collections.sort(list, (a,b)->{
            return a[1]-b[1];
        });
        
        int[] ans = new int[list.size()];
        
        int idx=0;
        
       for(int i=0;i<list.size();i++)
        {    int[] arr = list.get(i);
            ans[idx++]=arr[0];
        }
        
        return ans;

    }
}