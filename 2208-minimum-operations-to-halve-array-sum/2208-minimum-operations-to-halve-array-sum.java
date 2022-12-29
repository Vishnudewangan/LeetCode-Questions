class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue<Double> pq =new PriorityQueue<>(Collections.reverseOrder());
        
        double sum=0;
        for(int val : nums)
        {
            sum+=val;
            pq.add(val*1.0);
        }
        
        double val= sum;
        int count=0;
        while(sum > val/2)
        {
            double temp = pq.remove();
            
            sum-=temp/2;
            pq.add(temp - temp/2);
            count++;
        }
        
        return count;
    }
}