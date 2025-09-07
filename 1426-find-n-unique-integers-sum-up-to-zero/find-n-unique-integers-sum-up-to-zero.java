class Solution {
    public int[] sumZero(int n) {
        List<Integer> list =new ArrayList<>();
        for(int i=1;i<=n/2;i++)
        {
           list.add(i);
           list.add(-1*i);
        }
        if(n%2==1)list.add(0);

        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();

        return ans;
    }
}