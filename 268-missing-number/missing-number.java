class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums)
                  .sum();
        return (n*(n+1))/2  - sum ;
    }
}