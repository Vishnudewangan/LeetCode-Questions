class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for(int i=0;i<n;i++)
        {
           String currWord = words[(i%n)];
           String nextWord = words[((i+1)%n)];

           char lcocw = currWord.charAt(currWord.length()-1);//last character of current word
           char fconw = nextWord.charAt(0); // first character of next word
           if(lcocw !=fconw) return false;
        }
        return true;
    }
}