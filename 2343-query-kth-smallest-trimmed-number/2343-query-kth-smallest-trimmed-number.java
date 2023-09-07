class Solution {
    static class Pair
    {
        String s;
        int idx;
        
        Pair(String str, int i)
        {
            this.s = str;
            this.idx = i;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        HashMap<Integer,List<Pair>> map =new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            String str = nums[i];
            
            int n = str.length();
            int l = n;
            
            for(int j=0;j<n;j++)
            {
                map.putIfAbsent(l,new ArrayList<>());
                
                String sub = str.substring(j);
                
                map.get(l--).add(new Pair(sub,i));
                
            }
        }
        
         int[] ans=new int[queries.length];
         int i=0;
        for(int[] query : queries)
        {
            int kth = query[0];
            int sub = query[1];
            
            List<Pair> list = map.get(sub);
            Collections.sort(list,(a,b)->{
                if(a.s.equals(b.s))
                {
                    return a.idx - b.idx;
                }
                return a.s.compareTo(b.s);
            });
            
            ans[i++] = list.get(kth-1).idx;
        }
        
        return ans;
    }
}