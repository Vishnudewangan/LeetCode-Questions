class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] word1 = sentence1.split(" ");
        String[] word2 = sentence2.split(" ");

        if(word1.length < word2.length) { // to make sure word1 is largest String
            String[] temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int start = 0;
        int end=0;

        int n1 = word1.length;
        int n2 = word2.length;

        while(start < n2 && word1[start].equals(word2[start])){
            start++;
        }

        while(end < n2 && word1[n1-end-1].equals(word2[n2-end-1])){
            end++;
        }

        return start + end >= n2;


    }
}