class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val : trainers)
        {
            pq.add(val);
        }
         int count=0;
        for(int i=0;i<players.length;i++)
        {
            while(pq.size() >0  && pq.peek()<players[i]) pq.remove();
            if(pq.size()>0){
              count++;
              pq.remove();
            }
            else break;
        }
        return count;
    }
}