class Solution {
    public int numberOfSubstrings(String s) {
    

      return atleastOneABC(s);
    }
    private int atleastOneABC(String s)
    {
          
      int n = s.length();
      // ds
      int[] freq =new int[3];
      
      // tp
      int tail = 0, head = -1;
      int ans = 0;

      while(tail < n){
        
        while(head + 1 < n && check(s.charAt(head+1),freq)){
            head++;
            freq[s.charAt(head)-'a']++;
        }

        // ans

        ans += n-1 - (head + 1) + 1; // no of substring having atleadt 1 abc starting at tail

        if(tail <= head){
            freq[s.charAt(tail) - 'a']--;

            tail++;
        }
        else{
            tail++;
            head = tail - 1;
        }
      }

      return ans;
    }

    private boolean check(char ch, int[] freq)
    {
        int sumOfABC = 0;

        freq[ch -'a']++;

        if(freq[0]>0) sumOfABC++;
        if(freq[1]>0) sumOfABC++;
        if(freq[2]>0) sumOfABC++;

        freq[ch -'a']--;

        return sumOfABC < 3;
    }
}