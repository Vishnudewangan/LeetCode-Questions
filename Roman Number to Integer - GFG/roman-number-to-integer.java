//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String num) {
         if (num.length() == 0)
      return 0;

    if (num.charAt(0) == 'M')
      return 1000+romanToDecimal(num.substring(1));

    if (num.charAt(0) == 'D')
      return 500 + romanToDecimal(num.substring(1));

    if (num.charAt(0) == 'C') {
      if (num.length() == 1)
        return 100;
      if (num.charAt(1) == 'M')
        return 900 + romanToDecimal(num.substring(2));
      if (num.charAt(1) == 'D')
        return 400 + romanToDecimal(num.substring(2));
      return 100 + romanToDecimal(num.substring(1));
    }

    if (num.charAt(0) == 'L')
      return 50 + romanToDecimal(num.substring(1));

    if (num.charAt(0) == 'X') {
      if (num.length() == 1)
        return 10;
      if (num.charAt(1) == 'C')
        return 90 + romanToDecimal(num.substring(2));
      if (num.charAt(1) == 'L')
        return 40 + romanToDecimal(num.substring(2));
      return 10 + romanToDecimal(num.substring(1));
    }

    if (num.charAt(0) == 'V')
      return 5 + romanToDecimal(num.substring(1));

    if (num.length() == 1)
      return 1;
    if (num.charAt(1) == 'X')
      return 9 + romanToDecimal(num.substring(2));
    if (num.charAt(1) == 'V')
      return 4 + romanToDecimal(num.substring(2));
    return 1 + romanToDecimal(num.substring(1));
    }
}