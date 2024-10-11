class Solution {
    public int maxWidthRamp(int[] nums) {
       ArrayList<int[]> al = new ArrayList<>();
       int n= nums.length;
       for(int i=0;i<n ;i++)
       {
         al.add(new int[]{nums[i],i});
       }

       Collections.sort(al,(a,b)->{
          return a[0] - b[0];
       });

       int minIndex = al.get(0)[1];
       int ans= 0;
       for(int i=1;i<n;i++)
       {
          int currentIndex = al.get(i)[1];
          ans = Math.max(ans, currentIndex - minIndex);
          minIndex = Math.min(minIndex, currentIndex);
       }

       return ans;
    }
}