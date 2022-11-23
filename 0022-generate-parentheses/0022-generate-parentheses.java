class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans=new ArrayList<>();
        
        helper("(", 1,0,n,ans);
        
        return ans;
    }
    
    void helper(String str , int ob, int cb, int n, List<String> ans)
    {
        if(str.length()== 2*n)
        {
            ans.add(str);
            return;
        }
        
        if(ob < n) helper(str+'(',ob+1,cb,n,ans);
        if(cb<ob) helper(str+')' , ob,cb+1,n,ans);
    }
}