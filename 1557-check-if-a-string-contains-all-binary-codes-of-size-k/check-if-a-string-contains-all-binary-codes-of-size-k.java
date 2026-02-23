class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int need = (1 << k); // no of Substrings need

        HashSet<String> set = new HashSet<>();

        for(int i = k ; i <= s.length() ; i++){

            String str = s.substring(i-k, i);

            if(set.contains(str) == false){
                set.add(str);

                need--;
               
                if(need == 0) return true;
            }

        }
        return false;
    }
}