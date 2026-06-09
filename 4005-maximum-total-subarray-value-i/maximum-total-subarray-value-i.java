class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(long val : nums){
            max = Math.max(val , max);
            min = Math.min(val, min);
        }
        return (max-min)*k;
    }
}