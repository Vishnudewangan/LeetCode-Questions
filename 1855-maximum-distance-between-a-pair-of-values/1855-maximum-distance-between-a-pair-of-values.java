class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            int k = binarySearch(nums2, nums1[i]);
            if (k > i) {
                ans = Math.max(ans, k - i);
            }
        }
        return ans;
    }
    public int binarySearch(int[] nums, int a) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < a) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}