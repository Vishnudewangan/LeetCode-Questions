class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map =new HashMap<>();
        
        for(int val : answers)
            map.put(val, map.getOrDefault(val, 0)+1);
        
        int minRabbits=0;
        
        for(int key : map.keySet())
        {
            int val=map.get(key);
            
            int groupSize = key+1;
            
            minRabbits+=Math.ceil((val*1.0)/groupSize)*groupSize;
            
            
        }
        
        return minRabbits;
    }
}