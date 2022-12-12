class Solution {
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set =new HashSet<>();
        
        for(String str : nums)
        {
            set.add(str);
        }
        
        ans="";
        
        helper(nums.length,set,new StringBuilder());
        
        return ans;
    }
    
    void helper(int n, HashSet<String> set,StringBuilder sb)
    {
        if(sb.length()==n)
        {
            if(set.contains(sb.toString())==false)
            {
                ans=sb.toString();
            }
            return;
        }
        
        for(int i=0;i<2;i++)
        {
            sb.append(i);
            helper(n,set,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}