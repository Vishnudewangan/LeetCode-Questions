class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         
        int n= nums1.length;
        int m =nums2.length;
        
        if(n> m)
        {
           return findMedianSortedArrays(nums2,nums1);
        }
        
        
        int start=0, end = n;
        
        double res=0;
        
        while(start <=end)
        {
            int i1= (start+end)/2;
            
            int i2 = (n+m+1)/2 - i1;
            
            
            int min1= i1==n ? Integer.MAX_VALUE : nums1[i1];
            int max1 = i1==0 ? Integer.MIN_VALUE: nums1[i1-1];
            
            int min2= i2==m ? Integer.MAX_VALUE : nums2[i2];
            int max2 = i2==0 ? Integer.MIN_VALUE : nums2[i2-1];
            
             if(max1 <= min2 && max2<= min1)
             {
                 if((n+m)%2 ==0)
                 {
                     res = (Math.max(max1,max2) + Math.min(min1,min2))*0.5;
                 }
                 else
                 {
                     res = Math.max(max1,max2);
                 }
                 break;
             }
            else if(max1 > min2)
            {
                end =i1 -1;
                
            }
            else
            {
                start= i1+1;
            }
        }
        
        return res;
    }
//      int n = nums1.length;
//         int m = nums2.length;
        
//         //make sure first array should have smaller length.
//         if(n > m){
//             return findMedianSortedArrays(nums2,nums1);
//         }
        
//         int start = 0;
//         int end = n;
        
//         double res = 0;
        
//         while(start <= end){
//             int i1 = (start + end)/2;
//             int i2 = (n + m + 1)/2 - i1;
            
// 			//handle edge cases
//             int min1 = (i1 == n) ? Integer.MAX_VALUE : nums1[i1];  // this always go right. basically handling if mid at index n
//             int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1]; // this always go to left. basically handling if mid at index 0
                
//             int min2 = (i2 == m) ? Integer.MAX_VALUE : nums2[i2];
//             int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];
            
// 			//condition for sorted partition
//             if((max1 <= min2) && (max2 <=min1)){
//                 if((n+m)%2 == 0){
//                      // divding by will 2 gives wrong result hennce mulitpy by 0.5 or divide by 2.0 not 2
//                     res = (Math.max(max1,max2) + Math.min(min1,min2))*0.5;
//                 }
//                 else{
// 				//median in case of odd.
//                     res = Math.max(max1,max2);
//                 }
//                 break;
//             }
//             else if(max1 > min2){ //means wrong element selected in set. it should be smaller. Shift to left or one step back.
//                 end = i1-1;
//             }
//             else{
//                 start = i1+1;  //shift right
//             }
//         }
//         return res;
}