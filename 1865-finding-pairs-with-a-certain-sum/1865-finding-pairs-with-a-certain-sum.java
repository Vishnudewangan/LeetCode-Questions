class FindSumPairs {
     int[] arr1;
     int[] arr2;
     HashMap<Integer,Integer> map =new HashMap<>();
    
    public FindSumPairs(int[] nums1, int[] nums2) {
         arr1 = nums1;
         arr2 = nums2;
        
        for(int i=0;i<nums2.length;i++)
        {
            map.put(nums2[i], map.getOrDefault(nums2[i],0)+1);
        }
    }
    public void add(int index, int val) {
          int currVal = arr2[index];
        
         if(map.get(currVal)==1)
         {
             map.remove(currVal);
         }
        else
        {
            map.put(currVal, map.get(currVal)-1);
        }
        arr2[index]+=val;
        map.put(arr2[index],map.getOrDefault(arr2[index],0)+1);
    }
    
    public int count(int tot) {
         
        int cnt =0;
        for(int i=0;i<arr1.length;i++)
        {     
            int reqNum = tot - arr1[i];
            if(map.containsKey(reqNum)==true)
            {
                cnt+=map.get(reqNum);
            }
        }
        
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */