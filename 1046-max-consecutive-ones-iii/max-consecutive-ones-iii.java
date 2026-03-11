class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        
        //ds
        int cntZero = 0;

        //TP

        int tail = 0, head = -1;

        int ans = 0;


        while(tail < n)
        {
            while(head + 1 < n && (nums[head+1]== 1 || cntZero < k)){
                head++;

                if(nums[head]==0)cntZero++;
            }

            /// ans
            ans  = Math.max(ans , head - tail +1);


            if(tail <= head)
            {
                if(nums[tail]==0)cntZero--;
                tail++;
            }
            else{
                tail++;
                head = tail - 1;
            }
        }
        return ans;
    }
}