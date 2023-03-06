class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<arr.length;i++)
       {
           hs.add(arr[i]);
       }

       int ele = 1;
       int cnt=0;
       int ans =1;

       while(cnt < k)
       {
           if(hs.contains(ele)==false)
           {
               cnt++;
               ans=ele;
           }

           ele++;
       }

       return ans;
    }
}