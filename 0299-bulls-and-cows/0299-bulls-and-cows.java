class Solution {
    public String getHint(String secret, String guess) {
        int[] secretFreq=new int[10];
        
        int bulls=0;
        int cows = 0;
        HashSet<Integer> hs=new HashSet<>();
        
        for(int i=0;i<secret.length();i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
            {
                hs.add(i);
                bulls++;
            }
            else
            {
                secretFreq[secret.charAt(i)-'0']++;
            }
        }
        
        for(int i=0;i<guess.length();i++)
        {
            
            if(hs.contains(i)==true) continue;
            if(secretFreq[guess.charAt(i)-'0']>=1)
            {
                cows++;
                secretFreq[guess.charAt(i)-'0']--;
            }
        }
        
        return bulls+"A" +cows+"B";
        
        
        
    }
}