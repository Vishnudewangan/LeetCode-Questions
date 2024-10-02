class Solution {
    static class Pair
    {
        int ele;
        int idx;
        Pair(int ele,int idx)
        {
            this.ele=ele;
            this.idx=idx;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
          if(arr.length==0) return new int[]{};
        ArrayList<Pair> ans=new ArrayList<>();
          for(int i=0;i<arr.length;i++)
          {
              ans.add(new Pair(arr[i],i));
          }
        
        Collections.sort(ans,(a,b)->{
            return a.ele - b.ele; 
        });
        int rank=1;
        int[] nums=new int[arr.length];
        
        nums[ans.get(0).idx]=rank;
        
        for(int i=1;i<arr.length;i++)
        {
            if(ans.get(i-1).ele==ans.get(i).ele)
            {
                nums[ans.get(i).idx]=rank;
            }
            else
            { 
                rank++;
                nums[ans.get(i).idx]=rank;
            }
           
        }
        
        
        return nums;
        
    }
}