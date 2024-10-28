class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer,Integer> map = new HashMap<>();

        int res = -1;

        for(int val : nums)
        {
            int sqrt = (int)(Math.sqrt(val));
             // checking if val is perfect square
            if(sqrt*sqrt == val && map.containsKey(sqrt))
            {
                map.put(val,map.get(sqrt)+1);
                res = Math.max(res, map.get(sqrt)+1);
            }
            else{
                map.put(val,1);
            }
        }
        return res;
    }
}