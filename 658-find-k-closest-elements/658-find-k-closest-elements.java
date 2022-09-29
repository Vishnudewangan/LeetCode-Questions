class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       
        
//         // O(n);
        
//         int left = 0 , right = arr.length-1;
        
//         while(right - left >=k)
//         {
//             if(x-arr[left] <= arr[right]-x)
//             {
//                 right--;
//             }
//             else
//             {
//                 left++;
//             }
            
//         }
//          List<Integer> ans =new ArrayList<>();
//         for(int i=left; i<=right;i++)
//         {
//             ans.add(arr[i]);
//         }
        
//         return ans;
        
        
        //  O(log(n-k))
        
        
      
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    
    }
}