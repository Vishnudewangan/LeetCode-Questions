class Solution {
    public boolean canCross(int[] stones) {
        
        HashMap<Integer,HashSet<Integer>> stoneVSJumpUnit = new HashMap<>();
        
        for(int i=0;i<stones.length;i++)
        {
            stoneVSJumpUnit.put(stones[i],new HashSet<>());
            
        }
        
        stoneVSJumpUnit.get(stones[0]).add(1);
        
        for(int i=0;i<stones.length;i++)
        {
            int stone = stones[i];
            
            for(int jump : stoneVSJumpUnit.get(stone))
            {
                int nextStone = stone + jump;
                
                if(nextStone == stones[stones.length-1]) return true;
                
                if(stoneVSJumpUnit.containsKey(nextStone)==true)
                {
                    if(jump-1>=0) stoneVSJumpUnit.get(nextStone).add(jump-1);
                    stoneVSJumpUnit.get(nextStone).add(jump);
                    stoneVSJumpUnit.get(nextStone).add(jump+1);
                }
            }
        }
        
        return false;
    }
}