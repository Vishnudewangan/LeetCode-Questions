class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        String[] words = text.split(" ");

        char[] chrs = brokenLetters.toCharArray();
        int count = 0;
        for(String word : words){
            boolean isPresent= false;
            for(char ch : chrs){
                if(word.indexOf(ch)!=-1){
                    isPresent=true;
                    break;
                }
            }
            if(!isPresent)count++;
        }

        return count;
    }
}