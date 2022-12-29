class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        for(int val : piles)
        {
            pq.add(val);
        }
        
        while(k>0)
        {
            int val = pq.remove();
            
            pq.add(val - val/2);
            k--;
        }
        
        int sum=0;
        while(pq.size()>0)
        {
            sum+=pq.remove();
        }
        
        return sum;
    }
}