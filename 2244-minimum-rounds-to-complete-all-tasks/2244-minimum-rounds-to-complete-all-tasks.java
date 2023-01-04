class Solution {
    static class Pair implements Comparable<Pair>
    {
        int val;
        int freq;
        
        Pair(int val, int freq)
        {
            this.val = val;
            this.freq = freq;
        }
        
        public int compareTo(Pair o)
        {
            return Integer.compare(this.freq,o.freq);
        }
        
    }
    public int minimumRounds(int[] tasks) {
        
        
       HashMap<Integer,Integer> map =new HashMap<>();
        
        
        for(int val : tasks)
        {
            map.put(val, map.getOrDefault(val,0)+1);
        }
        int ans=0;
        for(int val : map.values())
        {
            if(val==1) return -1;
            
            ans+=val/3;
            val%=3;
            ans+=(int)Math.ceil((val*1.0)/2);
            
        }
        
        return ans;
    }
}