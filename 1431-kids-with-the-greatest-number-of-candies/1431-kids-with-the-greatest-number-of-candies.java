class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list =new ArrayList<>();
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<candies.length;i++)
        {
            max=Math.max(max , candies[i]);
        }
        
        for(int val : candies)
        {
            if(val+extraCandies >= max)
            {
                list.add(true);
            }
            else
            {
                list.add(false);
            }
        }
        
        return list;
    }
}