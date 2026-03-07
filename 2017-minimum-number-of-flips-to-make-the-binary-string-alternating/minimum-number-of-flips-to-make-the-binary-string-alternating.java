class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int flip1 = 0;
        int flip0 = 0;

        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while(j < 2 * n){
            
            char ch1 = j % 2 == 0 ? '1' : '0';
            char ch0 = j % 2 == 0 ? '0' : '1';

            if(s.charAt(j % n) != ch1) flip1++;
            if(s.charAt(j % n) != ch0) flip0++;

            if(j - i + 1 > n){
               
               char oldCh1 = i % 2 == 0 ? '1' : '0';
               char oldCh0 = i % 2 == 0 ? '0' : '1';

               if(s.charAt(i % n) != oldCh1) flip1--;
               if(s.charAt(i % n) != oldCh0) flip0--;

               i++;
            }

            if(j - i + 1 == n) {
                ans = Math.min(ans, Math.min(flip1 , flip0));
            }
            j++;
        }

        return ans;
    }
}