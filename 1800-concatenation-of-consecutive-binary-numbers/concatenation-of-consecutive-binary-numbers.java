class Solution {
    public int concatenatedBinary(int n) {
        String str = "";
        int mod = 1000000007;
        for(int i=1; i<=n; i++){
            str+=Integer.toBinaryString(i);
            long val = Long.parseLong(str,2);
            val = val%mod;
            str = Long.toBinaryString(val);
        }
        return (int)Long.parseLong(str,2);
    }
}