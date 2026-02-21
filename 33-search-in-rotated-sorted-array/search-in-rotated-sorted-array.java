class Solution {
    public int search(int[] nums, int target) {
        int n= nums.length;

        int pivot = binarySearch(0, n-1, 0, nums);
        
        //System.out.println(pivot);

        if(target >= nums[0]&&(pivot!=0 && target <= nums[pivot-1])){
            return binarySearch(0, pivot-1, -1, target, nums);

        }
        else{
            return binarySearch(pivot, n-1, -1, target, nums);
        }


    }
    private int binarySearch(int lo, int hi, int ans,int target, int[] nums)
    {   
        
          while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;

            if(check(mid,nums,target)==1){

                ans = mid;
                //System.out.println(ans);
               return ans;
            }
            else if(check(mid, nums, target)==2){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
    private int binarySearch(int lo, int hi, int pivot, int[] nums){
          while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;

            if(check(mid,nums)==1){
                pivot = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return pivot;
    }

    private int check(int mid, int[] nums){

        if(nums[mid] < nums[0]) return 1;
        else return 0;
    }

    private int check(int mid , int[] nums, int target){
        if(nums[mid] == target) return 1;
        else if(nums[mid] < target) return 2;
        else return -1;
    }
}