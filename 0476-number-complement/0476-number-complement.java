class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        // System.out.println(str);
        int ans=0;
        int pow = 1;
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i)=='0')
            {
                ans+=pow;
            }
            
            pow*=2;
        }
        return ans;
    }
}