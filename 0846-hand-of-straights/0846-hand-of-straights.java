class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        
        for(int val : nums)pq.add(val);
        
        while(!pq.isEmpty())
        {
            int curr = pq.remove();
            
            for(int i=1;i<k;i++)
            {
               if(!pq.remove(curr+i)) return false;
            }
        }
        return true;
    }
}