class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] lastOccurance=new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            lastOccurance[ch -'a'] = i; 
        }
        
        int maxReach=0;
        int cntOfElementInmaxReach = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            
            maxReach=Math.max(maxReach , lastOccurance[s.charAt(i)-'a']);
           cntOfElementInmaxReach++;
            if(maxReach==i)
            {
                 ans.add(cntOfElementInmaxReach);
                cntOfElementInmaxReach=0;
            }
            
        }
        
        return ans;
        
    }
}