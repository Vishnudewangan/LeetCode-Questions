class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> oans = new HashSet<>();
        
        List<Integer> temp= new ArrayList<>();
        
        backtrack(nums,0,oans,temp);
        
        return new ArrayList(oans);
    }
    
    void backtrack(int[] arr, int idx,  Set<List<Integer>> oans, List<Integer> temp)
    {
        if(idx==arr.length)
        {
            if(temp.size()>=2)
            {
                oans.add(new ArrayList<>(temp));
            }
            
            return;
        }
        
        
        if(temp.size()==0 || temp.get(temp.size()-1) <= arr[idx])
        {
            temp.add(arr[idx]);
            
            backtrack(arr,idx+1,oans,temp);
            
            temp.remove(temp.size()-1);
        }
        
        backtrack(arr,idx+1,oans,temp);
    }
}