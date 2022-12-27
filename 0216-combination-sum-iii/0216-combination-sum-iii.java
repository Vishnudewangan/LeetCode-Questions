class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(k,n,0,ans,new ArrayList<>());
        
        return ans;
    }
    
    void helper(int k,int n,int lastUsed,List<List<Integer>> ans,List<Integer> asf)
    {
        if(k==0 )
        {  
            if(n==0)
            ans.add(new ArrayList<>(asf));
            return;
        }
        
        for(int i=lastUsed+1;i<=9;i++)
        {
            asf.add(i);
            helper(k-1,n-i,i,ans,asf);
            asf.remove(asf.size()-1);
            
            // helper(k,n,i,ans,asf);
            
        }
    }
}