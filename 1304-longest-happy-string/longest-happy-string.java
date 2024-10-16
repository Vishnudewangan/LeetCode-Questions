class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((x,y)->{ //max priority queue
            return y[0] -x[0];
        });

        if(a>0) pq.add(new int[]{a,'a'});
        if(b>0) pq.add(new int[]{b,'b'});
        if(c>0) pq.add(new int[]{c,'c'});

        StringBuilder sb =new StringBuilder();

        while(pq.size()>0)
        {
            int[] first = pq.remove();

            if(sb.length() >=2 && sb.charAt(sb.length()-1) == first[1] && sb.charAt(sb.length()-2) == first[1])
            {
               if(pq.size()==0) break;

                int[] second = pq.remove();

                sb.append((char)(second[1]));
                second[0]--;

                if(second[0]>0)
                {
                    pq.add(second);
                }      
                pq.add(first); 
            }
            else
            {
                sb.append((char)(first[1]));
                first[0]--;
                if(first[0] >0) pq.add(first);
            }
        }
        return sb.toString();
    }
}