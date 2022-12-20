class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
             ans.add(index[i],nums[i]);
        }
        
        int[] fres =new int[ans.size()];
        
          for(int i=0;i<ans.size();i++)
          {
              fres[i] = ans.get(i);
          }
        
        return fres;
    }
}