class Solution {
    public int minFlips(int a, int b, int c) {
        
        int cnt = 0;
        for(int i=0; i < 31; i++)
        {    int mask = (1 << i);
            int bitc = (c & mask );
            int bita = (a & mask );
            int bitb = (b & mask );
            if(bitc == 0 && bita == bitb && bita == 0) continue;

            if(bitc >= 1){
               if(bita == bitb && bita == 0) cnt++;
    
            }
            else{
               if(bita == bitb && bita >= 1) cnt = cnt + 2;
               else if((bita == 0 && bitb >= 1) || (bitb== 0 && bita >= 1)) cnt = cnt + 1;
            }
        }

        return cnt;
    }
}