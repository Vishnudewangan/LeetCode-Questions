class Solution {
    public List<String> topKFrequent(String[] words, int k) {
     
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<words.length;i++)
        {
            map.put(words[i] , map.getOrDefault(words[i],0)+1);
        }
        
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            int fa=map.get(a);
            int fb = map.get(b);
            if(fa == fb)
            {
                return b.compareTo(a);
            }
            return fa-fb;
        });
        
        
        for(String key : map.keySet())
        {
            pq.add(key);
            
            if(pq.size() > k)
            {
                pq.remove();
            }
        }
        
        List<String> list= new ArrayList<>();
        
        
        while(pq.size() >0)
        {
            list.add(pq.remove());
        }
        
         Collections.reverse(list);
        
        return list;
        
        
    }
}