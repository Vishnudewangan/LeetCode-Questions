class Solution {
    public boolean hasAllCodes(String s, int k) {
       
        int need = 1<<k;
        
        HashSet<String> set =new HashSet<>();
        
        for(int i=k;i<=s.length();i++)
        {
            String temp = s.substring(i-k,i);
            
            if(set.contains(temp)==false)
            {
                set.add(temp);
                
                need--;
                
                if(need==0)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}