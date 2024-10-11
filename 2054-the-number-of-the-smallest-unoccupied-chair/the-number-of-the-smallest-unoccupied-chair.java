class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] arr = new int[n][2]; // arrival time and friend no

        for(int i=0;i<n;i++)
        {
            arr[i][0] = times[i][0];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(a,b)->{
            return a[0] - b[0];
        });

        PriorityQueue<Integer> avlblChair = new PriorityQueue<>();// will store avlblChair 
        for(int i=0;i<n;i++) avlblChair.add(i);

        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a,b)->{ // 0->leave time, 1->chair no.
            return a[0] - b[0];
        });

        for(int[] lev : arr)
        {
            int arvlTime = lev[0];
            int frndNo = lev[1];

            while(leavingQueue.size()>0 && leavingQueue.peek()[0]<= arvlTime){
                avlblChair.add(leavingQueue.remove()[1]);
            }

            int chair = avlblChair.remove();

            if(frndNo == targetFriend) return chair;

            leavingQueue.add(new int[]{times[frndNo][1], chair});
        }
         return -1; // we will not reach this line;
    }
}