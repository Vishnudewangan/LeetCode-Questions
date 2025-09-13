class Solution {
    public int maxFreqSum(String s) {
        
        int[] freq =new int[26];
        
        int vowelFreq = 0;
        int consFreq = 0;
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            if("aeiou".contains(ch+""))vowelFreq = Math.max(vowelFreq,freq[ch-'a']);
            else consFreq = Math.max(consFreq, freq[ch-'a']);
        }
        return vowelFreq + consFreq;
    }
}