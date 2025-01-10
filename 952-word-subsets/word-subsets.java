class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] bCount= count("");
        for(String str : words2)
        {
           int[] aRecieve= count(str);
             for(int i=0;i<26;i++)
             {
                 bCount[i] = Math.max(aRecieve[i],bCount[i]);
             }
            
        }
        
        List<String> list =new ArrayList<>();
        search : for(String str: words1)
        {
            int[] aCount=count(str);
            
            for(int i=0;i<26;i++)
            {
                   if(aCount[i] < bCount[i])
                   {
                       continue search;
                   }
                
            }
            list.add(str);
        }
        return list;
    }
    int[] count(String str)
    {
        int[] count = new int[26];
        
        for(char ch : str.toCharArray())
        {
            count[ch-'a']++;
        }
        
        return count;
    }
}