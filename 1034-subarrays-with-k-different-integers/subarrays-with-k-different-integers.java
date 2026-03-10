class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums,k) - atMostKDistinct(nums,k-1);
    }

    private int atMostKDistinct(int[] nums, int k){
        int n = nums.length;

        //DataStructure

        HashMap<Integer,Integer> map = new HashMap<>();// val v/s freq

        // TP

        int tail = 0, head = -1;

        int ans = 0;// no. of subarrays with at most k distinct elements on it

        while( tail < n)
        {
            while(head + 1 < n && (map.size() < k || map.containsKey(nums[head+1]))){
                head++;
                
                map.put(nums[head], map.getOrDefault(nums[head],0)+1);
            }

            // ans , atmost k distinct elements on subarrays

            ans += head - tail + 1;

            if(tail <= head)
            {
                if(map.get(nums[tail]) == 1){
                    map.remove(nums[tail]);
                }
                else{
                    map.put(nums[tail],map.get(nums[tail])-1);
                }

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