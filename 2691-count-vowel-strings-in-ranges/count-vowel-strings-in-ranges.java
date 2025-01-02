class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        int[] prefixSum = new int[words.length];

        int sum=0;
        for(int i=0;i<words.length;i++)
        {
            String word = words[i];

             if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1)))
             {
                sum++;
             }
             prefixSum[i] = sum;
        }

        int[] ans=new int[queries.length];

        for(int i=0;i<queries.length;i++)
        {
            int[] query = queries[i];

            int fi = query[0];
            int li = query[1];

            ans[i] = prefixSum[li] - (fi==0 ? 0 : prefixSum[fi-1]);
        }
        return ans;
    }
}