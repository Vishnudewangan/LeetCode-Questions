class Solution {
    public int countHillValley(int[] nums) {
        
       ArrayList<Integer> al =new ArrayList<>();
        
        al.add(nums[0]);
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                al.add(nums[i]);
            }
        }
        int count=0;
        
        for(int i=1;i<al.size()-1;i++)
        {
            
            if((al.get(i)>al.get(i-1) && al.get(i) >al.get(i+1)) || (al.get(i)< al.get(i-1) && al.get(i)< al.get(i+1)))
                count++;
            
        }
        return count;
        
    }
}