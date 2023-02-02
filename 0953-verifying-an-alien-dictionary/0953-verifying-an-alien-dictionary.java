class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       
        HashMap<Character , Integer> map =new HashMap<>();
        
        for(int i=0;i<order.length();i++)
        {
            map.put(order.charAt(i),i);
        }
        
        for(int i=1;i<words.length;i++)
        {
             if(areWordsLexicographically(words[i-1],words[i],map)==false)
             {
                 return false;
             }
        }
        return true;
    }
    
    boolean areWordsLexicographically(String word1 , String word2, HashMap<Character,Integer> map )
    {
        
        
        int minLength = Math.min(word1.length(),word2.length());
        
        int i=0;
        while(i<minLength)
        {
            if(word1.charAt(i) != word2.charAt(i))
            {
                return map.get(word1.charAt(i)) < map.get(word2.charAt(i));
            }
            i++;
        }
        
        return word1.length() <= word2.length();
    }
}