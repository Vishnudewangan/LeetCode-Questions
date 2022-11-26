class Solution {
     public int maxTwoEvents(int[][] events) 
    {
        Arrays.sort(events , (a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        int max = 0 , ans = 0;
        pq.add(new int[]{events[0][1] , events[0][2]});
        
        for(int i=1 ; i<events.length ; i++)
        {
            while(!pq.isEmpty() && pq.peek()[0]<events[i][0])
            {
                int a[] = pq.poll();
                max = Math.max(max , a[1]);
            }
            ans = Math.max(ans , max + events[i][2]);
            pq.add(new int[]{events[i][1] , events[i][2]});
        }
        while(!pq.isEmpty())
        {
            ans = Math.max(ans , pq.poll()[1]);
        }
        
        return ans;
    }
}