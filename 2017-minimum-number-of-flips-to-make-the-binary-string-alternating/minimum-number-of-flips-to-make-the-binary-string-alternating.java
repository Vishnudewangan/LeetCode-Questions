class Solution {
    public int minFlips(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
       
        sb.append(s);

        StringBuilder startWithOne = new StringBuilder("");
        StringBuilder startWithZero = new StringBuilder("");

        for(int i = 0 ; i < 2 * n; i++)
        {
            char ch1 = i%2 == 0 ? '1' : '0';
            char ch0 = i%2 == 0 ? '0' : '1';

            startWithOne.append(ch1);
            startWithZero.append(ch0);
        }
        
        int flip1 = 0;
        int flip0 = 0;

        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while(j < 2 * n){
            
            if(sb.charAt(j)!=startWithOne.charAt(j)) flip1++;
            if(sb.charAt(j) != startWithZero.charAt(j)) flip0++;


            if(j - i + 1 > n){
                if(sb.charAt(i) != startWithOne.charAt(i)) flip1--;
                if(sb.charAt(i) != startWithZero.charAt(i)) flip0--;

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