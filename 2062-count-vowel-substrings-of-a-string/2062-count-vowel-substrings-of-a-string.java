class Solution {
    public int countVowelSubstrings(String word) {
        int n= word.length();
        int ansCnt=0;
       
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
       
        for(int i=0;i<n;i++)
        {    HashMap<Character,Integer> map=new HashMap<>();
             
            char ch= word.charAt(i);
            if(hs.contains(ch)==true)
            {
                map.put(ch,1);
            }
            else
            {
                continue;
            }
            for(int j=i+1;j<n;j++)
            {
                if(hs.contains(word.charAt(j))==false)
                {
                    break;
                }
                else
                {
                    map.put(word.charAt(j),map.getOrDefault(word.charAt(j),0)+1);
                }
                
                if(map.size()==5)
                {
                    ansCnt++;
                }
            }
        }
        
        return ansCnt;
    }
}