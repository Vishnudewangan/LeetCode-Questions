class Solution {
    public int maxDifference(String s) {
        int[] freq =new int[26];

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }

        int maxOddFreq=Integer.MIN_VALUE;
        int minEvenFreq = Integer.MAX_VALUE;

        for(int val : freq)
        {
            if(val!=0 && (val&1)==0)
            {
                minEvenFreq = Math.min(minEvenFreq,val);
            }
            else
            {
                maxOddFreq = Math.max(maxOddFreq,val);
            }
        }
        return maxOddFreq - minEvenFreq;
    }
}