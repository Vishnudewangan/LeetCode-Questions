class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] non_dec = new int[n], non_inc = new int[n];
        Arrays.fill(non_dec, 1);
        Arrays.fill(non_inc, 1);
        for (int i = 1; i < n; ++i) {
            if (nums[i] <= nums[i - 1]) {
                non_inc[i] = non_inc[i - 1] + 1;
            }
            if (nums[i] >= nums[i - 1]) {
                non_dec[i] = non_dec[i - 1] + 1;
            }
        }
        List<Integer> good = new ArrayList<>();
        for (int i = k; i < n - k; ++i) {
            if (non_inc[i - 1] >= k && non_dec[i + k] >= k) {
                good.add(i);
            }
        }
        return good;
    }
}