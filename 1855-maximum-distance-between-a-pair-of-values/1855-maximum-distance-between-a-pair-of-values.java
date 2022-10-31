class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        /// *********Using Binary Search ************
//     int m = nums1.length, n = nums2.length;
//         int ans = 0;

//         for (int i = 0; i < m; ++i) {
//             int k = binarySearch(nums2, nums1[i]);
//             if (k > i) {
//                 ans = Math.max(ans, k - i);
//             }
//         }
//         return ans;
//     }
//     public int binarySearch(int[] nums, int a) {
//         int left = 0, right = nums.length - 1;
//         while (left < right) {
//             int mid = left + (right - left + 1) / 2;
//             if (nums[mid] < a) {
//                 right = mid - 1;
//             } else {
//                 left = mid;
//             }
//         }
//         return left;
        
        ////****** Using two Pointer
        
        int n=nums1.length, m = nums2.length, p1=0,p2=0;
        int ans =0;
        
        while(p1<n && p2<m)
        {
            if(nums1[p1] > nums2[p2])
            {
                p1++;
            }
            else
            {
                ans = Math.max(ans, p2-p1);
                p2++;
            }
        }
        
        return ans;
        
        
    }
}