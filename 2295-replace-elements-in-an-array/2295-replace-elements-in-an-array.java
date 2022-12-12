class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        HashMap<Integer,Integer> map =new HashMap<>();// value v/s index
        
        for(int i=0;i<nums.length;i++)
        {
           map.put(nums[i],i); 
        }
        
        for(int i=0;i<operations.length;i++)
        {
            int valtbc=operations[i][0];// value to be changed
            int valtbcw = operations[i][1];// value to be changed with
            
             int idx= map.get(valtbc);
            map.remove(valtbc);
             
             map.put(valtbcw, idx);
            nums[idx]=valtbcw;
        
        }
        
       
        return nums;
        
    }
}