class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[n][2];
        dp[n-1][0] = n;
        dp[n-1][1] = 1;
        int longestListSize = 1;
        int longestListSizeIndex = n-1;
        for (int i = n-2; i >= 0; i--) {
            int maxIndex = n;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0 && (maxIndex == n || dp[j][1] > dp[maxIndex][1]))  {
                    maxIndex = j;
                }
            }
            dp[i][0] = maxIndex;
            dp[i][1] = (maxIndex == n ? 0 : dp[maxIndex][1]) + 1;
            if (longestListSize < dp[i][1]) {
                longestListSize = dp[i][1];
                longestListSizeIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int i = longestListSizeIndex;
        while (i < n) {
            res.add(nums[i]);
            i = dp[i][0];
        }
        return res;
    }
}