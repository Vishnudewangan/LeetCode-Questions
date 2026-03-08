class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();

        for(String val : nums) set.add(val);

        int n = nums.length;

        for(int i=0; i < (1 << n);i++)
        {
            StringBuilder sb = new StringBuilder();

            for(int bit=0;bit<n;bit++)
            {
                sb.append((i & 1 << bit) > 0 ? '1' : '0');

            }
            sb.reverse();
            if(set.contains(sb.toString())==false) return sb.toString();
        }

        return "";
    }
}