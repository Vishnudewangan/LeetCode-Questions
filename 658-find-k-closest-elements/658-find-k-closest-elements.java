class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        int left = 0 , right = arr.length-1;
        
        while(right - left >=k)
        {
            if(x-arr[left] <= arr[right]-x)
            {
                right--;
            }
            else
            {
                left++;
            }
            
        }
         List<Integer> ans =new ArrayList<>();
        for(int i=left; i<=right;i++)
        {
            ans.add(arr[i]);
        }
        
        return ans;
    }
}